package testes;

import br.com.alura.jpa.modelo.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserirAluno {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setEmail("Marcos@Zup.com.br");
        aluno.setIdade((byte) 22);
        aluno.setNome("Marcos");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();

    }
}
