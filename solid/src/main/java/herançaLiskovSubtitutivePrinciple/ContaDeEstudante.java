package herançaLiskovSubtitutivePrinciple;

public class ContaDeEstudante extends ContaComum {

    private ManipuladorDeSaldo manipuladorDeSaldo;
    private int milhas;

    public ContaDeEstudante() {
        manipuladorDeSaldo = new ManipuladorDeSaldo();
    }

    public void deposita(double valor) {
        manipuladorDeSaldo.deposita(valor);
        this.milhas += (int)valor;
        }

    public int getMilhas() {
        return milhas;
    }

}
