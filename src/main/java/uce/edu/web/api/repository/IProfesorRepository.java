package uce.edu.web.api.repository;

import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.repository.model.Profesor;

public interface IProfesorRepository {
    public Profesor seleccionarProfesorId(Integer id);
}
