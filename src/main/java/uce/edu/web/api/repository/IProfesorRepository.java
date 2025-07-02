package uce.edu.web.api.repository;

import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.repository.model.Profesor;

import java.util.List;

public interface IProfesorRepository {
    public Profesor seleccionarProfesorId(Integer id);

    List<Profesor> seleccionarTodos();
    void insertar(Profesor profesor);
    void actualizarPorId(Profesor profesor);
    void actualizarParcialPorId(Profesor profesor);
    void eliminarPorId(Integer id);
}
