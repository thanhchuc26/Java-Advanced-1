/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author June
 */
public class event_handling_for_JButton_use_inner_class extends JFrame implements ActionListener {

    private JButton myJButton;
    private JLabel myJLabel;
    private int count = 0;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 200);
        setLayout(new GridLayout(2, 1, 5, 5));
    }

    public void display_JFrame() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JButton(String title) {
        myJButton = new JButton(title);
    }

    public void add_JButton() {
        add(myJButton);
    }

    public void add_event_for_JButton() {
        myJButton.addActionListener(this);
    }

    public void create_JLabel(String title) {
        myJLabel = new JLabel(title);
    }

    public void add_JLabel() {
        add(myJLabel);
    }

    public static void main(String[] args) {
        event_handling_for_JButton_use_inner_class event_handling_for_JButton = new event_handling_for_JButton_use_inner_class();
        event_handling_for_JButton.create_JFrame("Example");
        event_handling_for_JButton.create_JLabel("My label");
        event_handling_for_JButton.add_JLabel();
        event_handling_for_JButton.create_JButton("My button");
        event_handling_for_JButton.add_JButton();
        event_handling_for_JButton.add_event_for_JButton();
        event_handling_for_JButton.display_JFrame();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        count++;
        if (count == 1) {
            myJLabel.setText("You click my button 1 time!");
        } else {
            myJLabel.setText("You click my button " + count + " times!");
        }
    }
}
