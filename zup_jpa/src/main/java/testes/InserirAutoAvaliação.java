package testes;

import br.com.alura.jpa.modelo.Aluno;
import br.com.alura.jpa.modelo.AutoAvaliação;
import br.com.alura.jpa.modelo.Avalicao;
import br.com.alura.jpa.modelo.Resposta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserirAutoAvaliação {
    public static void main(String[] args) {
        Resposta resposta = new Resposta();
        resposta.setId(1L);

        AutoAvaliação autoAvaliação = new AutoAvaliação();
        autoAvaliação.setNota(8);
        autoAvaliação.setResposta(resposta);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(autoAvaliação);
        em.getTransaction().commit();
        em.close();

    }
}
