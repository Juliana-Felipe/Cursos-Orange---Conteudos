package br.com.alura.testes;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaRelacionamentoClienteConta {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setId(1L);

        Cliente cliente = new Cliente();
        cliente.setNome("marica");
        cliente.setEndereço("Rua Da Tirada, 12");
        cliente.setProfissão("Professor");
        cliente.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

}
