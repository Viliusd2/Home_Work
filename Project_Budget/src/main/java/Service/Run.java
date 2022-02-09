package Service;

import Menu.MainMenu;
import Moduliai.Biudzetas;
import Moduliai.Irasai.IslaiduIrasas;
import Moduliai.Irasai.PajamuIrasas;

public class Run {

  public static void main(String[] args) {
    new MainMenu().printMainMenu();
    Biudzetas b1 = new Biudzetas();
    b1.pridetiPajamuIrasa(new PajamuIrasas(2000, "2001-05-06", true, "Atlyginimas"));
    b1.gautiPajamuIrasa(0);
    b1.pridetiIslaiduIrasa(new IslaiduIrasas(200,"Pirkinai"));
    b1.gautiIslaiduIrasa(0);
  }
}
