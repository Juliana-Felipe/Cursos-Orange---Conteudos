package br.com.alura.bytebank.modelos

interface Autenticavel {
    fun autentica(senha: Int): Boolean
}