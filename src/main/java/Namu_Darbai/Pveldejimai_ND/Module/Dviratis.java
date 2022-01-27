package Namu_Darbai.Pveldejimai_ND.Module;

public class Dviratis extends TransportoPriemone {
    private int pavaruSkaicius;

    public Dviratis(int ratuSkaicius, String spalva, int pavaruSkaicius){
        super(ratuSkaicius, spalva);
        this.pavaruSkaicius = pavaruSkaicius;
    }
    @Override
    public String spausdinti() {
        return super.spausdinti() + "\nPavaru skaicius: " + pavaruSkaicius;
    }
}
