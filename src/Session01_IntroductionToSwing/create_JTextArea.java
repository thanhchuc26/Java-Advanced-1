/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author June
 */
public class create_JTextArea extends JFrame {

    /*
    JTextArea là một thành phần cho phép hiển thị nhiều dòng văn bản đồng thời người dùng có thể chỉnh sửa văn bản.
     */
    private JTextArea ta;

    public create_JTextArea() {

        add(createMainPanel());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Demo JTextArea");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // JScrollPane create a scroll when row of text larger than row of
        // JTextArea
        JScrollPane scroll = new JScrollPane(ta = createTextArea(10, 40));
        panel.add(scroll, BorderLayout.CENTER);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        JButton btnChangeFontandColor = new JButton("Change Font and Color");
        btnChangeFontandColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        });
        
        JPanel panelBottom = new JPanel();
        panelBottom.add(btnClear);
        panelBottom.add(btnChangeFontandColor);

        panel.add(panelBottom, BorderLayout.PAGE_END);

        return panel;
    }

    /**
     * create a JTextArea with rows and columns, two method setWrapStyleWord and
     * setLineWrap make text can down line when text too long
     */
    private JTextArea createTextArea(int row, int col) {
        JTextArea ta = new JTextArea(row, col);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        return ta;
    }

    /**
     * clear text of JTextArea
     */
    private void clear() {
        ta.setText("");
    }

    /**
     * change font and color text of JTextArea
     */
    private void changeColor() {
        Font font = new Font("Verdana", Font.BOLD, 20);
        ta.setFont(font);
        ta.setForeground(Color.BLUE);
    }

    public static void main(String[] args) {
        create_JTextArea myJTextArea = new create_JTextArea();
    }
}
