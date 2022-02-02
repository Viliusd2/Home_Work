package Namu_Darbai.Pveldejimai_ND.Module;

public enum KuroTipas {

    Gass("Benzinas"),
    Diesel("Dyzelinas"),
    H2O("Vandenilis");

    private final String tipas;

    KuroTipas(String tipas){
        this.tipas = tipas;
    }

    public String getTipas() {
        return this.tipas;
    }
}
