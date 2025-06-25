package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IProfesorRepository;
import uce.edu.web.api.repository.model.Profesor;

@ApplicationScoped
public class ProfesorServiceImpl implements IProfesorService {
    @Inject
    private IProfesorRepository iProfesorRepository;


    @Override
    public Profesor buscarProfesorId(Integer id) {
        return iProfesorRepository.seleccionarProfesorId(id);
    }
}
