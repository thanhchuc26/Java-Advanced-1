/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03_baitap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author June
 */
class Calculator extends JFrame {

    JPanel mainPanel, ketQuaPanel, memoryPanel, btnCalculatorPanel;
    JTextField myJTextField1, myJTextField2;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(360, 515);
        setResizable(false);
    }

    public void create_mainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);
    }

    public void create_and_add_ketQuaPanel_to_mainPanel() {
        ketQuaPanel = new JPanel();
        JLabel nhap = new JLabel("0");
        nhap.setPreferredSize(new Dimension(330, 50));
        nhap.setHorizontalAlignment(JTextField.RIGHT);
        nhap.setFont(new Font(nhap.getName(), Font.BOLD, 30));
        nhap.setBackground(Color.white);
        nhap.setOpaque(true);
        ketQuaPanel.add(nhap);
        mainPanel.add(ketQuaPanel, BorderLayout.NORTH);
    }

    public void create_and_add_memoryPanel_to_mainPanel() {
        memoryPanel = new JPanel();
        JButton btnMC = new JButton("MC");
        btnMC.setPreferredSize(new Dimension(62, 30));
        JButton btnMR = new JButton("MR");
        btnMR.setPreferredSize(new Dimension(62, 30));
        JButton btnMPlus = new JButton("M+");
        btnMPlus.setPreferredSize(new Dimension(62, 30));
        JButton btnMMinus = new JButton("M-");
        btnMMinus.setPreferredSize(new Dimension(62, 30));
        JButton btnMS = new JButton("MS");
        btnMS.setPreferredSize(new Dimension(62, 30));
        memoryPanel.add(btnMC);
        memoryPanel.add(btnMR);
        memoryPanel.add(btnMPlus);
        memoryPanel.add(btnMMinus);
        memoryPanel.add(btnMS);
        mainPanel.add(memoryPanel, BorderLayout.CENTER);
    }

    public void create_and_add_btnCalculatorPanel_to_mainPanel() {
        btnCalculatorPanel = new JPanel();
        btnCalculatorPanel.setLayout(new GridLayout(6, 4, 5, 5));
        JButton btnPercent = new JButton("%");
        btnPercent.setPreferredSize(new Dimension(10, 60));
        JButton btnSquareRoot = new JButton("√");
        JButton btnSquare = new JButton("x²");
        JButton btnOneDivideX = new JButton("1/x");
        JButton btnCE = new JButton("CE");
        JButton btnC = new JButton("C");
        JButton btnDelete = new JButton("←");
        JButton btnDivide = new JButton("/");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnMulti = new JButton("*");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btnSub = new JButton("-");
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btnPlus = new JButton("+");
        JButton btnnegative = new JButton("-x");
        JButton btn0 = new JButton("0");
        JButton btnDot = new JButton(".");
        JButton btnEqual = new JButton("=");

        btnCalculatorPanel.add(btnPercent);
        btnCalculatorPanel.add(btnSquareRoot);
        btnCalculatorPanel.add(btnSquare);
        btnCalculatorPanel.add(btnOneDivideX);
        btnCalculatorPanel.add(btnCE);
        btnCalculatorPanel.add(btnC);
        btnCalculatorPanel.add(btnDelete);
        btnCalculatorPanel.add(btnDivide);
        btnCalculatorPanel.add(btn7);
        btnCalculatorPanel.add(btn8);
        btnCalculatorPanel.add(btn9);
        btnCalculatorPanel.add(btnMulti);
        btnCalculatorPanel.add(btn4);
        btnCalculatorPanel.add(btn5);
        btnCalculatorPanel.add(btn6);
        btnCalculatorPanel.add(btnSub);
        btnCalculatorPanel.add(btn1);
        btnCalculatorPanel.add(btn2);
        btnCalculatorPanel.add(btn3);
        btnCalculatorPanel.add(btnPlus);
        btnCalculatorPanel.add(btnnegative);
        btnCalculatorPanel.add(btn0);
        btnCalculatorPanel.add(btnDot);
        btnCalculatorPanel.add(btnEqual);
        
        mainPanel.add(btnCalculatorPanel, BorderLayout.SOUTH);
    }

    public void add_mainPanel_to_JFrame() {
        add(mainPanel);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class session03_baitap01 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Calculator myCalculator = new Calculator();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        myCalculator.create_JFrame("Calculator");
        myCalculator.create_mainPanel();
        myCalculator.add_mainPanel_to_JFrame();
        myCalculator.create_and_add_ketQuaPanel_to_mainPanel();
        myCalculator.create_and_add_memoryPanel_to_mainPanel();
        myCalculator.create_and_add_btnCalculatorPanel_to_mainPanel();
        myCalculator.add_mainPanel_to_JFrame();
        myCalculator.display_JFrame();
    }
}
