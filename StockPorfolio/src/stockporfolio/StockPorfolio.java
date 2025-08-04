package stockporfolio;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Chelly
 */
public class StockPorfolio {

    // class level references and variables
    private static Scanner scan = new Scanner(System.in);
    private static DecimalFormat fmt = new DecimalFormat("#,##0.00");
    private static ArrayList<Stock> stockList = new ArrayList<Stock>();

    public static void main(String[] args)
    {
        int choice = 0;
        final int EXIT_VALUE = 5;

        do
        {

            //Show Menu
            System.out.println("Menu\n");
            System.out.println("1) Add Stock");
            System.out.println("2) Remove Stock");
            System.out.println("3) Display Single Stock");
            System.out.println("4) Show Stock Portfolio");
            System.out.println("5) Exit");

            //get user's choice
            System.out.print("\nEnter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch(choice)
            {
                case 1:
                    addStock();
                    pause();
                    break;
                case 2:
                    removeStock();
                    pause();
                    break;
                case 3:
                    displaySingleStock();
                    pause();
                    break;
                case 4:
                    showStockPortfolio();
                    pause();
                    break;
                case 5:
                    System.out.println("\nGoodbye!");
                    break;
                default:
                    System.out.println("\nError. Please select from the menu.");
                    pause();
                    break;
            }
        }

        while( choice != EXIT_VALUE );
    }// ends methods

    private static void addStock()
    {
        System.out.print("\nEnter stock name: ");
        String name = scan.nextLine();
        System.out.print("Enter quantity: ");
        int qty = scan.nextInt();
        System.out.print("Enter purchase price: ");
        double purchasePrice = scan.nextDouble();
        System.out.print("Enter current price: ");
        double currentPrice = scan.nextDouble();
        scan.nextLine();

        //Create Stock Object - Add to Array - Show Portfolio
        Stock stk = new Stock(name, qty, purchasePrice, currentPrice);
        stockList.add(stk);
        showStockPortfolio();
    }
    
    private static void removeStock()
    {
        System.out.print("\nEnter stock name to remove: ");
        String name = scan.nextLine();

        boolean found = false;
        for( int i = 0; i < stockList.size(); ++i)
        {
            if(stockList.get(i).getCompanyName().equalsIgnoreCase(name))
            {
                found = true;
                stockList.remove(i);
            }
        }

        if(found == false)
            System.out.println("\n" + name + " was not found.");
        else             
            showStockPortfolio();
    }
    
    private static void displaySingleStock()
    {
        System.out.print("\nEnter stock name: ");
        String name = scan.nextLine();

        boolean found = false;
        
        for( Stock stk : stockList )
        {
            if( name.equalsIgnoreCase(stk.getCompanyName()) )
            {
                found = true;
                System.out.println("\nStock Name: " + stk.getCompanyName());
                System.out.println("Number of Shares: " + stk.getNumberOfShares());
                System.out.println("Purchase Price: " + fmt.format(stk.getPurchasePrice()));
                System.out.println("Current Price: " + fmt.format(stk.getCurrentPrice()));
                double profitLoss = stk.getProfitLoss();

                if(profitLoss > 0.0 )
                    System.out.println("\nProfit/Loss: Profit of " + fmt.format(profitLoss));
                else if(profitLoss < 0.0)
                    System.out.println("\nProfit/Loss: Loss of " + fmt.format(profitLoss));
                else 
                    System.out.println("\nProfit/Loss: Break Even");

                break;
            }

        }
        if(!found)
            System.out.println("\n" + name + " was not found.");
    }
    
    private static void showStockPortfolio()
    {
        System.out.println("\nStock Portfolio:\n");
        for (Stock stk : stockList)
            System.out.println(stk);
    }

    private static void pause()
    {
        System.out.print("\nPress ENTER to continue...");
        scan.nextLine();
        System.out.println("\n\n");
    }
    
}
