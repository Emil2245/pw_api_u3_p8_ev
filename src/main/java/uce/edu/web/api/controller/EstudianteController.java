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


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response consultarTodos(@QueryParam("genero") String genero,
                                   @QueryParam("provincia") String provincia, @Context UriInfo uriInfo) {

        List<EstudianteTO> estudianteTOList = this.iEstudianteService.buscarTodos(genero)
                .stream()
                .map(estudiante -> {
                    EstudianteTO estudianteTO = EstudianteMapper.toTO(estudiante);
                    estudianteTO.buildURI(uriInfo);
                    return estudianteTO;
                })
                .toList();

        System.out.println(provincia);

        return Response.ok().entity(estudianteTOList).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Guardar Estudiante", description = "Este endpoint/capacidad permite registrar un nuevo estudiante")
    public Response guardar(@RequestBody EstudianteTO estudianteTO) {
        this.iEstudianteService.guardar(EstudianteMapper.toEntity(estudianteTO));
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response actualizar(@RequestBody EstudianteTO estudianteTO, @PathParam("id") Integer id) {
        estudianteTO.setId(id);
        Estudiante actual = this.iEstudianteService.buscarEsudianteId(id);
        if (actual == null) return Response.status(Response.Status.NOT_FOUND).build();

        this.iEstudianteService.actualizarPorId(EstudianteMapper.toEntity(estudianteTO));
        return Response.ok().build();
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response actualizarParcial(@RequestBody EstudianteTO estudianteTO, @PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Estudiante actual = this.iEstudianteService.buscarEsudianteId(id);
        if (actual == null) return Response.status(Response.Status.NOT_FOUND).build();

        if (estudianteTO.getApellido() != null) actual.setApellido(estudianteTO.getApellido());
        if (estudianteTO.getFechaNacimiento() != null) actual.setFechaNacimiento(estudianteTO.getFechaNacimiento());
        if (estudianteTO.getNombre() != null) actual.setNombre(estudianteTO.getNombre());
        this.iEstudianteService.actualizarParcialPorId(actual);

        return Response.ok().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.iEstudianteService.borrarPorId(id);
        return Response.noContent().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/hijos")
    public List<Hijo> obtenerHijosPorId(@PathParam("id") Integer id) {
        return this.iHijoService.buscarPorEstudianteId(id);
    }
}
