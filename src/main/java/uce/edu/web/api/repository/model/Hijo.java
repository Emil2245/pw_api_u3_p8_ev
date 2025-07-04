package uce.edu.web.api.repository.model;

import jakarta.persistence.Table;

public class Hijo {
    private String nombre;

    public Hijo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
