package br.com.caelum.leilao.dominio.testedeunidadepersonalisado.test;

import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.build.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.servico.Avaliador;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.Lance;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.Leilao;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class TesteDoAvaliador {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;

    @Before
    public void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("João");
        this.jose = new Usuario("Jose");
        this.maria = new Usuario("Maria");
    }

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 250.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .constroi();

        leiloeiro.avalia(leilao);


        assertEquals(400, leiloeiro.getMaiorLance(), 0.0000001);
        assertEquals(100, leiloeiro.getMenorLance(), 0.0000001);
    }

    @Test
    public void deveEntenderUmLance() {

        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 250.0)
                .constroi();

        leiloeiro.avalia(leilao);

        assertEquals(250, leiloeiro.getMaiorLance(), 0.0000001);
        assertEquals(250, leiloeiro.getMenorLance(), 0.0000001);
    }

    @Test
    public void deveEncontrarTresMaiores() {

        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 420)
                .lance(maria, 400)
                .lance(joao, 380)
                .lance(maria, 200)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(420, maiores.get(0).getValor(), 0.0000001);
        assertEquals(400, maiores.get(1).getValor(), 0.0000001);
        assertEquals(380, maiores.get(2).getValor(), 0.0000001);

    }

    @Test
    public void valoresEmOrdemAleatoria() {

        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")

                .lance(joao, 200.0)
                .lance(jose, 450.0)
                .lance(maria, 120.0)
                .lance(joao, 700.0)
                .lance(jose, 630.0)
                .lance(maria, 230.0)
                .constroi();

        leiloeiro.avalia(leilao);

        assertEquals(120, leiloeiro.getMenorLance(), 0.0000001);
        assertEquals(700, leiloeiro.getMaiorLance(), 0.0000001);

    }

    @Test
    public void deveEncontrarTresMaioresEmOrdemDecrescente() {

        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")

                .lance(joao, 2000.0)
                .lance(jose, 1000.0)
                .lance(maria, 500.0)
                .lance(joao, 250.0)
                .lance(jose, 125.0)
                .lance(maria, 62.5)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(2000, maiores.get(0).getValor(), 0.0000001);
        assertEquals(1000, maiores.get(1).getValor(), 0.0000001);
        assertEquals(500, maiores.get(2).getValor(), 0.0000001);

    }

    @Test
    public void deveEncontrarTresMaioresVazio() {

        Leilao leilao = new Leilao("playstation 3 novo");

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(0, maiores.size());
    }

    @Test
    public void deveCalcularMedia() {

        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")

                .lance(joao, 1000.0)
                .lance(jose, 200.0)
                .lance(maria, 300.0)
                .constroi();

        leiloeiro.avalia(leilao);

        Assert.assertEquals(500.00, leiloeiro.getMediaDosLances(), 0.0000001);

    }

    @Test
    public void testaMediaDeZeroLance() {

        // cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Leilao leilao = new Leilao("Iphone 7");

        leiloeiro.avalia(leilao);

        //validacao
        Assert.assertEquals(0, leiloeiro.getMediaDosLances(), 0.0001);
    }
    @Test(expected = RuntimeException.class)
    public void naoDeveAvaliarLeilaoSemNenhumLanceDado(){
        Leilao leilao = new CriadorDeLeilao().para("play").constroi();
        leiloeiro.avalia(leilao);
    }
}

