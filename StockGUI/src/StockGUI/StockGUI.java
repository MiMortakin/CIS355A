package StockGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Author: Michelle Buchholz
 * DeVry CIS355A Week 4 Optional Lab
 */

public class StockGUI extends JFrame {
    private ArrayList<Stock> stockList = new ArrayList<>();
    private DefaultListModel<Stock> listModel = new DefaultListModel<>();
    private JList<Stock> stockJList = new JList<>(listModel);
    private JTextField profitLossField = new JTextField(15);

    // Add stock fields
    private JTextField nameField = new JTextField(10);
    private JTextField qtyField = new JTextField(5);
    private JTextField purchaseField = new JTextField(7);
    private JTextField currentField = new JTextField(7);

    public StockGUI() {
        super("Stocks Portfolio");

        // Tab 1: Show Stocks
        JPanel showPanel = new JPanel(new BorderLayout());
        stockJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stockJList.addListSelectionListener(e -> showProfitLoss());
        showPanel.add(new JScrollPane(stockJList), BorderLayout.CENTER);

        JPanel bottomShowPanel = new JPanel();
        profitLossField.setEditable(false);
        bottomShowPanel.add(new JLabel("Profit/Loss:"));
        bottomShowPanel.add(profitLossField);

        JButton removeButton = new JButton("Remove Stock");
        removeButton.addActionListener(e -> removeStock());
        bottomShowPanel.add(removeButton);
        showPanel.add(bottomShowPanel, BorderLayout.SOUTH);

        // Tab 2: Add Stock
        JPanel addPanel = new JPanel(new GridLayout(5, 2));
        addPanel.add(new JLabel("Company Name:"));
        addPanel.add(nameField);
        addPanel.add(new JLabel("Quantity:"));
        addPanel.add(qtyField);
        addPanel.add(new JLabel("Purchase Price:"));
        addPanel.add(purchaseField);
        addPanel.add(new JLabel("Current Price:"));
        addPanel.add(currentField);

        JButton addButton = new JButton("Add Stock");
        addButton.addActionListener(e -> addStock());
        addPanel.add(new JLabel());
        addPanel.add(addButton);

        // Tabs
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Show Stocks", showPanel);
        tabs.addTab("Add Stock", addPanel);

        // Frame
        add(tabs);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showProfitLoss() {
        Stock selected = stockJList.getSelectedValue();
        if (selected != null) {
            double pl = selected.getProfitLoss();
            profitLossField.setText(String.format("%.2f", pl));
        }
    }

    private void addStock() {
        try {
            String name = nameField.getText();
            int qty = Integer.parseInt(qtyField.getText());
            double purchase = Double.parseDouble(purchaseField.getText());
            double current = Double.parseDouble(currentField.getText());

            Stock newStock = new Stock(name, qty, purchase, current);
            stockList.add(newStock);
            listModel.addElement(newStock);

            nameField.setText("");
            qtyField.setText("");
            purchaseField.setText("");
            currentField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    private void removeStock() {
        int index = stockJList.getSelectedIndex();
        if (index != -1) {
            stockList.remove(index);
            listModel.remove(index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StockGUI());
    }
}
