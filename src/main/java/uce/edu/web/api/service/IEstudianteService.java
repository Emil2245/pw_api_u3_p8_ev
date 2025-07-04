package uce.edu.web.api.service;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.to.EstudianteTO;

import java.util.List;

public interface IEstudianteService {
    EstudianteTO buscarEsudianteId(Integer id, UriInfo uriInfo);
//    List<Estudiante> buscarTodos();
    List<Estudiante> buscarTodos(String genero);
    void guardar(Estudiante estudiante);
    void actualizarPorId(Estudiante estudiante);
    void actualizarParcialPorId(Estudiante estudiante);
    void borrarPorId(Integer id);

}
