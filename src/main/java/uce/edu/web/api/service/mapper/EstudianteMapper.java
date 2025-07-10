package uce.edu.web.api.service.mapper;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.to.EstudianteTO;

public class EstudianteMapper {

    public static EstudianteTO toTO(Estudiante estudiante) {
        EstudianteTO estudianteTO = new EstudianteTO();
        estudianteTO.setId(estudiante.getId());
        estudianteTO.setNombre(estudiante.getNombre());
        estudianteTO.setApellido(estudiante.getApellido());
        estudianteTO.setGenero(estudiante.getGenero());
        estudianteTO.setFechaNacimiento(estudiante.getFechaNacimiento());

        return estudianteTO;
    }


    public static Estudiante toEntity(EstudianteTO estudianteTO) {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(estudianteTO.getId());
        estudiante.setNombre(estudianteTO.getNombre());
        estudiante.setApellido(estudianteTO.getApellido());
        estudiante.setFechaNacimiento(estudianteTO.getFechaNacimiento());
        estudiante.setGenero(estudianteTO.getGenero());

        return estudiante;
    }
}
