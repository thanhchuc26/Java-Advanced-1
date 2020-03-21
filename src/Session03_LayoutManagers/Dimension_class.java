/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class Dimension_class extends JFrame {

    JPanel myJPanel;
    JButton myJButton;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 200);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JPanel() {
        myJPanel = new JPanel();
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void create_JButton() {
        myJButton = new JButton("Dimension button");
        myJButton.setMinimumSize(new Dimension(50, 20));
        myJButton.setMaximumSize(new Dimension(200, 25));
        myJButton.setPreferredSize(new Dimension(150, 25));
//        myJButton.setSize(new Dimension(150,25));
    }

    public void add_JButton_to_JPanel() {
        myJPanel.add(myJButton);
    }

    public void display_size_of_JButton() {
        System.out.println("Width: " + myJButton.getWidth() + ". Height: " + myJButton.getHeight());
    }

    public static void main(String[] args) {
        Dimension_class myDimension_class = new Dimension_class();
        myDimension_class.create_JFrame("Dimension class");
        myDimension_class.create_JPanel();
        myDimension_class.create_JButton();
        myDimension_class.add_JButton_to_JPanel();
        myDimension_class.add_JPanel_to_JFrame();
        myDimension_class.display_JFrame();
        myDimension_class.display_size_of_JButton();
    }
}
