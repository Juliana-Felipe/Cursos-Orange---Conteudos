package br.com.caelum.leilao.dominio.testedeunidadepersonalisado.test;

import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.EncerradorDeLeilao;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.EnviadorDeEmail;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.Leilao;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.RepositorioDeLeiloes;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.build.CriadorDeLeilao;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EncerraLeilaoTest {
    @Test
    public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras() {

        Calendar antiga = Calendar.getInstance();
        antiga.set(1999, 1, 20);

        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma")
                .naData(antiga).constroi();
        Leilao leilao2 = new CriadorDeLeilao().para("Geladeira")
                .naData(antiga).constroi();

        RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));

        EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
        EncerradorDeLeilao encerrador =
                new EncerradorDeLeilao(daoFalso, carteiroFalso);
        encerrador.encerra();

        assertEquals(2, encerrador.getEncerrados());
        assertTrue(leilao1.isEncerrado());
        assertTrue(leilao2.isEncerrado());
    }

    @Test
    public void naoDeveEncerrarLeiloesQueComecaramMenosDeUmaSemanaAtras() {

        Calendar ontem = Calendar.getInstance();
        ontem.set(Calendar.DAY_OF_MONTH, -1);

        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma")
                .naData(ontem).constroi();
        Leilao leilao2 = new CriadorDeLeilao().para("Geladeira")
                .naData(ontem).constroi();

        RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes())
                .thenReturn(Arrays.asList(leilao1, leilao2));

        EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
        EncerradorDeLeilao encerrador =
                new EncerradorDeLeilao(daoFalso, carteiroFalso);

        encerrador.encerra();

        assertEquals(0, encerrador.getEncerrados());
        assertFalse(leilao1.isEncerrado());
        assertFalse(leilao2.isEncerrado());

        verify(daoFalso, never()).atualiza(leilao1);
        verify(daoFalso, never()).atualiza(leilao2);
    }

    @Test
    public void naoDeveEncerrarLeiloesCasoNaoHajaNenhum() {

        RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes())
                .thenReturn(new ArrayList<Leilao>());

        EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
        EncerradorDeLeilao encerrador =
                new EncerradorDeLeilao(daoFalso, carteiroFalso);

        encerrador.encerra();

        assertEquals(0, encerrador.getEncerrados());
    }

    @Test
    public void deveAtualizarLeiloesEncerrados() {

        Calendar antiga = Calendar.getInstance();
        antiga.set(1999, 1, 20);

        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma")
                .naData(antiga).constroi();

        RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes())
                .thenReturn(Arrays.asList(leilao1));

        EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
        EncerradorDeLeilao encerrador =
                new EncerradorDeLeilao(daoFalso, carteiroFalso);

        encerrador.encerra();

        verify(daoFalso, times(1)).atualiza(leilao1);
    }
    @Test
    public void deveEnviarEmailAposPersistirLeilaoEncerrado() {
        Calendar antiga = Calendar.getInstance();
        antiga.set(1999, 1, 20);

        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma")
                .naData(antiga).constroi();

        RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1));

        EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
        EncerradorDeLeilao encerrador =
                new EncerradorDeLeilao(daoFalso, carteiroFalso);

        encerrador.encerra();

        InOrder inOrder = inOrder(daoFalso, carteiroFalso);
        inOrder.verify(daoFalso, times(1)).atualiza(leilao1);
        inOrder.verify(carteiroFalso, times(1)).envia(leilao1);
    }
    @Test
    public void deveContinuarAExecucaoMesmoQuandoDaoFalha() {
        Calendar antiga = Calendar.getInstance();
        antiga.set(1999, 1, 20);

        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma")
                .naData(antiga).constroi();
        Leilao leilao2 = new CriadorDeLeilao().para("Geladeira")
                .naData(antiga).constroi();

        RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));

        doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao1);

        EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
        EncerradorDeLeilao encerrador =
                new EncerradorDeLeilao(daoFalso, carteiroFalso);

        encerrador.encerra();

        verify(daoFalso).atualiza(leilao2);
        verify(carteiroFalso).envia(leilao2);
    }
    @Test
    public void deveDesistirSeDaoFalhaPraSempre() {
        Calendar antiga = Calendar.getInstance();
        antiga.set(1999, 1, 20);

        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma")
                .naData(antiga).constroi();
        Leilao leilao2 = new CriadorDeLeilao().para("Geladeira")
                .naData(antiga).constroi();

        RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));

        EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
        doThrow(new RuntimeException()).when(daoFalso).atualiza(any(Leilao.class));

        EncerradorDeLeilao encerrador =
                new EncerradorDeLeilao(daoFalso, carteiroFalso);

        encerrador.encerra();

        verify(carteiroFalso, never()).envia(any(Leilao.class));
    }
}

