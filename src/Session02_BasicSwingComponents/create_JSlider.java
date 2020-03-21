/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author June
 */
public class create_JSlider extends JFrame {

    private JPanel myJPanel;
    private JSlider myJSlider;

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

    public void create_JSlider() {
        myJSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
        myJSlider.setMinorTickSpacing(5);
        myJSlider.setMajorTickSpacing(10);
//        myJSlider.setSnapToTicks(true);
        myJSlider.setPaintTicks(true);
        myJSlider.setPaintLabels(true);
        myJSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                System.out.println(myJSlider.getValue());
            }
        });
    }

    public void add_JSlider_to_JPanel() {
        myJPanel.add(myJSlider);
    }
    public void setvalue_JSlider(int value){
        myJSlider.setValue(value);
    }

    public static void main(String[] args) {
        create_JSlider mycreate_JSlider = new create_JSlider();
        mycreate_JSlider.create_JFrame("Example JSlider");
        mycreate_JSlider.create_JPanel();
        mycreate_JSlider.create_JSlider();
        mycreate_JSlider.add_JSlider_to_JPanel();
        mycreate_JSlider.add_JPanel_to_JFrame();
        mycreate_JSlider.display_JFrame();
        mycreate_JSlider.setvalue_JSlider(30);
    }
}
