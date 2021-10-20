package br.com.alura.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentação;

import javax.persistence.*;
import java.util.List;

public class TesteJPQL {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);

        String jpql = "select m from Movimentação m where m.conta = :pConta order by m.valor desc";
        TypedQuery<Movimentação> query = em.createQuery(jpql, Movimentação.class);
        query.setParameter("pConta", conta);
        List<Movimentação> resultList = query.getResultList();

        for (Movimentação movimentação : resultList) {
            System.out.println("Descrição: " + movimentação.getDescricao());
            System.out.println("Tipo: " + movimentação.getTipoMovimentacao());
        }
    }
}
