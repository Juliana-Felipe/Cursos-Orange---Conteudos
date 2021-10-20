package br.com.alura.testes;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraClienteConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, 1l);


        em.getTransaction().begin();

        cliente.setNome("Leonardo");

        em.getTransaction().commit();

        em.close();
    }
}
