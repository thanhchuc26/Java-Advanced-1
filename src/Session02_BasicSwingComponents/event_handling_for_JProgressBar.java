/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author June
 */
public class event_handling_for_JProgressBar  extends JFrame{
    private JPanel myJPanel;
    private Timer myTimer;
    private JProgressBar myJProgressBar;
    private JLabel myJLabel;
    static int count=0;
    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(300, 100);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JPanel() {
        myJPanel = new JPanel(new GridLayout(2, 1, 5, 5));
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }
    public void create_myJProgressBar(){
        myJProgressBar=new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        myJProgressBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                myJLabel.setText("Value of JProgressBar: "+myJProgressBar.getValue()+"%");
            }
        });
//        myJProgressBar.setValue(0);
    }
    public void add_myJProgressBar_to_JPanel(){
        myJPanel.add(myJProgressBar);
    }
    public void create_JLabel(){
        myJLabel=new JLabel("Value of JProgressBar: ");
    }
    public void add_JLabel_to_JPanel(){
        myJPanel.add(myJLabel);
    }
    public void create_myTimer() {
        myTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                count+=1;
                myJProgressBar.setValue(count);
                myJProgressBar.setString(myJProgressBar.getValue()+"%");
                myJProgressBar.setStringPainted(true);
                if (count == 60000) {
                    myTimer.stop();
                }
            }
        });
    }
    public void start_Timer() {
        myTimer.start();
    }
    public static void main(String[] args) {
        event_handling_for_JProgressBar myevent_handling_for_JProgressBar = new event_handling_for_JProgressBar();
        myevent_handling_for_JProgressBar.create_JFrame("Example JProgressBar");
        myevent_handling_for_JProgressBar.create_JPanel();
        myevent_handling_for_JProgressBar.create_myJProgressBar();
        myevent_handling_for_JProgressBar.create_myTimer();
        myevent_handling_for_JProgressBar.start_Timer();
        myevent_handling_for_JProgressBar.add_myJProgressBar_to_JPanel();
        myevent_handling_for_JProgressBar.create_JLabel();
        myevent_handling_for_JProgressBar.add_JLabel_to_JPanel();
        myevent_handling_for_JProgressBar.add_JPanel_to_JFrame();
        myevent_handling_for_JProgressBar.display_JFrame();
    }
}
