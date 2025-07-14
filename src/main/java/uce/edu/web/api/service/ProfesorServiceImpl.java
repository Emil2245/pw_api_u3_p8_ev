package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.IProfesorRepository;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.repository.model.Profesor;
import uce.edu.web.api.service.to.EstudianteTO;
import uce.edu.web.api.service.to.ProfesorTO;

import java.util.List;

@ApplicationScoped
public class ProfesorServiceImpl implements IProfesorService {
    @Inject
    private IProfesorRepository iProfesorRepository;


    @Override
    public List<Profesor> buscarTodos() {
        return this.iProfesorRepository.seleccionarTodos();
    }

    @Override
    public Profesor buscarProfesorId(Integer id) {
        return iProfesorRepository.seleccionarProfesorId(id);
    }

    @Override
    public void guardar(Profesor profesor) {
        this.iProfesorRepository.insertar(profesor);
    }

    @Override
    public void actualizarPorId(Profesor profesor) {
        this.iProfesorRepository.actualizarPorId(profesor);
    }

    @Override
    public void actualizarParcialPorId(Profesor profesor) {
        this.iProfesorRepository.actualizarParcialPorId(profesor);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.iProfesorRepository.eliminarPorId(id);
    }
}
