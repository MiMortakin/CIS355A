package GUI;

/**
 *
 * @author Michelle Buchholz
 * DeVry CIS355A Week 3 Optional Lab
 * 
 */


import java.text.DecimalFormat;

public class BurgerOrder {
    public static final double SINGLE_COST = 3.50;
    public static final double DOUBLE_COST = 4.75;
    public static final double CHEESE_COST = 0.50;
    public static final double BACON_COST = 1.25;
    public static final double MEAL_COST = 4.00;

    private final String type;
    private final boolean cheese;
    private final boolean bacon;
    private final boolean meal;
    private final int quantity;

    public BurgerOrder(String type, boolean cheese, boolean bacon, boolean meal, int quantity) {
        this.type = type;
        this.cheese = cheese;
        this.bacon = bacon;
        this.meal = meal;
        this.quantity = quantity;
    }

    public double calculateItemCost() {
        double cost = 0.0;

        if ("Single".equalsIgnoreCase(type)) cost = SINGLE_COST;
        else if ("Double".equalsIgnoreCase(type)) cost = DOUBLE_COST;

        if (cheese) cost += CHEESE_COST;
        if (bacon)  cost += BACON_COST;
        if (meal)   cost += MEAL_COST;

        return cost;
    }

    public double calculateTotalCost() {
        return quantity * calculateItemCost();
    }

    @Override
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder();
        sb.append(quantity).append(" ").append(type);

        if (cheese) sb.append(", cheese");
        if (bacon)  sb.append(", bacon");
        if (meal)   sb.append(", meal");

        sb.append(" at ").append(fmt.format(calculateItemCost())).append(" each");
        return sb.toString();
    }
}

