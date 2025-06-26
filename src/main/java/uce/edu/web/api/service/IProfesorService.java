package uce.edu.web.api.service;

import uce.edu.web.api.repository.model.Profesor;

import java.util.List;

public interface IProfesorService {
    public Profesor buscarProfesorId(Integer id);

    List<Profesor> buscarTodos();
}
