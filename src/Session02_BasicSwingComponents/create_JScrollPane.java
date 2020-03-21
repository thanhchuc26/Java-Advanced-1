/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author June
 */
public class create_JScrollPane extends JFrame {

    JPanel mainPanel;
    JTextArea txtAreaComments, txtAreaComments1;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Example JScrollPane");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel();
    }

    void create_and_add_txtAreaComments_to_mainPanel() {
        txtAreaComments = new JTextArea(5, 10);
        txtAreaComments.setWrapStyleWord(true);
        txtAreaComments.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(txtAreaComments);
        mainPanel.add(scrollPane);
    }

    void create_and_add_txtAreaComments1_to_mainPanel() {
        txtAreaComments1 = new JTextArea(5, 10);
        txtAreaComments1.setWrapStyleWord(true);
        txtAreaComments1.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(txtAreaComments1);
        mainPanel.add(scrollPane);
    }

    void addMainPanel_to_JFrame() {
        add(this.mainPanel);
    }

    void displayJFrame() {
        setVisible(true);
    }

    public static void main(String[] args) {
        create_JScrollPane test = new create_JScrollPane();
        test.create_JFrame();
        test.create_mainPanel();
        test.create_and_add_txtAreaComments_to_mainPanel();
        test.create_and_add_txtAreaComments1_to_mainPanel();
        test.addMainPanel_to_JFrame();
        test.displayJFrame();
    }
}
