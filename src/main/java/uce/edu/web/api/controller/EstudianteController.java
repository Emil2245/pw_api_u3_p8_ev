package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.IEstudianteService;

import java.util.List;

@Path("/estudiantes")
public class EstudianteController {
    @Inject
    private IEstudianteService iEstudianteService;
    @Path("/consultar/{id}")
    @GET
    public Estudiante consultarEstudianteId(@PathParam("id") Integer id){
        return this.iEstudianteService.buscarEsudianteId(id);
    }

    @GET
    @Path("")
    public List<Estudiante> consultarTodos(){
        return this.iEstudianteService.buscarTodos();
    }

    @POST
    @Path("")
    public void guardar(@RequestBody Estudiante estudiante){

    }


    @PUT
    @Path("/{id}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathParam("id") Integer id){

    }
    @PATCH
    @Path("/{id}")
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathParam("id") Integer id){

    }

    @DELETE
    @Path("/{id}")
    public void borrarPorId(@PathParam("id") Integer id){

    }
}
