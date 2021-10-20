package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    Page<Topico> findByCurso_Nome(String nomeCurso, Pageable paginacao);


    //possibilidade de criar métodos de busca com query jpql:
   // @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
   // List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso")(String nomeCurso);
}
