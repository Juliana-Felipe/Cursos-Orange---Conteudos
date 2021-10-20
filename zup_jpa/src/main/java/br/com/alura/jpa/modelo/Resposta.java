package br.com.alura.jpa.modelo;

import javax.persistence.*;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 2000)
    private String solucao;


    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Avalicao avalicao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Avalicao getAvalicao() {
        return avalicao;
    }

    public void setAvalicao(Avalicao avalicao) {
        this.avalicao = avalicao;
    }

    @Override
    public String toString() {
        return "Solução: " + solucao;
    }
}
