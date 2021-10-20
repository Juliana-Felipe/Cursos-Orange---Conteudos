package testes;

import br.com.alura.jpa.modelo.Aluno;
import br.com.alura.jpa.modelo.Avalicao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserirAvaliação {
    public static void main(String[] args) {
        Avalicao avalicao = new Avalicao();
        avalicao.setTitulo("JPA");
        avalicao.setComentario("te esforça");

        Avalicao avalicao2 = new Avalicao();
        avalicao2.setTitulo("SQL");
        avalicao2.setComentario("te esforça mais");

        Avalicao avalicao3 = new Avalicao();
        avalicao3.setTitulo("SQL avançado");
        avalicao3.setComentario("te esforça mais ainda");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(avalicao);
        em.persist(avalicao2);
        em.persist(avalicao3);
        em.getTransaction().commit();
        em.close();

    }
}
