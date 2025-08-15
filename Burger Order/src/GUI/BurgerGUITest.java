package GUI;

import javax.swing.JFrame;

/**
 *
 * @author Michelle Buchholz
 * DeVry CIS355A Week 3 Optional Lab
 * 
 */

public class BurgerGUITest {
    public static void main(String[] args) {
        BurgerGUI frame = new BurgerGUI();
        frame.setTitle("Burger Order System");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
