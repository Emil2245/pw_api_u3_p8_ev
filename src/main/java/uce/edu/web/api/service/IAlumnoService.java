package uce.edu.web.api.service;

import uce.edu.web.api.repository.model.Alumno;
import uce.edu.web.api.repository.model.Hijo;

import java.util.List;

public interface IAlumnoService {
    public List<Alumno> buscarPorProfesorId(Integer id);
}
