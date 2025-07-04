package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.to.EstudianteTO;

import java.util.List;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {
    @Inject
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public EstudianteTO buscarEsudianteId(Integer id, UriInfo uriInfo) {
        Estudiante estudiante = iEstudianteRepository.seleccionarEstudianteId(id);

        return new EstudianteTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getFechaNacimiento(),
                estudiante.getGenero(),
                uriInfo
        );
    }

    //    @Override
//    public List<Estudiante> buscarTodos() {
//        return this.iEstudianteRepository.seleccionarTodos();
//    }
    @Override
    public List<Estudiante> buscarTodos(String genero) {
        return this.iEstudianteRepository.seleccionarTodos(genero);
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
