package br.com.caelum.leilao.dominio.testedeunidadepersonalisado.servico;


import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.Lance;
import br.com.caelum.leilao.dominio.testedeunidadepersonalisado.Leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

    private double mediaDosLances = 0;
    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;

    public void avalia(Leilao leilao) {
        if(leilao.getLances().size() == 0) {
         throw new RuntimeException("Não é possível avaliar um leil~çao sem lances!");
        }
        double total = 0;
        for (Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
            if (lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
            total += lance.getValor();
            if (total == 0) {
                mediaDosLances = 0;
            }
            mediaDosLances = total / leilao.getLances().size();
        }
        maiores = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>() {

            public int compare(Lance o1, Lance o2) {
                if (o1.getValor() < o2.getValor()) return 1;
                if (o1.getValor() > o2.getValor()) return -1;
                return 0;
            }
        });
        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
    }

    public List<Lance> getTresMaiores() {
        return maiores;
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }

    public double getMediaDosLances() {
        return mediaDosLances;
    }
}
