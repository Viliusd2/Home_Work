package Namu_Darbai_01_04.Task6;


import java.util.Arrays;

public class Pinigine {
    private static final String VALIUTA = "EUR";
    private final int[] pinigai = {100, 50, 20, 10, 5};

    public Pinigine() {
    }

    public void parodyk() {
        System.out.printf("Jusu pinigineje yra: %s\n", Arrays.toString(pinigai) + VALIUTA);
    }

    public void suma() {
        int rezulatas = 0;
        for (int j : pinigai) {
            rezulatas += j;
        }
        System.out.println("Totali pinigu suma yra: " + rezulatas + VALIUTA);
    }

}
