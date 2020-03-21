/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author June
 */
public class create_Timer extends JFrame {

    private JPanel myJPanel;
    private JLabel myJLabel;
    private Timer myTimer;
    static int count = 0;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 200);
    }

    public void display_JFrame() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JPanel() {
        myJPanel = new JPanel();
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void create_JLabel() {
        myJLabel = new JLabel("Auto count every 5 seconds 1 times: " + count);
    }

    public void add_JLabel_to_JPanel() {
        myJPanel.add(myJLabel);
    }

    public void create_myTimer() {
        myTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                count++;
                myJLabel.setText("Auto count every 1 seconds 1 time: " + count);
                if (count == 10) {
                    myTimer.stop();
                }
            }
        });
    }

    public void start_Timer() {
        myTimer.start();
    }

    public static void main(String[] args) {
        create_Timer mycreate_Timer = new create_Timer();
        mycreate_Timer.create_JFrame("Example Timer");
        mycreate_Timer.create_JPanel();
        mycreate_Timer.create_JLabel();
        mycreate_Timer.add_JLabel_to_JPanel();
        mycreate_Timer.add_JPanel_to_JFrame();
        mycreate_Timer.create_myTimer();
        mycreate_Timer.start_Timer();
        mycreate_Timer.display_JFrame();
    }
}
