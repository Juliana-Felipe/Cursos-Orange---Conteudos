package responsabilidadeUnica;

public enum Cargo {
    DESENVOLVEDOR(new dezOuVintePorcento()),
    DBA(new quinzeOuVinteCincoPorcento()),
    TESTER(new quinzeOuVinteCincoPorcento());

    private Calculo regra;

    Cargo(Calculo regra) {
        this.regra = regra;
    }

    public Calculo getRegra() {
        return regra;
    }
}
