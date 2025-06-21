package uce.edu.web.api.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uce.edu.web.api.repository.model.Estudiante;

public interface IEstudianteRepository {
    public Estudiante seleccionarEstudianteId(Integer id);
}
