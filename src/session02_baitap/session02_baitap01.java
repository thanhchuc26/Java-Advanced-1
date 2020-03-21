/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session02_baitap;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author June
 */
public class session02_baitap01 extends JFrame {

    JPanel mainPanel;
    JSlider sliderMinutes;
    JProgressBar prgbarCount;
    JButton btnCountDown, btnStop;
    int timeCountDown;
    Timer time;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Count down timer");
        setSize(550, 140);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel();
    }

    void create_and_add_lblMinutes_to_mainPanel() {
        JLabel lblMinutes = new JLabel("Minutes");
        lblMinutes.setFont(new Font(lblMinutes.getName(), Font.BOLD, 15));
        mainPanel.add(lblMinutes);
    }

    void create_and_add_silerMinutes_to_mainPanel() {
        sliderMinutes = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        sliderMinutes.setMinorTickSpacing(1);
        sliderMinutes.setMajorTickSpacing(10);
        sliderMinutes.setMajorTickSpacing(1);
        sliderMinutes.setPaintTicks(true);
        sliderMinutes.setPaintLabels(true);
        mainPanel.add(sliderMinutes);
    }

    void create_and_add_btnCountDown_to_mainPanel() {
        btnCountDown = new JButton("Count down");
        btnCountDown.setFont(new Font(btnCountDown.getName(), Font.BOLD, 15));
        btnCountDown.setPreferredSize(new Dimension(120, 50));
        btnCountDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (sliderMinutes.getValue() == 0) {
                    JOptionPane.showMessageDialog(null, "Please choose minute to count down! ", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    btnCountDown.setEnabled(false);
                    btnStop.setEnabled(true);
                    sliderMinutes.setEnabled(false);
                    timeCountDown = 60 * sliderMinutes.getValue();
                    prgbarCount.setMinimum(0);
                    prgbarCount.setMaximum(60 * sliderMinutes.getValue());
                    prgbarCount.setValue(timeCountDown);
                    time = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            timeCountDown--;
                            prgbarCount.setValue(timeCountDown);
                            prgbarCount.setString(prgbarCount.getValue() + " seconds");
                            if (timeCountDown == 0) {
                                time.stop();
                                JOptionPane.showMessageDialog(null, "Time out! ", "Message", JOptionPane.INFORMATION_MESSAGE);
                                sliderMinutes.setEnabled(true);
                                btnCountDown.setEnabled(true);
                                btnStop.setEnabled(false);
                            }
                        }
                    });
                    time.start();
                }
            }
        });
        mainPanel.add(btnCountDown);
    }

    void create_and_add_btnStop_to_mainPanel() {
        btnStop = new JButton("Stop");
        btnStop.setFont(new Font(btnStop.getName(), Font.BOLD, 15));
        btnStop.setPreferredSize(new Dimension(120, 50));
        btnStop.setEnabled(false);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                time.stop();
                sliderMinutes.setEnabled(true);
                btnCountDown.setEnabled(true);
                btnStop.setEnabled(false);
            }
        });
        mainPanel.add(btnStop);
    }

    void create_and_add_prgarCount_to_mainPanel() {
        prgbarCount = new JProgressBar(0, 100);
        prgbarCount.setPreferredSize(new Dimension(510, 30));
        prgbarCount.setString("0 seconds");
        prgbarCount.setStringPainted(true);
        mainPanel.add(prgbarCount);
    }

    void addMainPanel_to_JFrame() {
        add(this.mainPanel);
    }

    void displayJFrame() {
        setVisible(true);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        session02_baitap01 countDown = new session02_baitap01();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        countDown.create_JFrame();
        countDown.create_mainPanel();
        countDown.create_and_add_lblMinutes_to_mainPanel();
        countDown.create_and_add_silerMinutes_to_mainPanel();
        countDown.create_and_add_btnCountDown_to_mainPanel();
        countDown.create_and_add_btnStop_to_mainPanel();
        countDown.create_and_add_prgarCount_to_mainPanel();
        countDown.addMainPanel_to_JFrame();
        countDown.displayJFrame();
    }
}
