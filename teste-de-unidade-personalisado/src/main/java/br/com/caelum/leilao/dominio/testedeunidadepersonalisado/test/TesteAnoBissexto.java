package br.com.caelum.leilao.dominio.testedeunidadepersonalisado.test;

import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.AnoBissexto;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteAnoBissexto {
    @Test
    public void deveRetornarAnoBissexto() {
        AnoBissexto anoBissexto = new AnoBissexto();

        assertEquals(true, anoBissexto.getAnoBissexto(2016));
        assertEquals(true, anoBissexto.getAnoBissexto(2012));
    }

    @Test
    public void naoDeveRetornarAnoBissexto() {
        AnoBissexto anoBissexto = new AnoBissexto();

        assertEquals(false, anoBissexto.getAnoBissexto(2015));
        assertEquals(false, anoBissexto.getAnoBissexto(2011));
    }
}
