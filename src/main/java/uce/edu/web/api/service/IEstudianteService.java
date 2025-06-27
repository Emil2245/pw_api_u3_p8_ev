package uce.edu.web.api.service;

import uce.edu.web.api.repository.model.Estudiante;

import java.util.List;

public interface IEstudianteService {
    Estudiante buscarEsudianteId(Integer id);
    List<Estudiante> buscarTodos();
    void guardar(Estudiante estudiante);
    void actualizarPorId(Estudiante estudiante);
    void actualizarParcialPorId(Estudiante estudiante);
    void borrarPorId(Integer id);

}
