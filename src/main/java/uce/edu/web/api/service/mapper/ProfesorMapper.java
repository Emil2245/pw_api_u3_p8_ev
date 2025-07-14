package uce.edu.web.api.service.mapper;

import uce.edu.web.api.repository.model.Profesor;
import uce.edu.web.api.service.to.ProfesorTO;

public class ProfesorMapper {

    public static ProfesorTO toTO(Profesor profesor) {
        ProfesorTO profesorTO = new ProfesorTO();
        profesorTO.setId(profesor.getId());
        profesorTO.setNombre(profesor.getNombre());
        profesorTO.setApellido(profesor.getApellido());
        profesorTO.setFechaNacimiento(profesor.getFechaNacimiento());
        profesorTO.setEspecialidad(profesor.getEspecialidad());

        return profesorTO;
    }


    public static Profesor toEntity(ProfesorTO profesorTO) {
        Profesor profesor = new Profesor();
        profesor.setId(profesorTO.getId());
        profesor.setNombre(profesorTO.getNombre());
        profesor.setApellido(profesorTO.getApellido());
        profesor.setEspecialidad(profesorTO.getEspecialidad());
        profesor.setEsTiempoCompleto(profesorTO.getEsTiempoCompleto());
        profesor.setFechaNacimiento(profesorTO.getFechaNacimiento());

        return profesor;
    }
}
