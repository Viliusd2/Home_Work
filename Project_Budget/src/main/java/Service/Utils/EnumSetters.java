package Service.Utils;

import Model.ParameterClasses.Enums.PaymentCards;
import Model.ParameterClasses.Enums.PaymentMethods;
import Service.Menu.MainMenu;


public class EnumSetters {

  public static PaymentMethods setMethod() {
    PaymentMethods method = null;
    System.out.println(
        "Chose method: \n" + "[1] - Card\n" + "[2] - Cash\n" + "[3] - Paypal\n" + "[4] - Credit\n");
    String id = new MainMenu().readInput();
    switch (id) {
      case "1":
        method = PaymentMethods.Card;
        break;
      case "2":
        method = PaymentMethods.Cash;
        break;
      case "3":
        method = PaymentMethods.PAYPAL;
        break;
      case "4":
        method = PaymentMethods.Credit;
        break;
    }
    return method;
  }

  public static PaymentCards setCard() {
    PaymentCards card = null;
    System.out.println(
        "Chose method: \n" + "[1] - Card\n" + "[2] - Cash\n" + "[3] - Paypal\n" + "[4] - Credit\n");
    String id = new MainMenu().readInput();
    switch (id) {
      case "1":
        card = PaymentCards.Mastercard;
        break;
      case "2":
        card = PaymentCards.Debit;
        break;
      case "3":
        card = PaymentCards.AmericanExpress;
        break;
      case "4":
        card = PaymentCards.Visa;
        break;
    }
    return card;
  }
}
