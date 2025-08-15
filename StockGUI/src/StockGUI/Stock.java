package StockGUI;

/**
 * Author: Michelle Buchholz
 * DeVry CIS355A Week 4 Optional Lab
 */

public class Stock {

    // Attributes
    private String companyName;
    private int numberOfShares;
    private double purchasePrice;
    private double currentPrice;

    // Constructors
    public Stock() {
        companyName = "N/A";
        numberOfShares = 0;
        purchasePrice = 0.0;
        currentPrice = 0.0;
    }

    public Stock(String companyName, int numberOfShares, double purchasePrice, double currentPrice) {
        setCompanyName(companyName);
        setNumberOfShares(numberOfShares);
        setPurchasePrice(purchasePrice);
        setCurrentPrice(currentPrice);
    }

    // Behaviors
    public double getProfitLoss() {
        return numberOfShares * (currentPrice - purchasePrice);
    }

    @Override
    public String toString() {
        return companyName + ": " + numberOfShares + " shares";
    }

    // Getters & Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;

    }
}
