package br.com.alura.bytebank.modelos

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    var salario: Double
) {
    // usando properties como se fosse função
    abstract val bonificacao: Double
    //usando função menor
    open fun bonificacao(): Double = salario * 0.1

}