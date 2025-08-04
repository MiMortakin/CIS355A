package StockGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Author: Michelle Buchholz
 * DeVry CIS355A Week 3 Optional Lab
 */

public class StockGUI {
    private JList<Main> stkList;
    private DefaultListModel<Main> stkModel;
    private final JTextField txtCompany = new JTextField();
    private final JTextField txtNumber = new JTextField();
    private final JTextField txtPurchase = new JTextField();
    private final JTextField txtCurrent = new JTextField();
    private final JButton btnAdd = new JButton("Add");

    public StockGUI() {
        stkModel = new DefaultListModel<>();
        stkList = new JList<>(stkModel);

        // Sample data
        stkModel.addElement(new Main("IBM", 10, 100, 150));
        stkModel.addElement(new Main("Apple", 10, 200, 150));
    }

    // Input Panel (Add only)
    public JPanel getInputPanel() {
        JPanel pnlTop = new JPanel(new GridLayout(5, 2));
        pnlTop.add(new JLabel("Stock:"));
        pnlTop.add(txtCompany);

        pnlTop.add(new JLabel("Number of Stocks:"));
        pnlTop.add(txtNumber);

        pnlTop.add(new JLabel("Purchase Price:"));
        pnlTop.add(txtPurchase);

        pnlTop.add(new JLabel("Current Price:"));
        pnlTop.add(txtCurrent);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    String company = txtCompany.getText();
                    int shares = Integer.parseInt(txtNumber.getText());
                    double purchase = Double.parseDouble(txtPurchase.getText());
                    double current = Double.parseDouble(txtCurrent.getText());

                    Main newStk = new Main(company, shares, purchase, current);
                    stkModel.addElement(newStk);

                    // Clear input fields
                    txtCompany.setText("");
                    txtNumber.setText("");
                    txtPurchase.setText("");
                    txtCurrent.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please check your entries.");
                }
            }
        });

        pnlTop.add(btnAdd);
        // No remove button here
        return pnlTop;
    }

    // List Panel with Remove Button
    public JPanel getListPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        stkList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stkList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && stkList.getSelectedIndex() != -1) {
                    Main e = stkList.getSelectedValue();
                    String msg = "Company: " + e.getCompany()
                            + "\nNumber of Shares: " + e.getNumberOfShares()
                            + "\nPurchase Price: " + e.getPurchasePrice()
                            + "\nCurrent Price: " + e.getCurrentPrice()
                            + "\nProfit/Loss: " + e.getProfitLoss();
                    JOptionPane.showMessageDialog(null, msg);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(stkList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Remove button under the list
        JButton btnRemove = new JButton("Remove Selected Stock");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                int item = stkList.getSelectedIndex();
                if (item == -1) {
                    JOptionPane.showMessageDialog(null, "Select a stock to remove.");
                } else {
                    stkModel.removeElementAt(item);
                }
            }
        });

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.add(btnRemove);
        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }
}
