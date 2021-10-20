package br.com.alura.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraContaLeonardo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        Conta contaDoLeonardo = em.find(Conta.class, 1l);


        em.getTransaction().begin();

        contaDoLeonardo.setSaldo(20.00);

        em.getTransaction().commit();

        em.close();
    }
}
