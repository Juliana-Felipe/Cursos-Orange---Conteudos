package br.com.alura.bytebank.modelos

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int
) : FuncionarioAdmin(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha
) {


    override val bonificacao: Double
        get() {
            println("bonificação modelos.Gerente")
            return salario
        }

}













