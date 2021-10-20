fun testarCondicoes(saldo: Double) {
    //estrutura condicional when
    when {
        saldo > 0.0 -> println("saldo positivo")
        saldo == 0.0 -> println("saldo neutro")
        else -> println("saldo negativo")
    }

    //estrutura condicional if else
    if (saldo > 0.0) {
        println("saldo positivo")
    } else if (saldo == 0.0) {
        println("saldo neutro")
    } else {
        println("saldo negativo")
    }
}
