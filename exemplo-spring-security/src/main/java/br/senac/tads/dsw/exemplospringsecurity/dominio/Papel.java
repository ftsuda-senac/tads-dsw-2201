package br.senac.tads.dsw.exemplospringsecurity.dominio;

import org.springframework.security.core.GrantedAuthority;

public class Papel implements GrantedAuthority {

    private String nome;

    public Papel() {
    }

    public Papel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Meio pelo qual o Spring Security recupera a informação da permissão
    // do usuário
    @Override
    public String getAuthority() {
        return this.nome;
    }

}
