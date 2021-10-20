package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LeilaoDataBuilder;
import br.com.alura.leilao.util.builder.UsuarioDataBuilder;
import org.hibernate.TransientPropertyValueException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class LeilaoDaoTest {
    private LeilaoDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LeilaoDao(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
    void deveriaCadastrarUmLeilao() {

        Usuario usuario = new UsuarioDataBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456789")
                .builder();
        em.persist(usuario);

        Leilao leilao = new LeilaoDataBuilder()
                .comNome("Mochila")
                .comData(LocalDate.now())
                .comValorInicial("300")
                .comUsuario(usuario)
                .builder();
        leilao = dao.salvar(leilao);

        Leilao salvo = dao.buscarPorId(leilao.getId());
        Assert.assertNotNull(salvo);

    }

    @Test
    void deveriaAtualizarUmLeilao() {

        Usuario usuario = new UsuarioDataBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456789")
                .builder();
        em.persist(usuario);

        Leilao leilao = new LeilaoDataBuilder()
                .comNome("Mochila")
                .comData(LocalDate.now())
                .comValorInicial("300")
                .comUsuario(usuario)
                .builder();
        dao.salvar(leilao);

        //atualizando
        leilao.setNome("Caderno");
        leilao.setValorInicial(new BigDecimal("300"));
        Leilao leilaoAt = dao.salvar(leilao);

        Leilao salvo = dao.buscarPorId(leilaoAt.getId());
        Assert.assertEquals("Caderno", salvo.getNome());
        Assert.assertEquals(new BigDecimal("300"), salvo.getValorInicial());
    }
    @Test
    void deveriaBuscarListaDeLeiloes() {

        Usuario usuario = new UsuarioDataBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456789")
                .builder();
        em.persist(usuario);

        Leilao leilao1 = new LeilaoDataBuilder()
                .comNome("Mochila")
                .comData(LocalDate.now())
                .comValorInicial("300")
                .comUsuario(usuario)
                .builder();
        dao.salvar(leilao1);

        Leilao leilao2 = new LeilaoDataBuilder()
                .comNome("Caderno")
                .comData(LocalDate.now())
                .comValorInicial("200")
                .comUsuario(usuario)
                .builder();
        dao.salvar(leilao2);

        //buscando

        List<Leilao> leiloesDoUsuario = dao.buscarLeiloesDoUsuario(usuario);


        Assert.assertNotNull(leiloesDoUsuario);
    }

    @Test
    void deveriaRetornarListaVaziaParaUsuarioNuloNaBuscaPorListaDeLeilao() {

        Usuario usuario = new UsuarioDataBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456789")
                .builder();
        em.persist(usuario);

        Leilao leilao1 = new LeilaoDataBuilder()
                .comNome("Mochila")
                .comData(LocalDate.now())
                .comValorInicial("300")
                .comUsuario(usuario)
                .builder();
        dao.salvar(leilao1);

        Leilao leilao2 = new LeilaoDataBuilder()
                .comNome("Caderno")
                .comData(LocalDate.now())
                .comValorInicial("200")
                .comUsuario(usuario)
                .builder();
        dao.salvar(leilao2);

        //buscando

        List<Leilao> leiloesDoUsuario = dao.buscarLeiloesDoUsuario(null);
        List<Leilao> listaVazia = new ArrayList<>();

        Assert.assertEquals(listaVazia, leiloesDoUsuario);
    }

//    @Test
//    void deveriaRetornarListaVaziaParaUsuarioNaoSalvoNoBancoDeDadosNaBuscaPorListaDeLeilao() {
//
//        Usuario usuario = new UsuarioDataBuilder()
//                .comNome("Fulano")
//                .comEmail("fulano@email.com")
//                .comSenha("123456789")
//                .builder();
//        //em.persist(usuario);
//
//        Leilao leilao1 = new LeilaoDataBuilder()
//                .comNome("Mochila")
//                .comData(LocalDate.now())
//                .comValorInicial("300")
//                .comUsuario(usuario)
//                .builder();
//        dao.salvar(leilao1);
//
//        Leilao leilao2 = new LeilaoDataBuilder()
//                .comNome("Caderno")
//                .comData(LocalDate.now())
//                .comValorInicial("200")
//                .comUsuario(usuario)
//                .builder();
//        dao.salvar(leilao2);
//
//        //buscando
//
//        List<Leilao> leiloesDoUsuario = dao.buscarLeiloesDoUsuario(usuario);
//        List<Leilao> listaVazia = new ArrayList<>();
//
//        Assert.assertThrows(TransientPropertyValueException.class,()->dao.salvar(leilao1));
//    }

}