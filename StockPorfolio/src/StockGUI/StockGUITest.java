package StockGUI;

import javax.swing.JFrame;

/**
 *
 * @author Michelle Buchholz
 * DeVry CIS355A Week 4 Optional Lab
 */
public class StockGUITest {
    public static void main (String[] args){
        TabbedStockApp t = new TabbedStockApp();
        t.setSize(600, 400);
        t.setLocationRelativeTo(null);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setVisible(true);
    }
}
