package br.senac.tads.dsw.exemplosspring.pessoas;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FotoPessoa {

    private Integer id;

    @NotBlank
    @Size(max = 500)
    // NAO PODE REPETIR
    private String nomeArquivo;

    @Size(max = 1000)
    private String legenda;

    private DadosPessoais pessoa;
    
    public FotoPessoa() {
        
    }
    
    public FotoPessoa(String nomeArquivo, String legenda) {
        this.nomeArquivo = nomeArquivo;
        this.legenda = legenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public DadosPessoais getPessoa() {
        return pessoa;
    }

    public void setPessoa(DadosPessoais pessoa) {
        this.pessoa = pessoa;
    }

}
