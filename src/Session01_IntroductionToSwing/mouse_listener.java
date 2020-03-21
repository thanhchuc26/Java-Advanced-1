/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class mouse_listener extends JFrame implements MouseListener{
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
        myJTextField.addMouseListener(this);
    }
    public static void main(String[] args) {
        mouse_listener mymouse_listener = new mouse_listener();
        mymouse_listener.create_JFrame("Mouse Listener");
        myJTextField1=mymouse_listener.create_JTextField(30);
        myJTextField1.setText("Textbox 1");
        mymouse_listener.add_JTextfield(myJTextField1);
        myJTextField2=mymouse_listener.create_JTextField(30);
        mymouse_listener.add_JTextfield(myJTextField2);
        myJTextField2.setText("Textbox 2");
        myJLabel1 = mymouse_listener.create_JLabel("Status textbox 1: ");
        mymouse_listener.add_JLabel(myJLabel1);
        myJLabel2 = mymouse_listener.create_JLabel("Status textbox 2: ");
        mymouse_listener.add_JLabel(myJLabel2);
        mymouse_listener.add_Focus_JTextField(myJTextField1);
        mymouse_listener.add_Focus_JTextField(myJTextField2);
        mymouse_listener.display_JFrame();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==myJTextField1)
            myJLabel1.setText("Status: Textbox 1 got mouse click");
        if (me.getSource()==myJTextField2)
            myJLabel2.setText("Status: Textbox 2 got mouse click");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource()==myJTextField1)
            myJLabel1.setText("Status: Textbox 1 got mouse press");
        if (me.getSource()==myJTextField2)
            myJLabel2.setText("Status: Textbox 2 got mouse press");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource()==myJTextField1)
            myJLabel1.setText("Status: Textbox 1 got mouse release");
        if (me.getSource()==myJTextField2)
            myJLabel2.setText("Status: Textbox 2 got mouse release");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource()==myJTextField1)
            myJLabel1.setText("Status: Textbox 1 got mouse enter");
        if (me.getSource()==myJTextField2)
            myJLabel2.setText("Status: Textbox 2 got mouse enter");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource()==myJTextField1)
            myJLabel1.setText("Status: Textbox 1 got mouse exit");
        if (me.getSource()==myJTextField2)
            myJLabel2.setText("Status: Textbox 2 got mouse exit");
    }
}
