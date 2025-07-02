package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.model.Profesor;
import uce.edu.web.api.repository.model.Profesor;
import uce.edu.web.api.service.IProfesorService;

import java.util.List;

@Path("/profesores")
public class ProfesorController {

    @Inject
    private IProfesorService iProfesorService;

    @Path("/consultar/{id}")
    @GET
    public Profesor consultarProfesorId(@PathParam("id") Integer id) {
        return this.iProfesorService.buscarProfesorId(id);
    }

    @GET
    @Path("")
    public List<Profesor> consultarTodos() {
        return this.iProfesorService.buscarTodos();
    }

    @POST
    @Path("")
    public void guardar(@RequestBody Profesor profesor) {
        this.iProfesorService.guardar(profesor);

    }

    @PUT
    @Path("/{id}")
    public void actualizar(@RequestBody Profesor profesor, @PathParam("id") Integer id) {
        profesor.setId(id);
        this.iProfesorService.actualizarPorId(this.iProfesorService.buscarProfesorId(id));
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcial(@RequestBody Profesor profesor, @PathParam("id") Integer id) {
        Profesor actual = this.iProfesorService.buscarProfesorId(id);
        if(profesor.getApellido() != null) actual.setApellido(profesor.getApellido());
        if(profesor.getFechaNacimiento() != null) actual.setFechaNacimiento(profesor.getFechaNacimiento());
        if(profesor.getNombre() != null) actual.setNombre(profesor.getNombre());
        this.iProfesorService.actualizarParcialPorId(actual);

    }

    @DELETE
    @Path("/{id}")
    public void borrarPorId(@PathParam("id") Integer id) {
        this.iProfesorService.borrarPorId(id);
    }
}
