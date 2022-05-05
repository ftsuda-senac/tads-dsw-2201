package br.senac.tads.dsw.exemplosspring.pessoas;

import java.util.List;
import java.util.Optional;

public interface InteresseRepository {

    List<Interesse> findAll();

    Optional<Interesse> findById(Integer id);

    Interesse save(Interesse interesse);

}
