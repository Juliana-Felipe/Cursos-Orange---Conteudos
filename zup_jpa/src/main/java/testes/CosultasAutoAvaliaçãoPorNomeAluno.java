package testes;

import br.com.alura.jpa.modelo.Aluno;
import br.com.alura.jpa.modelo.AutoAvaliação;
import br.com.alura.jpa.modelo.Resposta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CosultasAutoAvaliaçãoPorNomeAluno {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Resposta resposta = new Resposta();
        resposta.setId(3L);

        String jpql = "select av from AutoAvaliação av join av.resposta ar where ar = :pResposta";
        TypedQuery<AutoAvaliação> query = em.createQuery(jpql, AutoAvaliação.class);
        query.setParameter("pResposta", resposta);
        List<AutoAvaliação> avaliações = query.getResultList();

        for (AutoAvaliação autoAvaliação : avaliações) {
            System.out.println("O(a) Aluno(a) " + autoAvaliação.getResposta().getAluno().getNome() + " se auto avaliou com a nota "+ autoAvaliação.getNota());
        }
    }
}
