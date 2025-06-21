package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.model.Estudiante;

@ApplicationScoped
public class EstudianteServiceImpl  implements  IEstudianteService{
    @Inject
    private IEstudianteRepository iEstudianteRepository;


    @Override
    public Estudiante buscarEsudianteId(Integer id) {
        return iEstudianteRepository.seleccionarEstudianteId(id);
    }
}
