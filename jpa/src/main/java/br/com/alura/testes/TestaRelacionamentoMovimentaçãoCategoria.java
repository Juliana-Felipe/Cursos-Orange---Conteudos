package br.com.alura.testes;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentação;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TestaRelacionamentoMovimentaçãoCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Conta conta = new Conta();
        conta.setId(2L);

        Movimentação movimentação = new Movimentação();
        movimentação.setDescricao("Viagem à SP");
        movimentação.setTipoMovimentacao(TipoMovimentacao.SAÍDA);
        movimentação.setData(LocalDateTime.now());
        movimentação.setValor(new BigDecimal(300.00));
        movimentação.setCategoria(Arrays.asList(categoria, categoria2));
        movimentação.setConta(conta);

        Movimentação movimentação2 = new Movimentação();
        movimentação2.setDescricao("Viagem à RJ");
        movimentação2.setTipoMovimentacao(TipoMovimentacao.SAÍDA);
        movimentação2.setData(LocalDateTime.now());
        movimentação2.setValor(new BigDecimal(400.00));
        movimentação2.setCategoria(Arrays.asList(categoria, categoria2));
        movimentação2.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(categoria);
        em.persist(categoria2);
        em.persist(movimentação);
        em.persist(movimentação2);
        em.getTransaction().commit();
        em.close();
    }
}
