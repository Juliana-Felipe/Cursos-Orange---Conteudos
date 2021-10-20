package br.com.caelum.leilao.dominio.testedeunidadepersonalisado;

import java.util.List;

public interface RepositorioDeLeiloes {
    void salva(Leilao leilao);
    List<Leilao> encerrados();
    List<Leilao> correntes();
    void atualiza(Leilao leilao);
}
