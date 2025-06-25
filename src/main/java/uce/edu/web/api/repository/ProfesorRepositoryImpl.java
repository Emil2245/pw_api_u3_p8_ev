package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.model.Profesor;

@Transactional
@ApplicationScoped
public class ProfesorRepositoryImpl implements IProfesorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Profesor seleccionarProfesorId(Integer id) {
        return this.entityManager.find(Profesor.class, id);
    }


}
