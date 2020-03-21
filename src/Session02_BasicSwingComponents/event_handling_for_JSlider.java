/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author June
 */
public class event_handling_for_JSlider extends JFrame implements ChangeListener{
    private JPanel myJPanel;
    private JSlider myJSlider;
    private JLabel myJLabel;
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
        myJPanel = new JPanel(new GridLayout(2,1,5,5));
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void create_JSlider() {
        myJSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
        myJSlider.setMinorTickSpacing(5);
        myJSlider.setMajorTickSpacing(10);
        myJSlider.setPaintTicks(true);
        myJSlider.setPaintLabels(true);
    }

    public void add_JSlider_to_JPanel() {
        myJPanel.add(myJSlider);
    }
    public void add_event_for_JSlider(){
        myJSlider.addChangeListener(this);
    }
    public void create_JLabel(){
        myJLabel=new JLabel("Value of JSlider: "+myJSlider.getValue());
    }
    public void add_JLabel_to_JPanel(){
        myJPanel.add(myJLabel);
    }
    public static void main(String[] args) {
        event_handling_for_JSlider myevent_handling_for_JSlider=new event_handling_for_JSlider();
        myevent_handling_for_JSlider.create_JFrame("Example JSlider");
        myevent_handling_for_JSlider.create_JPanel();
        myevent_handling_for_JSlider.create_JSlider();
        myevent_handling_for_JSlider.add_JSlider_to_JPanel();
        myevent_handling_for_JSlider.create_JLabel();
        myevent_handling_for_JSlider.add_JLabel_to_JPanel();
        myevent_handling_for_JSlider.add_JPanel_to_JFrame();
        myevent_handling_for_JSlider.display_JFrame();
        myevent_handling_for_JSlider.add_event_for_JSlider();
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        myJLabel.setText("Value of JSlider: "+myJSlider.getValue());
    }
}
