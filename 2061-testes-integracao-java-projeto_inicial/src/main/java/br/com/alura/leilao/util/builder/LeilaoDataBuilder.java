package br.com.alura.leilao.util.builder;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LeilaoDataBuilder {

    private String nome;
    private BigDecimal valorInicial;
    private LocalDate data;
    private Usuario usuario;

    public LeilaoDataBuilder comNome(String nome){
        this.nome = nome;
        return this;
    }
    public LeilaoDataBuilder comValorInicial(String valor){
        this.valorInicial = new BigDecimal(valor);
        return this;
    }
    public LeilaoDataBuilder comData(LocalDate data){
        this.data = data;
        return this;
    }
    public LeilaoDataBuilder comUsuario(Usuario usuario){
        this.usuario = usuario;
        return this;
    }
    public Leilao builder(){
        return new Leilao(nome,valorInicial,data,usuario);
    }

}
