package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.model.Hijo;
import uce.edu.web.api.repository.model.Profesor;
import uce.edu.web.api.service.IProfesorService;

import java.util.List;

@Path("/profesores")
public class ProfesorController {

    @Inject
    private IProfesorService iProfesorService;

    @Path("/consultar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response consultarProfesorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {

        return Response.ok()
                .entity(this.iProfesorService.buscarProfesorId(id,uriInfo))
                .build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public List<Profesor> consultarTodos() {
        return this.iProfesorService.buscarTodos();
    }

    @POST
    @Path("")
    public Response guardar(@RequestBody Profesor profesor) {
        try {
            this.iProfesorService.guardar(profesor);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Response actualizar(@RequestBody Profesor profesor, @PathParam("id") Integer id) {
//        profesor.setId(id);
//        try {
//            this.iProfesorService.actualizarPorId(this.iProfesorService.buscarProfesorId(id));
//            return Response.ok().build();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//    }

//    @PATCH
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Response actualizarParcial(@RequestBody Profesor profesor, @PathParam("id") Integer id) {
//        Profesor actual = this.iProfesorService.buscarProfesorId(id);
//        if (actual == null) return Response.status(Response.Status.NOT_FOUND).build();
//
//        if (profesor.getApellido() != null) actual.setApellido(profesor.getApellido());
//        if (profesor.getFechaNacimiento() != null) actual.setFechaNacimiento(profesor.getFechaNacimiento());
//        if (profesor.getNombre() != null) actual.setNombre(profesor.getNombre());
//        this.iProfesorService.actualizarParcialPorId(actual);
//
//        return Response.ok().build();
//    }

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
    @Path("/{id}/hijos")
    public List<Hijo> obtenerHijosPorId(@PathParam("id") Integer id) {

        return List.of(new Hijo("pepito"),
                new Hijo("Juanito"));

    }
}
