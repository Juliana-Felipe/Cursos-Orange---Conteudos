package testes;

import br.com.alura.jpa.modelo.Aluno;
import br.com.alura.jpa.modelo.Resposta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CosultasRespostasPorAluno2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Aluno aluno = new Aluno();
        aluno.setId(1L);

        String jpql = "select r from Resposta r where r.aluno = :pAluno ";
        TypedQuery<Resposta> query = em.createQuery(jpql, Resposta.class);
        query.setParameter("pAluno", aluno);
        List<Resposta> respostas = query.getResultList();

        for (Resposta resposta1 : respostas) {
            System.out.println("O(a) aluno(a) " + resposta1.getAluno().getNome() + " apresentou as seguintes respostas " + resposta1.toString());
        }





    }
}
