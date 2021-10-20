package br.com.alura.testes;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentação;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJPQLMovimentaçãoDeUmaCategoria {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(1L);

        String jpql = "select m from Movimentação m join m.categoria c where c = :pCategoria";
        TypedQuery<Movimentação> query = em.createQuery(jpql, Movimentação.class);
        query.setParameter("pCategoria", categoria);
        List<Movimentação> resultList = query.getResultList();

        for (Movimentação movimentação : resultList) {
            System.out.println("Descrição: " + movimentação.getDescricao());
            System.out.println("Valor: " + movimentação.getValor());
            System.out.println("Tipo: " + movimentação.getTipoMovimentacao());
        }
    }
}
