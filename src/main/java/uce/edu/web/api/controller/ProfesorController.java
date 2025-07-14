package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.IAlumnoRepository;
import uce.edu.web.api.repository.model.Alumno;
import uce.edu.web.api.repository.model.Hijo;
import uce.edu.web.api.repository.model.Profesor;
import uce.edu.web.api.service.IAlumnoService;
import uce.edu.web.api.service.IProfesorService;
import uce.edu.web.api.service.mapper.ProfesorMapper;
import uce.edu.web.api.service.to.ProfesorTO;

import java.util.List;

@Path("/profesores")
public class ProfesorController {

    @Inject
    UriInfo uriInfo;
    @Inject
    private IProfesorService iProfesorService;

    @Inject
    private IAlumnoService iAlumnoService;

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/consultar/{id}")
    public Response consultarProfesorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        ProfesorTO profesorTO = ProfesorMapper.toTO(this.iProfesorService.buscarProfesorId(id));
        profesorTO.buildURI(uriInfo);

        return Response.ok().entity(profesorTO).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response consultarTodos(@Context UriInfo uriInfo) {
        List<ProfesorTO> profesorTOList = this.iProfesorService.buscarTodos()
                .stream()
                .map( profesor ->
                {
                    ProfesorTO profesorTO =ProfesorMapper.toTO(profesor);
                    profesorTO.buildURI(uriInfo);
                    return profesorTO;
                }).toList();

        return Response.ok().entity(profesorTOList).build();
    }

    @POST
    @Path("")
    public Response guardar(@RequestBody ProfesorTO profesorTO) {
        try {
            this.iProfesorService.guardar(ProfesorMapper.toEntity(profesorTO));
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response actualizar(@RequestBody ProfesorTO profesorTO, @PathParam("id") Integer id) {
        profesorTO.setId(id);
        try {
            this.iProfesorService.actualizarPorId(ProfesorMapper.toEntity(profesorTO));
            return Response.ok().build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response actualizarParcial(@RequestBody ProfesorTO profesorTO, @PathParam("id") Integer id) {
        Profesor actual = this.iProfesorService.buscarProfesorId(id);
        if (actual == null) return Response.status(Response.Status.NOT_FOUND).build();

        if (profesorTO.getApellido() != null) actual.setApellido(profesorTO.getApellido());
        if (profesorTO.getFechaNacimiento() != null) actual.setFechaNacimiento(profesorTO.getFechaNacimiento());
        if (profesorTO.getNombre() != null) actual.setNombre(profesorTO.getNombre());
        this.iProfesorService.actualizarParcialPorId(actual);

        return Response.ok().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response borrarPorId(@PathParam("id") Integer id) {
        try {
            this.iProfesorService.borrarPorId(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/alumnos")
    public List<Alumno> obtenerAlumnosPorId(@PathParam("id") Integer id) {

        return this.iAlumnoService.buscarPorProfesorId(id);

    }
}
