import br.com.alura.bytebank.modelos.Autenticavel
import br.com.alura.bytebank.modelos.SistemaInterno

fun objectExpression() {
    val fran = object : Autenticavel {
        val nome: String = "fran"
        val senha: Int = 1000
        override fun autentica(senha: Int): Boolean {
            return this.senha == senha
        }
    }
    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(fran, 1000)
}