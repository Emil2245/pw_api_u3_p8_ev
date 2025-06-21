package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.IEstudianteService;

@Path("/estudiantes")
public class EstudianteController {
    @Inject
    private IEstudianteService iEstudianteService;
    @Path("/consultar/{id}")
    @GET
    public Estudiante consultarEstudianteId(@PathParam("id") Integer id){
        return this.iEstudianteService.buscarEsudianteId(id);
    }
}
