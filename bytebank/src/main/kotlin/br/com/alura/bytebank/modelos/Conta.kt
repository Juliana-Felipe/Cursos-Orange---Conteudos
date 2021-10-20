package br.com.alura.bytebank.modelos

abstract class Conta(
    var titular: Cliente,
    val numero: Int = 0 // inicializando variável por padrão
) {
    var saldo = 0.0
        protected set

//    object declaration, quando atributo é privado nem a classe que ele tá dentro pode acessar
//    object Contador {
//        var total = 0
//            private set
//    }

    // companion object pode ter set privado e mesmo assim a classe altera, pq é objeto companheiro
    companion object {
        var total = 0
        private set
    }

    init {
        println("Criando conta")
        Companion.total++
    }


    fun deposita(valor: Double) {
        if (valor > 0.0) {
            this.saldo += valor;
        }
    }

    abstract fun saca(valor: Double)


    fun transfere(valor: Double, destino: Conta): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.deposita(valor);
            return true
        }
        return false
    }

    // getters e setters  não são interessantes em kotlin
//    fun getSaldo():Double{
//        return saldo;
//    }
//    fun setSaldo(valor: Double){
//        saldo = valor;
//    }
}
