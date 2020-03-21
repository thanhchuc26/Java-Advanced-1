/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class create_GUI_StepByStep {
    static JFrame myJFrame;
    static JPanel myJPanel;
    static String jFrameTitle="My JFrame";
    static JLabel myJLabel;
    static void create_JFrame(){
        myJFrame=new JFrame();
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setTitle(jFrameTitle);
        myJFrame.setSize(500,200);
    }
    static void displayJFrame(){
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setVisible(true);
    }
    static void create_JPanel(){
        myJPanel=new JPanel();
    }
    static void create_JLabel(){
        myJLabel=new JLabel("Label 1");
    }
    static void addJLabel_to_JPanel(){
        myJPanel.add(myJLabel);
    }
    static void addJPanel_to_JFrame(){
        myJFrame.add(myJPanel);
    }
    public static void main(String[] args) {
        //Step 1: create JFrame
        create_JFrame();
        //Step 2: create JPanel
        create_JPanel();
        //Step 3: create an component (for example: an JLabel)
        create_JLabel();
        //Step 4: add component (for example: an JLabel) to JPanel
        addJLabel_to_JPanel();
        //Step 5: // add JPanel into JFrame
        addJPanel_to_JFrame();
        //Step 6: display JFrame
        displayJFrame();
    }
}
