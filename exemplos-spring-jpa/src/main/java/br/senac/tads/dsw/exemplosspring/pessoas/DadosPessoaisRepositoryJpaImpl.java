package br.senac.tads.dsw.exemplosspring.pessoas;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class DadosPessoaisRepositoryJpaImpl implements DadosPessoaisRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<DadosPessoais> findAll(int page, int qtde) {
        int firstResult = page * qtde;
//        TypedQuery<DadosPessoais> jpqlQuery
//                = em.createQuery("SELECT dp FROM DadosPessoais dp", DadosPessoais.class);
        TypedQuery<DadosPessoais> jpqlQuery = em.createNamedQuery(
                "DadosPessoais.findAll",
                DadosPessoais.class);
        jpqlQuery.setFirstResult(firstResult);
        jpqlQuery.setMaxResults(qtde);
        List<DadosPessoais> resultado = jpqlQuery.getResultList();
        return resultado;
    }

    @Override
    public List<DadosPessoais> findByInteresses(List<Integer> interessesIds, int page, int qtde) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<DadosPessoais> findById(Integer id) {
//        TypedQuery<DadosPessoais> jpqlQuery = em.createQuery(
//                "SELECT dp FROM DadosPessoais dp WHERE dp.id = :idPessoa", 
//                DadosPessoais.class);
        TypedQuery<DadosPessoais> jpqlQuery = em.createNamedQuery(
                "DadosPessoais.findById", 
                DadosPessoais.class);
        jpqlQuery.setParameter("idPessoa", id);
        DadosPessoais resultado = jpqlQuery.getSingleResult();
        return Optional.ofNullable(resultado);
    }

    @Override
    public Optional<DadosPessoais> findByApelido(String apelido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public DadosPessoais save(DadosPessoais dados) {
        if (dados.getId() == null) {
            em.persist(dados);
        } else {
            dados = em.merge(dados);
        }
        return dados;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        DadosPessoais dp = em.find(DadosPessoais.class, id);
        em.remove(dp);
    }

}
