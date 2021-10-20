package br.com.alura.bytebank.modelos

class CalculadoraBonificacao {
    var total:Double = 0.0
    fun registra(funcionario: Funcionario){
        println(funcionario.nome)
        this.total+= funcionario.bonificacao
    }
//    fun registra(gerente: modelos.Gerente){
//        this.total+= gerente.bonificacao
//    }
//    fun registra(diretor: modelos.Diretor){
//        this.total+= diretor.bonificacao
//    }
}