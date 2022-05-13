package br.senac.tads.dsw.exemplosspring.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresseRepository extends JpaRepository<Interesse, Integer> {

}
