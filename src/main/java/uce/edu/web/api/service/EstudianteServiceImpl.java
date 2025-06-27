package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.model.Estudiante;

import java.util.List;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {
    @Inject
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public Estudiante buscarEsudianteId(Integer id) {
        return iEstudianteRepository.seleccionarEstudianteId(id);
    }

    @Override
    public List<Estudiante> buscarTodos() {
        return this.iEstudianteRepository.seleccionarTodos();
    }

    @Override
    public void guardar(Estudiante estudiante) {
        this.iEstudianteRepository.insertar(estudiante);
    }

    @Override
    public void actualizarPorId(Estudiante estudiante) {
        this.iEstudianteRepository.actualizarPorId(estudiante);
    }

    @Override
    public void actualizarParcialPorId(Estudiante estudiante) {
        this.iEstudianteRepository.actualizarParcialPorId(estudiante);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.iEstudianteRepository.eliminarPorId(id);

    }
}
