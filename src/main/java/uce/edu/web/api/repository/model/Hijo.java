package uce.edu.web.api.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hijo")
public class Hijo {

    @Id
    @GeneratedValue
    @Column(name = "hijo_id")
    private Integer id;

    @Column(name = "hijo_nombre")
    private String nombre;

    @Column(name = "hijo_apellido")
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "hijo_estudiante")
    private Estudiante estudiante;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
