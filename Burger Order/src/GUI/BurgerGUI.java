package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Michelle Buchholz
 * DeVry CIS355A Week 3 Optional Lab
 * 
 */

public class BurgerGUI extends JFrame {

    private final JRadioButton radSingle;
    private final JRadioButton radDouble;
    private final JCheckBox chkCheese;
    private final JCheckBox chkBacon;
    private final JCheckBox chkMeal;
    private final JTextArea txtOrder;
    private final JTextField txtItemPrice, txtQuantity, txtOrderTotal;
    private final JMenuItem itemAdd, itemShow, itemClear, itemNew, itemExit;

    private final StringBuilder fullOrder = new StringBuilder();
    private double orderTotal = 0.0;

    public BurgerGUI() {
        // ----- Menu Setup -----
        JMenu mnuOrder = new JMenu("Order");
        itemAdd = new JMenuItem("Add to Order");
        itemClear = new JMenuItem("Clear for Next Order");
        itemNew = new JMenuItem("New Order");
        itemShow = new JMenuItem("Show Current Order");
        itemExit = new JMenuItem("Exit");

        mnuOrder.add(itemAdd);
        mnuOrder.add(itemClear);
        mnuOrder.add(itemNew);
        mnuOrder.add(itemShow);

        JMenu mnuExit = new JMenu("Exit");
        mnuExit.add(itemExit);

        JMenuBar bar = new JMenuBar();
        bar.add(mnuExit);
        bar.add(mnuOrder);
        this.setJMenuBar(bar);

        itemAdd.addActionListener(e -> addToOrder());
        itemClear.addActionListener(e -> clearCurrentSelection());
        itemNew.addActionListener(e -> startNewOrder());
        itemShow.addActionListener(e -> showCurrentOrder());
        itemExit.addActionListener(e -> System.exit(0));

        // ----- Header -----
        JLabel lblHeader = new JLabel("Your Order", JLabel.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 18));

        // ----- Burger Selection -----
        radSingle = new JRadioButton("Single Burger");
        radDouble = new JRadioButton("Double Burger");
        ButtonGroup b = new ButtonGroup();
        b.add(radSingle);
        b.add(radDouble);

        chkCheese = new JCheckBox("Add Cheese");
        chkBacon = new JCheckBox("Add Bacon");
        chkMeal = new JCheckBox("Make it a Meal");

