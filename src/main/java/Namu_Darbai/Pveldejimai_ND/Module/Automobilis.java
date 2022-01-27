package Namu_Darbai.Pveldejimai_ND.Module;

public class Automobilis extends TransportoPriemone {
    private KuroTipas kuroTipas;
    private double variklioTuris;
    private int cilindruSkaicius;


    public Automobilis(int ratuSkaicius, String spalva, KuroTipas kuroTipas, double variklioTuris, int cilindruSkaicius) {
        super(ratuSkaicius, spalva);
        this.kuroTipas = kuroTipas;
        this.variklioTuris = variklioTuris;
        this.cilindruSkaicius = cilindruSkaicius;
    }

    @Override
    public String spausdinti() {
        return super.spausdinti() + "\nKuro tipas: " + kuroTipas.getTipas() + "\nVariklio turis: " + variklioTuris + "\nCilindru skaicius: " + cilindruSkaicius;
    }
}
