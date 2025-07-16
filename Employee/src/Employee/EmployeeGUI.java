package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Chelly
 */
public class EmployeeGUI extends JFrame {

    //GUI components
    private JTextField txtName, txtHours, txtRate, txtPay;
    private JButton btnCalc, btnClear;
    
    //Declare Employee Object
    private Employee emp;

    //constructor building the GUI
    public EmployeeGUI() {
        //superclass constructor call
        super("Calculate Employee Pay");
        
        //instantiate employee
        emp = new Employee();

        //instantiate components
        txtName = new JTextField(20);
        txtHours = new JTextField(10);
        txtRate = new JTextField(10);
        txtPay = new JTextField(10);
        btnCalc = new JButton("Calculate Pay");
        btnClear = new JButton("Clear");

        //set the layout
        setLayout(new GridLayout(0, 2));

        //add components to the frame
        add(new JLabel("Name"));
        add(txtName);
        add(new JLabel("Hours"));
        add(txtHours);
        add(new JLabel("Rate"));
        add(txtRate);
        add(btnCalc);
        add(btnClear);
        add(new JLabel("Pay"));
        add(txtPay);

        //Event Handlers
        ButtonHandler handler = new ButtonHandler();
        //connect buttons to ActionListener
        btnCalc.addActionListener(handler);
        btnClear.addActionListener(handler);
    }

    //ActionListener implementation        
    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //code to process the button events goes here
            if (e.getSource() == btnCalc) {
                //get input from GUI and pass to object
                if (txtName.getText().isEmpty()
                        || txtHours.getText().isEmpty()
                        || txtRate.getText().isEmpty()) //missing input
                {
                    JOptionPane.showMessageDialog(null, "Please provide all input");
                    return;
                }
                emp.setName(txtName.getText());
                try {
                    emp.setHours(Double.parseDouble(txtHours.getText()));
                    emp.setRate(Double.parseDouble(txtRate.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Hours, rate must be numeric");
                }
                //display result on GUI
                txtPay.setText(String.valueOf(emp.getPay()));
            } else if (e.getSource() == btnClear) {
                JOptionPane.showMessageDialog(null, "Clear clicked");
            }
        }
    }
}
