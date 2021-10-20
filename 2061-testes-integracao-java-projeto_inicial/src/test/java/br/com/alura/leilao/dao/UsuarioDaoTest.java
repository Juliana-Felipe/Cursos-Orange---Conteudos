package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


class UsuarioDaoTest {
    private UsuarioDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
    void deveriaEcontrarUsuarioCadastradoBuscaDeUsuarioPeloUserName() {
        Usuario usuario = new UsuarioDataBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456789")
                .builder();
        em.persist(usuario);

        Usuario encontrado = this.dao.buscarPorUsername(usuario.getNome());

        Assert.assertNotNull(encontrado);
    }


    @Test
    void naoDeveriaEcontrarUsuarioNaoCadastradoBuscaDeUsuarioPeloUserName() {
        Usuario usuario = new UsuarioDataBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456789")
                .builder();
        em.persist(usuario);

        Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("Beltrano"));
    }




    @Test
    public void deveriaDeletarUmUsuarioExistente(){
        Usuario usuario = new UsuarioDataBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456789")
                .builder();
        em.persist(usuario);
        dao.deletar(usuario);
        Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername(usuario.getNome()));
    }

}