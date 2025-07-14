package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IAlumnoRepository;
import uce.edu.web.api.repository.IHijoRepository;
import uce.edu.web.api.repository.model.Alumno;
import uce.edu.web.api.repository.model.Hijo;

import java.util.List;

@ApplicationScoped
public class AlumnoServiceImpl implements IAlumnoService {

    @Inject
    private IAlumnoRepository iAlumnoRepository;

    @Override
    public List<Alumno> buscarPorProfesorId(Integer id) {
        return this.iAlumnoRepository.buscarPorProfesorId(id);
    }

}
