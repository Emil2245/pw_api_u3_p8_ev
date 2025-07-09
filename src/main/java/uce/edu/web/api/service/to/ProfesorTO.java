package uce.edu.web.api.service.to;

import jakarta.persistence.Column;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.controller.EstudianteController;
import uce.edu.web.api.controller.ProfesorController;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ProfesorTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private Boolean esTiempoCompleto;
    private LocalDateTime fechaNacimiento;
    public Map<String, String> _links = new HashMap<>();

    public ProfesorTO(Integer id, String nombre, String apellido, String especialidad, Boolean esTiempoCompleto, LocalDateTime fechaNacimiento, UriInfo uriInfo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.esTiempoCompleto = esTiempoCompleto;
        this.fechaNacimiento = fechaNacimiento;

        URI todosHijos=  uriInfo.getBaseUriBuilder()
                .path(ProfesorController.class)
                .path(ProfesorController.class, "obtenerHijosPorId")
                .build(id);

        _links.put("hijos", todosHijos.toString());
    }
}

