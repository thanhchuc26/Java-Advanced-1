/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session05_ListsAndPanes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class ComboBox extends JFrame{
    JPanel myJPanel;
    JComboBox myJComboBox;
    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 200);
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
    public void create_JComboBox(){
        String[] batchName={"Batch 129","Batch 130","Batch 131"};
        myJComboBox=new JComboBox(batchName);
    }
    public void add_JComboBox_to_JPanel(){
        myJPanel.add(myJComboBox);
    }
    public static void main(String[] args) {
        ComboBox myComboBox=new ComboBox();
        myComboBox.create_JFrame("ComboBox");
        myComboBox.create_JPanel();
        myComboBox.create_JComboBox();
        myComboBox.add_JComboBox_to_JPanel();
        myComboBox.add_JPanel_to_JFrame();
        myComboBox.display_JFrame();
    }
}
