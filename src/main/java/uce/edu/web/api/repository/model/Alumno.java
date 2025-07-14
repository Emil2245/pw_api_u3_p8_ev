package uce.edu.web.api.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "alum")
public class Alumno {

    @Id
    @GeneratedValue
    @Column(name = "alum_id")
    private Integer id;

    @Column(name = "alum_nombre")
    private String nombre;

    @Column(name = "alum_apellido")
    private String apellido;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alum_profesor")
    private Profesor profesor;


}
