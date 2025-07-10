package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.model.Hijo;

public interface IHijoRepository {
    public List<Hijo> buscarPorEstudianteId(Integer id);
    void insertarHijo(Hijo hijo);
}