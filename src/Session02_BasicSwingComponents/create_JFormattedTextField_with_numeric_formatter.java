/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;


import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class create_JFormattedTextField_with_numeric_formatter extends JFrame{
    private JPanel myJPanel;
    NumberFormat myNumberFormat;
    private JFormattedTextField myJFormattedTextField;
    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 100);
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
    public void create_NumberFormat() {
        myNumberFormat=NumberFormat.getNumberInstance();
    }
    public void create_JFormattedTextField(){
        myJFormattedTextField=new JFormattedTextField(myNumberFormat);
        myJFormattedTextField.setValue(123456789);
    }
    public void add_JFormattedTextField_to_JPanel(){
        myJPanel.add(myJFormattedTextField);

    }
    public static void main(String[] args) {
        create_JFormattedTextField_with_numeric_formatter mycreate_JFormattedTextField_with_numeric_formatter = new create_JFormattedTextField_with_numeric_formatter();
        mycreate_JFormattedTextField_with_numeric_formatter.create_JFrame("Example JFormattedTextField with a numeric formatter");
        mycreate_JFormattedTextField_with_numeric_formatter.create_JPanel();
        mycreate_JFormattedTextField_with_numeric_formatter.create_NumberFormat();
        mycreate_JFormattedTextField_with_numeric_formatter.create_JFormattedTextField();
        mycreate_JFormattedTextField_with_numeric_formatter.add_JFormattedTextField_to_JPanel();
        mycreate_JFormattedTextField_with_numeric_formatter.add_JPanel_to_JFrame();
        mycreate_JFormattedTextField_with_numeric_formatter.display_JFrame();
    }
}
