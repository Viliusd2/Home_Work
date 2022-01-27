package Namu_Darbai.Pveldejimai_ND.Module;

public class Sunkvezimis extends Automobilis {
    private int krovinioTalpa;
    private int krovinioSvoris;

    public Sunkvezimis(int ratuSkaicius, String spalva, KuroTipas kuroTipas, double variklioTuris, int cilindruSkaicius) {
        super(ratuSkaicius, spalva, kuroTipas, variklioTuris, cilindruSkaicius);
        this.krovinioSvoris = 0;
        this.krovinioTalpa = 0;
    }

    @Override
    public String spausdinti() {
        return super.spausdinti() + "\nKrovinio talpa: " + krovinioTalpa + "\nKrovinio Svoris: " + krovinioSvoris;
    }

    public int getKrovinioTalpa() {
        return krovinioTalpa;
    }

    public void setKrovinioTalpa(int krovinioTalpa) {
        this.krovinioTalpa = krovinioTalpa;
    }

    public int getKrovinioSvoris() {
        return krovinioSvoris;
    }

    public void setKrovinioSvoris(int krovinioSvoris) {
        this.krovinioSvoris = krovinioSvoris;
    }
}
