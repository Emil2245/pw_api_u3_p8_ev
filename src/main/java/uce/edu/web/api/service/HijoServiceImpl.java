package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IHijoRepository;
import uce.edu.web.api.repository.model.Hijo;

@ApplicationScoped
public class HijoServiceImpl implements IHijoService {

    @Inject
    private IHijoRepository iHijoRepository;

    @Override
    public List<Hijo> buscarPorEstudianteId(Integer id) {
        return this.iHijoRepository.buscarPorEstudianteId(id);
    }

}
