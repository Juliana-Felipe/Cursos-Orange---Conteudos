package br.com.alura.leilao.util.builder;

import br.com.alura.leilao.model.Usuario;

public class UsuarioDataBuilder {

    private String nome;
    private String email;
    private String senha;

    public UsuarioDataBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioDataBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioDataBuilder comSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario builder() {
        return new Usuario(nome, email, senha);
    }

}
