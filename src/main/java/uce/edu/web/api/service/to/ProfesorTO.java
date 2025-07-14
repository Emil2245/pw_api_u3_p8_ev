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
    private Map<String, String> _links = new HashMap<>();
    /// //////////////

    //URI /////////////
    public void buildURI (UriInfo uriInfo){
        URI uriSelf = uriInfo.getBaseUriBuilder()
                .path(ProfesorController.class)
                .path(ProfesorController.class,"consultarProfesorId")
                .build(this.id);
        _links.put("self", uriSelf.toString());

        URI uriDelete = uriInfo.getBaseUriBuilder()
                .path(ProfesorController.class)
                .path(this.id.toString())
                .build();
        _links.put("delete", uriDelete.toString());

        URI uriUpdate = uriInfo.getBaseUriBuilder()
                .path(ProfesorController.class)
                .path(this.id.toString())
                .build();
        _links.put("update", uriUpdate.toString());

        URI todosAlumnos=  uriInfo.getBaseUriBuilder()
                .path(ProfesorController.class)
                .path(ProfesorController.class, "obtenerAlumnosPorId")
                .build(id);
        _links.put("alumnos", todosAlumnos.toString());
    }

    //GETTERS /SETTERS /////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Boolean getEsTiempoCompleto() {
        return esTiempoCompleto;
    }

    public void setEsTiempoCompleto(Boolean esTiempoCompleto) {
        this.esTiempoCompleto = esTiempoCompleto;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Map<String, String> get_links() {
        return _links;
    }

    public void set_links(Map<String, String> _links) {
        this._links = _links;
    }
}

