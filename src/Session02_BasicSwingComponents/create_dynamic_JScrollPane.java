/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author June
 */
//Tạo JScrollPane động: JSrollPane sẽ xuất hiện khi số lượng component vượt quá kích thước của JPanel

class MainPanel extends JPanel{

    private JScrollPane scrollPane;
    private JPanel scrollPanel;
    private JButton btnAddPage;

    public MainPanel(){
        setPreferredSize(new Dimension(400, 140));
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents(){
        scrollPanel = new JPanel();
        scrollPanel.setSize(new Dimension(300, 300));       
        scrollPane = new JScrollPane(scrollPanel);  //Let all scrollPanel has scroll bars

        btnAddPage = new JButton("Add New Page");
        btnAddPage.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addPanel(new Page());
                scrollPanel.revalidate();
            }
        });     

        add(scrollPane, BorderLayout.CENTER);
        add(btnAddPage, BorderLayout.SOUTH);                
    }

    public void addPanel(JPanel pnl){
        scrollPanel.add(pnl);
    }
}
class Page extends JPanel
{
    private static int idx = 1;
    private JLabel pageContent;
    public Page(){
        setPreferredSize(new Dimension(80, 80));
        setBackground(Color.YELLOW);
        pageContent = new JLabel("Page " + (idx++));
        add(pageContent);
    }
}
public class create_dynamic_JScrollPane {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame = new JFrame("Scrollable Panel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MainPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);                 
            }   
        });     
    }
}
