package Modules.MoneyRecords;

import Modules.FinalParameters.PaymentCategory;


public class MoneyRecords {
    private final double sum;
    private final PaymentCategory Category;
    private final String papInfo;
    private final int id;
    private static int counter = 0;

    public MoneyRecords(double sum, PaymentCategory category, String papInfo) {
        counter++;
        this.sum = sum;
        this.Category = category;
        this.papInfo = papInfo;
        this.id = counter;
    }

    public double getSum() {
        return sum;
    }

    public int getId() {
        return id;
    }

    public PaymentCategory getCategory() {
        return Category;
    }

    public String getPapInfo() {
        return papInfo;
    }

    @Override
    public String toString() {
        return String.format("%d || MoneyRecords : Category: %s\n Sum = %.2f  Info : %s\n" ,id,Category,sum,papInfo);

    }
}
