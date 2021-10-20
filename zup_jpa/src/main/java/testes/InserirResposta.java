package testes;

import br.com.alura.jpa.modelo.Aluno;
import br.com.alura.jpa.modelo.Avalicao;
import br.com.alura.jpa.modelo.Resposta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserirResposta {
    public static void main(String[] args) {
        Aluno al1 = new Aluno();
        al1.setId(3L);
        Avalicao av1 = new Avalicao();
        av1.setId(2L);

        Resposta resposta = new Resposta();
        resposta.setSolucao("nada");
        resposta.setAluno(al1);
        resposta.setAvalicao(av1);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(resposta);
        em.getTransaction().commit();
        em.close();

    }
}
