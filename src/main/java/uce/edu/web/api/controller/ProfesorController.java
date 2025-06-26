package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
}
