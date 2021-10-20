fun testaLacos() {
    // for (i in 1..6)
    for (i in 5 downTo -2 step 2) {
        val titular1 = "Raimundo $i"
        val numeroConta = 8714 + i
        var saldo = 0.0 + i

        println("titular1 = $titular1")
        println("numero da conta = $numeroConta")
        println("saldo = $saldo")
        //  testarCondicoes(saldo)

    }
    var i = 0
    while (i <= 5) {
        println("testando while $i")
        i++
    }
}
