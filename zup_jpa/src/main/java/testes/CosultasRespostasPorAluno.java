package testes;

import br.com.alura.jpa.modelo.Aluno;
import br.com.alura.jpa.modelo.AutoAvaliação;
import br.com.alura.jpa.modelo.Resposta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CosultasRespostasPorAluno {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Resposta resposta = new Resposta();
        resposta.setId(2L);

        String jpql = "select a from Aluno a join a.respostas r where r = :pResposta";
        TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
        query.setParameter("pResposta", resposta);
        List<Aluno> alunos = query.getResultList();

        for (Aluno aluno : alunos) {
            System.out.println("O(a) aluno(a) " + aluno.getNome() + " apresentou as seguintes respostas " + aluno.getRespostas().toString());
        }





    }
}
