/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session05_ListsAndPanes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author June
 */
public class TabbedPane extends JFrame{
    JPanel myJPanel;
    JTabbedPane myJTabbedPane;
    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(700, 200);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JTabbedPane(){
        myJTabbedPane=new JTabbedPane();
    }
    public void add_JTabbedPane_to_JFrame(){
        getContentPane().add(myJTabbedPane);
    }
    public void add_components_to_JTabbedPane(){
        JPanel tab1=new JPanel();
        JPanel tab2=new JPanel();
        JPanel tab3=new JPanel();
        myJTabbedPane.addTab("Tab 1", null, tab1, "click to show panel 1");
        myJTabbedPane.addTab("Tab 2", null, tab2, "click to show panel 2");
        myJTabbedPane.addTab("Tab 3", null, tab3, "click to show panel 3");
    }
    public static void main(String[] args) {
        TabbedPane myTabbedPane=new TabbedPane();
        myTabbedPane.create_JFrame("TabbedPane");
        myTabbedPane.create_JTabbedPane();
        myTabbedPane.add_components_to_JTabbedPane();
        myTabbedPane.add_JTabbedPane_to_JFrame();
        myTabbedPane.display_JFrame();
    }
}
