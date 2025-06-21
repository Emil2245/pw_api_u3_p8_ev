package uce.edu.web.api.repository.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estu-id")
    private Integer id;
    @Column(name = "estu-nombre")
    private String nombre;
    @Column(name = "estu-apellido")
    private String apellido;
    @Column(name = "estu-fecha-nacimiento")
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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
