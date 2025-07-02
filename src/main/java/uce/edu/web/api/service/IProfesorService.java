package uce.edu.web.api.service;

import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.repository.model.Profesor;

import java.util.List;

public interface IProfesorService {
    public Profesor buscarProfesorId(Integer id);

    List<Profesor> buscarTodos();
    void guardar(Profesor profesor);
    void actualizarPorId(Profesor profesor);
    void actualizarParcialPorId(Profesor profesor);
    void borrarPorId(Integer id);
}
