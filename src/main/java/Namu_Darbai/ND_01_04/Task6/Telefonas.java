package Namu_Darbai.ND_01_04.Task6;

import java.util.Random;

public class Telefonas {
    private String marke;
    private String modelis;
    private int atmintis;
    private String spalva;

    Random ran = new Random();

    public Telefonas() {

    }

    public String getMarke() {
        return marke;
    }

    public void setMarke() {
        String[] marke = {"Samsung", "Apple", "OnePlus", "Xiomi", "Appo", "Huawei"};
        this.marke = marke[ran.nextInt(6)];
    }

    public String getModelis() {
        return modelis;
    }

    public void setModelis() {

    }

    public int getAtmintis() {
        return atmintis;
    }

    public void setAtmintis() {
        int[] atmintis = {64, 128, 256, 512};
        this.atmintis = atmintis[ran.nextInt(4)];
        //System.out.println(this.atmintis);
    }

    public String getSpalva() {
        return spalva;
    }

    public void setSpalva(String spalva) {
        this.spalva = spalva;
    }

    public static void parodyk() {

    }

    public static void main(String[] args) {

    }
}
