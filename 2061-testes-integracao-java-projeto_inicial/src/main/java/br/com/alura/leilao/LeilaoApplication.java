package br.com.alura.leilao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeilaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}

	public boolean aceitaPalavra(String str){
		if(str == null || str.length() < 5){
			return false;
		}

		char primeiroCaractere = str.charAt(0);
		int tamanho = str.length();

		if (Character.isLetter(primeiroCaractere) && (ultimoCaractere == 's' || tamanho >= 10)) {
			return true;
		} else {
			return false;
		}
	}
}


