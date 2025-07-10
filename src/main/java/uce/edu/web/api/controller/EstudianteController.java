package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.repository.model.Hijo;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.IHijoService;
import uce.edu.web.api.service.mapper.EstudianteMapper;
import uce.edu.web.api.service.to.EstudianteTO;

import java.util.List;

@Path("/estudiantes")
public class EstudianteController {
    @Inject
    private IEstudianteService iEstudianteService;
    @Inject
    private IHijoService iHijoService;

    @GET
    @Path("/consultar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consultar Estudiante", description = "Este endpoint/capacidad permite buscar un estudiante")
    public Response consultarEstudianteId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        EstudianteTO estudianteTO = EstudianteMapper.toTO(this.iEstudianteService.buscarEsudianteId(id));
        estudianteTO.buildURI(uriInfo);

        return Response.status(200)
                .entity(estudianteTO)
                .build();
    }

//    @GET
//    @Path("")
//    public List<Estudiante> consultarTodos() {
//        return this.iEstudianteService.buscarTodos();
//    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response consultarTodos(@QueryParam("genero") String genero, @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        return Response.ok().entity(this.iEstudianteService.buscarTodos(genero)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Guardar Estudiante", description = "Este endpoint/capacidad permite registrar un nuevo estudiante")
    public Response guardar(@RequestBody Estudiante estudiante) {
        this.iEstudianteService.guardar(estudiante);
        return Response.status(Response.Status.CREATED).build();
    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Response actualizar(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {
//        estudiante.setId(id);
//        Estudiante actual = this.iEstudianteService.buscarEsudianteId(id);
//        if (actual == null) return Response.status(Response.Status.NOT_FOUND).build();
//
//        this.iEstudianteService.actualizarPorId(actual);
//        return Response.ok().build();
//    }

//    @PATCH
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Response actualizarParcial(@RequestBody Estudiante estudiante, @PathParam("id") Integer id, @Context UriInfo uriInfo) {
//        EstudianteTO actual = this.iEstudianteService.buscarEsudianteId(id, uriInfo);
//        if (actual == null) return Response.status(Response.Status.NOT_FOUND).build();
//
//        if (estudiante.getApellido() != null) actual.setApellido(estudiante.getApellido());
//        if (estudiante.getFechaNacimiento() != null) actual.setFechaNacimiento(estudiante.getFechaNacimiento());
//        if (estudiante.getNombre() != null) actual.setNombre(estudiante.getNombre());
//        this.iEstudianteService.actualizarParcialPorId(actual);
//
//        return Response.ok().build();
//    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.iEstudianteService.borrarPorId(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}/hijos")
    public List<Hijo> obtenerHijosPorId(@PathParam("id") Integer id) {

        return this.iHijoService.buscarPorEstudianteId(id);


    }
}
