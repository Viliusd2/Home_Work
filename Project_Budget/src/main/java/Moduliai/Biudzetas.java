package Moduliai;

import Moduliai.Irasai.IslaiduIrasas;
import Moduliai.Irasai.PajamuIrasas;



public class Biudzetas {
    private PajamuIrasas[] pajamos = new PajamuIrasas[100];
    private IslaiduIrasas[] islaidos = new IslaiduIrasas[100];

    public void pridetiPajamuIrasa(){
    }

    public void pridetiIslaiduIrasa(){
    }
    public PajamuIrasas[] gautiPajamuIrasa(){return pajamos;}
    public IslaiduIrasas[] gautiIslaiduIrasa(){return islaidos;}
}
