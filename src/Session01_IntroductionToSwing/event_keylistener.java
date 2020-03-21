/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class event_keylistener extends JFrame implements KeyListener {

    JTextField myJTextField;
    static JLabel myJLabel1, myJLabel2;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 200);
        setLayout(new GridLayout(3, 1, 5, 5));
    }

    public void display_JFrame() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JTextField() {
        myJTextField = new JTextField(20);
    }

    public void add_JTextField() {
        add(myJTextField);
    }

    public void add_event_for_JTextField() {
        myJTextField.addKeyListener(this);
    }

    public JLabel create_JLabel(String title) {
        JLabel myJLabel = new JLabel(title);
        return myJLabel;
    }

    public void add_JLabel(JLabel myJLabel) {
        add(myJLabel);
    }

    public static void main(String[] args) {
        event_keylistener myevent_keylistener = new event_keylistener();
        myevent_keylistener.create_JFrame("Event Keylistener");
        myevent_keylistener.create_JTextField();
        myevent_keylistener.add_JTextField();
        myJLabel1 = myevent_keylistener.create_JLabel("Label 1: ");
        myevent_keylistener.add_JLabel(myJLabel1);
        myJLabel2 = myevent_keylistener.create_JLabel("Label 2: ");
        myevent_keylistener.add_JLabel(myJLabel2);
        myevent_keylistener.add_event_for_JTextField();
        myevent_keylistener.display_JFrame();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        myJLabel1.setText(myJLabel1.getText() + ke.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        myJLabel2.setText("You are pressing keyboard");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        myJLabel2.setText("You are Released keyboard");
    }
}
