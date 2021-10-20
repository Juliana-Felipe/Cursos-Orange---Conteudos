import br.com.alura.bytebank.modelos.Cliente
import br.com.alura.bytebank.modelos.ContaCorrente
import br.com.alura.bytebank.modelos.ContaPoupança

fun testaContasDiferentes() {
    val juliana = Cliente("Juliana","06600929995",123456)
    val contaCorrente = ContaCorrente(juliana, 1256)
    contaCorrente.deposita(1000.00)
    contaCorrente.saca(100.0)
    println("Saldo da conta corrente após saque ${contaCorrente.saldo}")

    val murilo = Cliente("Murilo","09695795943",12345)
    val contaPoupança = ContaPoupança(murilo, 1245)
    contaPoupança.deposita(2000.00)
    contaPoupança.saca(200.0)
    println("Saldo da conta poupança após saque ${contaPoupança.saldo}")

    contaCorrente.transfere(200.00, contaPoupança)
    println("Saldo da conta corrente após transferência ${contaCorrente.saldo}")
}
