package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.model.Profesor;

import java.util.List;

@Transactional
@ApplicationScoped
public class ProfesorRepositoryImpl implements IProfesorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Profesor seleccionarProfesorId(Integer id) {
        return this.entityManager.find(Profesor.class, id);
    }

    @Override
    public void insertar(Profesor profesor) {
        this.entityManager.persist(profesor);
    }

    @Override
    public void actualizarPorId(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

    @Override
    public void actualizarParcialPorId(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

    @Override
    public void eliminarPorId(Integer id) {
        this.entityManager.remove(this.seleccionarProfesorId(id));
    }

    @Override
    public List<Profesor> seleccionarTodos() {
        return this.entityManager
                .createQuery("select p from Profesor p", Profesor.class)
                .getResultList();
    }
}
