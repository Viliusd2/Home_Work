package Model.ParameterClasses;


import Service.Menu.MainMenu;
import java.util.stream.IntStream;

public class PaymentCategory {
  private static final String[] categories = {
    "0 - House",
    "1 - Utilities",
    "2 - Transportation",
    "3 - Food",
    "4 - Health care",
    "5 - Debt",
    "6 - Entertainment"

  };

  public PaymentCategory() {
  }
  public static String getCategories(){
    System.out.println("Chose Category for listing");
    IntStream.range(0, categories.length - 1).forEach(i -> System.out.printf("%s\n", categories[i]));
   String index = new MainMenu().readInput();
    return getCategoryType(Integer.parseInt(index));
  }
  public static String getCategoryType(int index){
    return categories[index].substring(3);
  }
}
