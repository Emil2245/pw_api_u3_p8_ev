package uce.edu.web.api.repository.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof-id")
    private Integer id;
    @Column(name = "prof-nombre")
    private String nombre;
    @Column(name = "prof-apellido")
    private String apellido;
    @Column(name = "prof-especialidad")
    private String especialidad;
    @Column(name = "prof-es-tiempo-completo")
    private Boolean esTiempoCompleto;
    @Column(name = "prof-fecha-nacimiento")
    private LocalDateTime fechaNacimiento;

    //////////////////


    //////////////////GETTERS SETTERS
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
}
