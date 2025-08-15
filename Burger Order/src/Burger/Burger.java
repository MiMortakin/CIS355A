package Burger;

import java.text.DecimalFormat;

public class Burger
{
    //attributes
    private String type;
    private boolean cheese;
    private boolean bacon;
    private boolean meal;
    private int quantity;
    private final double SINGLE_COST = 3.50;
    private final double DOUBLE_COST = 4.75;
    private final double CHEESE_COST = 0.50;
    private final double BACON_COST = 1.25;
    private final double MEAL_COST = 4.00;

    // constructors
    public Burger()
    {
        type = "SINGLE";
        cheese = false;
        bacon = false;
        meal = false;
    }

    // behaviors
    public double calculateItemCost()
    {
        double cost = 0.0;

        if ( type.equalsIgnoreCase("Single") )
            cost = SINGLE_COST;
            
        else if (type.equalsIgnoreCase("Double"))
                cost = DOUBLE_COST;

        if( cheese )  //if(cheese==true)
            cost += CHEESE_COST;

        if( bacon )
            cost += BACON_COST;

        if( meal )
            cost += MEAL_COST;

        return cost;
    }

    public double calculateTotalCost()
    {
        return quantity * calculateItemCost();
    }

    @Override
    public String toString()
    {
        String output = quantity +  " " + type;
        if(cheese)
            output += ", cheese";

        if(bacon)
            output += ", bacon";

        if(meal)
            output += ", meal";

        output += " at ";

        DecimalFormat fmt = new DecimalFormat("0.00");
        double cost = calculateItemCost();
        output += fmt.format(cost) + " each";

        return output;
    }

    // getters and setters
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public boolean getCheese()
    {
        return cheese;
    }
    public void setCheese( boolean  cheese )
    {
        this.cheese = cheese;
    }

    public boolean getBacon()
    {
        return bacon;
    }
    public void setBacon( boolean  bacon )
    {
        this.bacon = bacon;
    }

    public boolean getMeal()
    {
        return meal;
    }
    public void setMeal( boolean  meal )
    {
        this.meal = meal;
    }

    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity( int  quantity )
    {
        this.quantity = quantity;
    }

}