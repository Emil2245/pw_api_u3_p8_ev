package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.model.Hijo;

import java.util.List;

@ApplicationScoped
@Transactional
public class HijoRepositoryImpl implements IHijoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public List<Hijo> buscarPorEstudianteId(Integer id) {
        TypedQuery<Hijo> myQuery = this.entityManager.createQuery("SELECT h FROM Hijo h WHERE h.estudiante.id =:id",
                Hijo.class);
        myQuery.setParameter("id", id);
        return myQuery.getResultList();
    }

    @Override
    public void insertarHijo(Hijo hijo) {
//        Hijo newHijo = new Hijo();
//        newHijo.setId(1);
//        newHijo.setApellido("VerkHijo");
//        newHijo.setNombre("EmilJIJO");
//        newHijo.setEstudiante(this.iEstudianteRepository.seleccionarEstudianteId(1));
        this.entityManager.persist(hijo);
    }
}
