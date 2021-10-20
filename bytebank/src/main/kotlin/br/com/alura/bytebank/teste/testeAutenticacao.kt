import br.com.alura.bytebank.modelos.Cliente
import br.com.alura.bytebank.modelos.Diretor
import br.com.alura.bytebank.modelos.Gerente
import br.com.alura.bytebank.modelos.SistemaInterno

fun testeAutenticacao() {
    val gerente = Gerente("Ju", "06600929995", 200.00, 123456)
    val diretora = Diretor("Ju", "06600929995", 200.00, 654321, 200.00)
    val cliente = Cliente("Alex", "0203040506", 125)
    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(gerente, 123456)
    sistemaInterno.entra(diretora, 654321)
    sistemaInterno.entra(cliente, 125)
}