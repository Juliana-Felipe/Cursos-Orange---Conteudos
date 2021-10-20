package herançaLiskovSubtitutivePrinciple;

public class ContaComum {

    private ManipuladorDeSaldo manipuladorDeSaldo;

    public ContaComum() {
        this.manipuladorDeSaldo = new ManipuladorDeSaldo();
    }

    public void saca(double valor) {
        manipuladorDeSaldo.saca(valor);
    }

    public void deposita(double valor) {
        manipuladorDeSaldo.deposita(valor);
    }

    public void rende() {
        this.manipuladorDeSaldo.rende(1.1);
    }
    public double getSaldo(){
        return manipuladorDeSaldo.getSaldo();
    }
}