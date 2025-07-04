package uce.edu.web.api.service;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.repository.model.Profesor;
import uce.edu.web.api.service.to.ProfesorTO;

import java.util.List;

public interface IProfesorService {
    ProfesorTO buscarProfesorId(Integer id, @Context UriInfo uriInfo);

    List<Profesor> buscarTodos();
    void guardar(Profesor profesor);
    void actualizarPorId(Profesor profesor);
    void actualizarParcialPorId(Profesor profesor);
    void borrarPorId(Integer id);
}
