package StockGUI;

/**
 * Author: Michelle Buchholz
 * DeVry CIS355A Week 3 Optional Lab
 */

public class Main {
    // Attributes
    private String companyName;
    private int nbrOfShares;
    private double purchasePrice;
    private double currentPrice;

    // Constructor with all relevant parameters
    public Main(String companyName, int nbrOfShares, double purchasePrice, double currentPrice) {
        this.companyName = companyName;
        this.nbrOfShares = nbrOfShares;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    // Behaviors
    public double getProfitLoss() {
        return nbrOfShares * (currentPrice - purchasePrice);
    }

    @Override
    public String toString() {
        return companyName + ": " + nbrOfShares + " shares";
    }

    // Getters & Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNumberOfShares() {
        return nbrOfShares;
    }

    public void setNumberOfShares(int nbrOfShares) {
        this.nbrOfShares = nbrOfShares;
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

    // Used in GUI to display stock details
    public String getCompany() {
        return companyName;
    }
}
