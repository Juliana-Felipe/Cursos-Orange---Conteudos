import br.com.alura.bytebank.modelos.CalculadoraBonificacao
import br.com.alura.bytebank.modelos.Diretor
import br.com.alura.bytebank.modelos.Gerente

fun testandoFuncionarios() {
    val emerson = Gerente(nome = "Emerson", salario = 1500.00, cpf = "005.002.009-96", senha = 123456)
    if (emerson.autentica(123456)) {
        println("Autenticado")
        println(emerson.bonificacao)
    } else println("Erro de autenticação")
    println()

    val juliana = Diretor(nome = "Juliana", salario = 2000.00, cpf = "005.002.009-96", senha = 123456, plr = 5000.0)
    println(juliana.bonificacao)
    println()
    println()

    val calc = CalculadoraBonificacao()
    calc.registra(emerson)
    calc.registra(juliana)
    println("total de bonificações")
    println(calc.total)
}