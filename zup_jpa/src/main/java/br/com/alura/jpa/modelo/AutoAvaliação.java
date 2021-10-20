package br.com.alura.jpa.modelo;

import javax.persistence.*;

@Entity
public class AutoAvaliação {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int nota;

    @JoinColumn(unique = true)
    @OneToOne
    private Resposta resposta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }
}
