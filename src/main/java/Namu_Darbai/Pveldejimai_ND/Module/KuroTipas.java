package Namu_Darbai.Pveldejimai_ND.Module;

public enum KuroTipas {

    t1("Benzinas"),
    t2("Dyzelinas"),
    t3("Vandenilis");

    private final String tipas;

    KuroTipas(String tipas){
        this.tipas = tipas;
    }

    public String getTipas() {
        return this.tipas;
    }
}
