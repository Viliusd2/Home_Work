package Moduliai;

import Moduliai.Irasai.IslaiduIrasas;
import Moduliai.Irasai.PajamuIrasas;

import java.util.Arrays;

public class Biudzetas {
  private PajamuIrasas[] pajamos = new PajamuIrasas[100];
  private IslaiduIrasas[] islaidos = new IslaiduIrasas[100];

  public void pridetiPajamuIrasa(PajamuIrasas pajamos) {
    this.pajamos[0] = pajamos;
  }

  public void pridetiIslaiduIrasa(IslaiduIrasas islaidos) {
    this.islaidos[0] = islaidos;
  }

  public void gautiPajamuIrasa(int index) {
    System.out.println(pajamos[index]);
  }

  public void gautiIslaiduIrasa(int index) {
    System.out.println(islaidos[index]);
  }
}
