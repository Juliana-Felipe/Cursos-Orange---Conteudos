import br.com.alura.bytebank.modelos.Cliente
import br.com.alura.bytebank.modelos.ContaCorrente

public fun testandoComportamentoConta() {
    val juliana = Cliente("Juliana","06600929995",123456)
    val murilo = Cliente("Murilo","09695795943",12345)
    var contaJuliana= ContaCorrente(juliana, 1452)
    contaJuliana.deposita(100.00)
    println(contaJuliana.toString())

    //nomear parametros é chamado de labels
    var contaMurilo = ContaCorrente(murilo, numero = 2569)
    contaMurilo.deposita(800.00)
    println("titular: ${contaMurilo.titular}, numero: ${contaMurilo.numero},  saldo:${contaMurilo.saldo}")

    println("depositando na conta do Murilo")
    contaMurilo.deposita(70.20)
    println(contaMurilo.saldo)

    println("sacando na conta da Fran")
    contaMurilo.saca(60.20)
    println(contaMurilo.saldo)

    println("transferindo da conta do Murilo para a Juliana")
    if (contaMurilo.transfere(60.20, contaJuliana)) {
        println("transferência bem sucedida")
    } else println("não foi possível transferir")
}