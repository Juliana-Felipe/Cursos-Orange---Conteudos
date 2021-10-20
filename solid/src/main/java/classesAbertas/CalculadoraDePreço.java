package classesAbertas;

public class CalculadoraDePreço {
    private TabelaDePreço tabela;
    private Transporte entrega;

    public CalculadoraDePreço(TabelaDePreço tabela, Transporte entrega) {
        this.tabela = tabela;
        this.entrega = entrega;
    }

    public double calcula(Compra produto) {
        TabelaDePrecoPadrao tabela = new TabelaDePrecoPadrao();
        Frete correios = new Frete();

        double desconto = tabela.descontoPara(produto.getValor());
        double frete = correios.para(produto.getCidade());

        return produto.getValor() * (1-desconto) + frete;
    }
}
