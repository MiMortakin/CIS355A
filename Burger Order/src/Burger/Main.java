package Burger;

import Burger.Burger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main
{
    // class level references and variables
    private static Scanner scan = new Scanner(System.in);
    private static DecimalFormat fmt = new DecimalFormat("0.00");
    private static double total = 0.0;
    private static String order = "";

    public static void main(String[] args)
    {
        int choice = 0;
        final int EXIT_VALUE = 4;

        do 
        {
            // show menu
            System.out.println("Menu\n");
            System.out.println("1) Add to Order");
            System.out.println("2) Show Current Order");
            System.out.println("3) New Order");
            System.out.println("4) Exit");

            // Get User's Choice
            System.out.print("\nEnter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            // Based on User's Choice
            switch(choice)
            {
                case 1: 
                    addToOrder();
                    showCurrentOrder();
                    pause();
                    break;
                case 2: 
                    showCurrentOrder();
                    pause();
                    break;
                case 3:
                    total = 0.0;
                    order = "";
                    showCurrentOrder();
                    pause();
                    break;
                case 4:
                    System.out.println("\nGoodbye!");
                    break;
                default:        //error checking
                    System.out.println("\nError. Please select from the menu.");
                    pause();
                    break;
            }
        }

        while( choice != EXIT_VALUE );
    } //ends main method

    private static void addToOrder()
    {
        String answer = "";
        Burger burger = new Burger();
        System.out.print("\nSingle or Double burger (single/double)? ");
        answer = scan.nextLine();
        if (answer.equalsIgnoreCase("single"))
            burger.setType("Single");
        else if(answer.equalsIgnoreCase("double"))
            burger.setType("Double");
        else 
        {
            System.out.println("\nError. Invalid burger type.\n");
            return; //ends method
        }

        System.out.println("Item Price: " + fmt.format(burger.calculateItemCost()));

        System.out.print("Add cheese (y/n)? ");
        answer = scan.nextLine();
        if(answer.equalsIgnoreCase("y") )
            burger.setCheese(true);
        System.out.println("Item Price: " + fmt.format(burger.calculateItemCost()));

        System.out.print("Add bacon (y/n)? ");
        answer = scan.nextLine();
        if(answer.equalsIgnoreCase("y") )
            burger.setBacon(true);
        System.out.println("Item Price: " + fmt.format(burger.calculateItemCost()));

        System.out.print("Make it a Meal (y/n)? ");
        answer = scan.nextLine();
        if(answer.equalsIgnoreCase("y") )
            burger.setMeal(true);
        System.out.println("Item Price: " + fmt.format(burger.calculateItemCost()));

        System.out.print("\nHow many of these burgers to add to the order (0 to cancel)? ");
        int quantity = scan.nextInt();
        scan.nextLine();

        if ( quantity > 0 )
        {
            burger.setQuantity(quantity);
            order += burger.toString() + "\n";
            total += burger.calculateTotalCost();
        }
    }

    private static void showCurrentOrder()
    {
        System.out.println("\nCurrent Order");
        System.out.println(order);
        System.out.println("Order Total: " + fmt.format(total));
    }

    private static void pause()
    {
        System.out.print("\nPress ENTER to continue");
        scan.nextLine();
        System.out.println("\n\n");
    }
    
} //ends Main class