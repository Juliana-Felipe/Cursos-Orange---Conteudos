package br.com.caelum.leilao.dominio.testedeunidadepersonalisado;

import java.util.Objects;

public class Lance {

    private Usuario usuario;
    private double valor;

    public Lance(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lance lance = (Lance) o;
        return Objects.equals(usuario, lance.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario);
    }
}


