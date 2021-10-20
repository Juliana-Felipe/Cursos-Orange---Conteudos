package br.com.alura.bytebank.modelos

class ContaPoupança(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }
}