/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author June
 */
public class create_JProgressBar extends JFrame{
    private JPanel myJPanel;
    private Timer myTimer;
    private JProgressBar myJProgressBar;
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
        myJPanel = new JPanel();
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }
    public void create_myJProgressBar(){
        myJProgressBar=new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
//        myJProgressBar.setValue(0);
    }
    public void add_myJProgressBar_to_JPanel(){
        myJPanel.add(myJProgressBar);
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
        create_JProgressBar mycreate_JProgressBar = new create_JProgressBar();
        mycreate_JProgressBar.create_JFrame("Example JProgressBar");
        mycreate_JProgressBar.create_JPanel();
        mycreate_JProgressBar.create_myJProgressBar();
        mycreate_JProgressBar.create_myTimer();
        mycreate_JProgressBar.start_Timer();
        mycreate_JProgressBar.add_myJProgressBar_to_JPanel();
        mycreate_JProgressBar.add_JPanel_to_JFrame();
        mycreate_JProgressBar.display_JFrame();
    }
}
