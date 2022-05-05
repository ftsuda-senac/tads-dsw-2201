package br.senac.tads.dsw.exemplosspring.pessoas;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Interesse {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    // NAO PODE REPETIR
    private String nome;

    private Set<DadosPessoais> pessoas;

    public Interesse() {

    }

    public Interesse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<DadosPessoais> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<DadosPessoais> pessoas) {
        this.pessoas = pessoas;
    }

}
