package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
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
    public Estudiante consultarEstudianteId(@PathParam("id") Integer id) {
        return this.iEstudianteService.buscarEsudianteId(id);
    }

//    @GET
//    @Path("")
//    public List<Estudiante> consultarTodos() {
//        return this.iEstudianteService.buscarTodos();
//    }
    @GET
    @Path("")
    public List<Estudiante> consultarTodos(@QueryParam("genero") String genero,
                                           @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        return this.iEstudianteService.buscarTodos(genero);
    }

    @POST
    @Path("")
    @Operation(
            summary = "Guardar Estudiante",
             description = "Este endpoint/capacidad permite registrar un nuevo estudiante"
    )
    public void guardar(@RequestBody Estudiante estudiante) {
        this.iEstudianteService.guardar(estudiante);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {
        estudiante.setId(id);
        this.iEstudianteService.actualizarPorId(this.iEstudianteService.buscarEsudianteId(id));
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathParam("id") Integer id) {
        Estudiante actual = this.iEstudianteService.buscarEsudianteId(id);
        if(estudiante.getApellido() != null) actual.setApellido(estudiante.getApellido());
        if(estudiante.getFechaNacimiento() != null) actual.setFechaNacimiento(estudiante.getFechaNacimiento());
        if(estudiante.getNombre() != null) actual.setNombre(estudiante.getNombre());
        this.iEstudianteService.actualizarParcialPorId(actual);

    }

    @DELETE
    @Path("/{id}")
    public void borrarPorId(@PathParam("id") Integer id) {
        this.iEstudianteService.borrarPorId(id);
    }
}
