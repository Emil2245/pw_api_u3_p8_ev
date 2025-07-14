package uce.edu.web.api.repository;

import uce.edu.web.api.repository.model.Alumno;
import uce.edu.web.api.repository.model.Hijo;

import java.util.List;

public interface IAlumnoRepository {
    public List<Alumno> buscarPorProfesorId(Integer id);
    void insertarAlumno(Alumno alumno);
}
