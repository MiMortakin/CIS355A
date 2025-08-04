package StockGUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Michelle Buchholz
 * DeVry CIS355A Week 4 Optional Lab
 */

public class TabbedStockApp extends JFrame {

    public TabbedStockApp() {
        super("Stock Portfolio Manager");
        JTabbedPane tab = new JTabbedPane();

        // Tab 1: Welcome
        JLabel welcomeLabel = new JLabel("Welcome to Stock Portfolio", SwingConstants.CENTER);
        JPanel welcomePanel = new JPanel(new java.awt.BorderLayout());
        welcomePanel.add(welcomeLabel, java.awt.BorderLayout.CENTER);
        tab.addTab("Welcome", null, welcomePanel, "Welcome Screen");

        // ✅ Shared StockGUI instance
        StockGUI stockGUI = new StockGUI();

        // Tab 2: Add/Remove
        tab.addTab("Manage Stocks", null, stockGUI.getInputPanel(), "Add/Remove Stocks");

        // Tab 3: Stock List
        tab.addTab("Stock List", null, stockGUI.getListPanel(), "View Stock List");

        add(tab);
    }
}