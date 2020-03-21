/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class focus_listener extends JFrame implements FocusListener{
    static JTextField myJTextField1,myJTextField2;
    static JLabel myJLabel1,myJLabel2;
    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
//        setSize(500, 200);
        setLayout(new GridLayout(2, 0, 5, 5));
    }
    public void display_JFrame() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public JLabel create_JLabel(String title){
        JLabel myJLabel = new JLabel(title);
        return myJLabel;
    }
    public void add_JLabel(JLabel myJLabel) {
        add(myJLabel);
    }
    public JTextField create_JTextField(int colum){
        JTextField myJTextField=new JTextField(colum);
        return myJTextField;
    }
    public void add_JTextfield(JTextField myJTextField) {
        add(myJTextField);
    }
    public void add_Focus_JTextField(JTextField myJTextField){
        myJTextField.addFocusListener(this);
    }
    public static void main(String[] args) {
        focus_listener myfocus_listener = new focus_listener();
        myfocus_listener.create_JFrame("Focus Listener");
        myJTextField1=myfocus_listener.create_JTextField(30);
        myJTextField1.setText("Textbox 1");
        myfocus_listener.add_JTextfield(myJTextField1);
        myJTextField2=myfocus_listener.create_JTextField(30);
        myfocus_listener.add_JTextfield(myJTextField2);
        myJTextField2.setText("Textbox 2");
        myJLabel1 = myfocus_listener.create_JLabel("Status textbox 1: ");
        myfocus_listener.add_JLabel(myJLabel1);
        myJLabel2 = myfocus_listener.create_JLabel("Status textbox 2: ");
        myfocus_listener.add_JLabel(myJLabel2);
        myfocus_listener.add_Focus_JTextField(myJTextField1);
        myfocus_listener.add_Focus_JTextField(myJTextField2);
        myfocus_listener.display_JFrame();
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if(fe.getSource()==myJTextField1)
            myJLabel1.setText("Status: Textbox 1 got focus. ");
        if(fe.getSource()==myJTextField2)
            myJLabel2.setText("Status: Textbox 2 got focus.");
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if(fe.getSource()==myJTextField1)
            myJLabel1.setText("Status: Textbox 1 lost focus. ");
        if(fe.getSource()==myJTextField2)
            myJLabel2.setText("Status: Textbox 2 lost focus.");
    }
}
