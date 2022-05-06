package br.senac.tads.dsw.exemplosspring.pessoas;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Interesse {

    @Id
    @SequenceGenerator(name = "seq_interesse_id",
            sequenceName = "seq_interesse_id",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_interesse_id")
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    // NAO PODE REPETIR
    @Column(unique = true)
    private String nome;

    // "interesses" é o nome do atributo na classe DadosPessoais
    // onde o @ManyToMany foi configurado
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "interesses")
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
