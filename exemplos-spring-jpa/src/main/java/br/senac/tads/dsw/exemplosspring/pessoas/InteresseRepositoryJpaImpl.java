package br.senac.tads.dsw.exemplosspring.pessoas;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class InteresseRepositoryJpaImpl implements InteresseRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Interesse> findAll() {
        TypedQuery<Interesse> jpqlQuery = em.createQuery(
                "SELECT i FROM Interesse i", 
                Interesse.class);
        List<Interesse> resultados = jpqlQuery.getResultList();
        return resultados;
    }

    @Override
    public Optional<Interesse> findById(Integer id) {
        TypedQuery<Interesse> jpqlQuery = em.createQuery(
                "SELECT i FROM Interesse i WHERE i.id = :idParam",
                Interesse.class)
                .setParameter("idParam", id);
        Interesse resultado = jpqlQuery.getSingleResult();
        return Optional.ofNullable(resultado);
    }

    @Override
    @Transactional
    public Interesse save(Interesse interesse) {
        if (interesse.getId() == null) {
            // Se ID for nulo, salva novo interesse
            em.persist(interesse);
        } else {
            // Se ID for informado, atualiza interesse existente
            interesse = em.merge(interesse);
        }
        return interesse;
    }
    
}
