package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.hibernate.annotations.Type;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.IEstudianteService;

import java.util.List;

@Path("/estudiantes")
public class EstudianteController {
    @Inject
    private IEstudianteService iEstudianteService;

    @GET
    @Path("/consultar/{id}")
    @Operation(
            summary = "Consultar Estudiante",
            description = "Este endpoint/capacidad permite buscar un estudiante"
    )
//    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarEstudianteId(@PathParam("id") Integer id) {
        return Response.status(227).entity(this.iEstudianteService.buscarEsudianteId(id)).build();
    }

//    @GET
//    @Path("")
//    public List<Estudiante> consultarTodos() {
//        return this.iEstudianteService.buscarTodos();
//    }

    @GET
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarTodos(@QueryParam("genero") String genero,
                                           @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        return Response.status(Response.Status.ACCEPTED)
                .entity(this.iEstudianteService.buscarTodos(genero))
                .build();
    }

    @POST
    @Path("")
//    @Consumes(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Guardar Estudiante",
             description = "Este endpoint/capacidad permite registrar un nuevo estudiante"
    )
    public void guardar(@RequestBody Estudiante estudiante) {
        this.iEstudianteService.guardar(estudiante);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void actualizar(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {
        estudiante.setId(id);
        this.iEstudianteService.actualizarPorId(this.iEstudianteService.buscarEsudianteId(id));
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {
        Estudiante actual = this.iEstudianteService.buscarEsudianteId(id);
        if(estudiante.getApellido() != null) actual.setApellido(estudiante.getApellido());
        if(estudiante.getFechaNacimiento() != null) actual.setFechaNacimiento(estudiante.getFechaNacimiento());
        if(estudiante.getNombre() != null) actual.setNombre(estudiante.getNombre());
        this.iEstudianteService.actualizarParcialPorId(actual);

    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void borrarPorId(@PathParam("id") Integer id) {
        this.iEstudianteService.borrarPorId(id);
    }
}
