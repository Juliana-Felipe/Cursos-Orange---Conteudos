package br.com.alura.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentação;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaRelacionamentos {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setNumero(56465);
        conta.setAgencia(574654);
        conta.setTitular("Armando");
        conta.setSaldo(564.25);

        Movimentação movimentação = new Movimentação();
        movimentação.setData(LocalDateTime.now());
        movimentação.setDescricao("churrascaria");
        movimentação.setValor(new BigDecimal(200.00));
        movimentação.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentação.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(conta);
        em.persist(movimentação);


        em.getTransaction().commit();

        em.close();



    }
}
