package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.model.Alumno;
import uce.edu.web.api.repository.model.Hijo;

import java.util.List;

@ApplicationScoped
@Transactional
public class AlumnoRepositoryImpl implements IAlumnoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public List<Alumno> buscarPorProfesorId(Integer id) {
        TypedQuery<Alumno> myQuery = this.entityManager.createQuery("SELECT h FROM Alumno h WHERE h.profesor.id =:id",
                Alumno.class);
        myQuery.setParameter("id", id);
        return myQuery.getResultList();
    }

    @Override
    public void insertarAlumno(Alumno alumno) {

    }
}
