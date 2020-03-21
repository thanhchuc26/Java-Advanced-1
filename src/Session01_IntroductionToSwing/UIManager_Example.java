/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author June
 */
public class UIManager_Example extends JFrame {

    JPanel myJPanel;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(300, 300);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JPanel() {
        myJPanel = new JPanel();
    }

    public void set_Layout_JPanel() {
        myJPanel.setLayout(new GridLayout(3, 3));
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public JButton create_JButton(String title) {
        JButton myJButton = new JButton(title);
        return myJButton;
    }

    public void add_JButton_to_JPanel() {
        int i;
        for (i = 0; i < 9; i++) {
            myJPanel.add(create_JButton(String.valueOf(i + 1)));
            myJPanel.validate();
            myJPanel.repaint();
        }
    }

    void withUIManager() throws InstantiationException, IllegalAccessException {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception : " + ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        create_JFrame("JFrame with GridLayout");
        create_JPanel();
        set_Layout_JPanel();
        add_JButton_to_JPanel();
        add_JPanel_to_JFrame();
        display_JFrame();
    }

    void noUIManager() throws InstantiationException, IllegalAccessException {
        create_JFrame("JFrame with GridLayout");
        create_JPanel();
        set_Layout_JPanel();
        add_JButton_to_JPanel();
        add_JPanel_to_JFrame();
        display_JFrame();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        UIManager_Example myFlowLayout = new UIManager_Example();
        myFlowLayout.noUIManager();
        myFlowLayout.withUIManager();
    }
}
