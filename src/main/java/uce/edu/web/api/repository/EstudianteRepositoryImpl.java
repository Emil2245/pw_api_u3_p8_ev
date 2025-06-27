package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.model.Estudiante;

import java.util.List;

@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements IEstudianteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante seleccionarEstudianteId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        TypedQuery<Estudiante> query = this.entityManager.createQuery("select e from Estudiante e", Estudiante.class);
        return query.getResultList();
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizarPorId(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void actualizarParcialPorId(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminarPorId(Integer id) {
        this.entityManager.remove(this.seleccionarEstudianteId(id));
    }


}
