package Namu_Darbai.Pveldejimai_ND.Module;

public class TransportoPriemone {
    private int ratuSkaicius;
    private String spalva;

    public TransportoPriemone() {
        this.ratuSkaicius = 0;
        this.spalva = "Nezinoma";
    }

    public TransportoPriemone(int ratuSkaicius, String spalva) {
        this.ratuSkaicius = ratuSkaicius;
        this.spalva = spalva;
    }

    public String spausdinti() {
        return "Transporto priemones info: \nRatu skaicius: " + ratuSkaicius + "\nSpalva: " + spalva;
    }
}
