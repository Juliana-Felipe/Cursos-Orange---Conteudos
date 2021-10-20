package br.com.alura.bytebank.modelos

class SistemaInterno {
    fun entra(admin: Autenticavel, senha: Int) {
        if (admin.autentica(senha)) {
            println("Bem vindo!")
        } else {
            println("Acesso negado!")
        }

    }
}