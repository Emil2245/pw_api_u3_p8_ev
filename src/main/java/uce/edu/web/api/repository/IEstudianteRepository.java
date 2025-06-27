package uce.edu.web.api.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import uce.edu.web.api.repository.model.Estudiante;

import java.util.List;

public interface IEstudianteRepository {
    Estudiante seleccionarEstudianteId(Integer id);
    List<Estudiante> seleccionarTodos();
    void insertar(Estudiante estudiante);
    void actualizarPorId(Estudiante estudiante);
    void actualizarParcialPorId(Estudiante estudiante);
    void eliminarPorId(Integer id);
}