        // ----- Left Column -----
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setBorder(BorderFactory.createTitledBorder("Burger Type"));
        radioPanel.add(radSingle);
        radioPanel.add(radDouble);

        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));
        checkboxPanel.setBorder(BorderFactory.createTitledBorder("Extras"));
        checkboxPanel.add(chkCheese);
        checkboxPanel.add(chkBacon);
        checkboxPanel.add(chkMeal);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(radioPanel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(checkboxPanel);

        // ----- Right Column -----
        txtOrder = new JTextArea(10, 25);
        txtOrder.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtOrder);
        scroll.setPreferredSize(new Dimension(300, 200));

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(scroll, BorderLayout.CENTER);

        // ----- Top Panel -----
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(leftPanel);
        topPanel.add(Box.createHorizontalStrut(10));
        topPanel.add(rightPanel);

        // ----- Bottom Panel -----
        txtItemPrice = new JTextField(8);
        txtItemPrice.setEditable(false);
        txtOrderTotal = new JTextField(8);
        txtOrderTotal.setEditable(false);
        txtQuantity = new JTextField(8);

        JPanel leftBottomPanel = new JPanel();
        leftBottomPanel.setLayout(new BoxLayout(leftBottomPanel, BoxLayout.Y_AXIS));
        leftBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lblQuantity = new JLabel("Quantity:");
        txtQuantity.setMaximumSize(new Dimension(100, 25));
        leftBottomPanel.add(lblQuantity);
        leftBottomPanel.add(Box.createVerticalStrut(5));
        leftBottomPanel.add(txtQuantity);

        JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblItemPrice = new JLabel("Item Price:");
        pricePanel.add(lblItemPrice);
        pricePanel.add(txtItemPrice);

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblOrderTotal = new JLabel("Order Total:");
        totalPanel.add(lblOrderTotal);
        totalPanel.add(txtOrderTotal);

        JPanel rightBottomPanel = new JPanel();
        rightBottomPanel.setLayout(new BoxLayout(rightBottomPanel, BoxLayout.Y_AXIS));
        rightBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightBottomPanel.add(pricePanel);
        rightBottomPanel.add(totalPanel);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(leftBottomPanel, BorderLayout.WEST);
        bottomPanel.add(rightBottomPanel, BorderLayout.EAST);

        // ----- Layout -----
        setLayout(new BorderLayout());
        add(lblHeader, BorderLayout.NORTH);
        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // ----- Dynamic Update Listeners -----
        ItemListener updateListener = e -> updatePrice();
        ActionListener updateAction = e -> updatePrice();

        radSingle.addItemListener(updateListener);
        radDouble.addItemListener(updateListener);
        chkCheese.addItemListener(updateListener);
        chkBacon.addItemListener(updateListener);
        chkMeal.addItemListener(updateListener);
        txtQuantity.addActionListener(updateAction);
        txtQuantity.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updatePrice(); }
            @Override
            public void removeUpdate(DocumentEvent e) { updatePrice(); }
            @Override
            public void changedUpdate(DocumentEvent e) { updatePrice(); }
        });
    }

    private void updatePrice() {
        String type = radSingle.isSelected() ? "Single" : radDouble.isSelected() ? "Double" : "";
        boolean cheese = chkCheese.isSelected();
        boolean bacon = chkBacon.isSelected();
        boolean meal = chkMeal.isSelected();

        int quantity;
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
            quantity = 1;  // Default to 1 if invalid
        }

        if (!type.isEmpty()) {
            BurgerOrder order = new BurgerOrder(type, cheese, bacon, meal, quantity);
            txtItemPrice.setText(String.format("%.2f", order.calculateItemCost()));
            txtOrderTotal.setText(String.format("%.2f", order.calculateTotalCost()));
            txtOrder.setText(order.toString());
        } else {
            txtItemPrice.setText("");
            txtOrderTotal.setText("");
            txtOrder.setText("");
        }
    }

    private void addToOrder() {
        String type = radSingle.isSelected() ? "Single" : radDouble.isSelected() ? "Double" : "";
        if (type.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a burger type.");
            return;
        }

        boolean cheese = chkCheese.isSelected();
        boolean bacon = chkBacon.isSelected();
        boolean meal = chkMeal.isSelected();

        int quantity;
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
            if (quantity <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
            return;
        }

        BurgerOrder order = new BurgerOrder(type, cheese, bacon, meal, quantity);
        orderTotal += order.calculateTotalCost();
        fullOrder.append(order.toString()).append("\n");

        clearCurrentSelection();
    }

    private void clearCurrentSelection() {
        radSingle.setSelected(false);
        radDouble.setSelected(false);
        chkCheese.setSelected(false);
        chkBacon.setSelected(false);
        chkMeal.setSelected(false);
        txtQuantity.setText("");
        txtItemPrice.setText("");
        txtOrderTotal.setText("");
        txtOrder.setText("");
    }

    private void startNewOrder() {
        clearCurrentSelection();
        fullOrder.setLength(0);
        orderTotal = 0.0;
        JOptionPane.showMessageDialog(this, "New order started.");
    }

    private void showCurrentOrder() {
        if (fullOrder.length() == 0) {
            JOptionPane.showMessageDialog(this, "No items in the order.");
        } else {
            txtOrder.setText(fullOrder.toString() + "\nTotal: $" + String.format("%.2f", orderTotal));
        }
    }
}
