/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;


import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class create_JFormattedTextField_with_date_formatter extends JFrame{
    private JPanel myJPanel;
    DateFormat myDateFormat;
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
    public void create_DateFormat() {
        myDateFormat=DateFormat.getDateInstance();
    }
    public void create_JFormattedTextField(){
        myJFormattedTextField=new JFormattedTextField(myDateFormat);
        myDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String dateString1 = "31/01/2017";
        try {
            Date date1 = myDateFormat.parse(dateString1);
            myJFormattedTextField.setValue(date1);
        } catch (ParseException ex) {
//            Logger.getLogger(create_JFormattedTextField_with_date_formatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void add_JFormattedTextField_to_JPanel(){
        myJPanel.add(myJFormattedTextField);

    }
    public static void main(String[] args) {
        create_JFormattedTextField_with_date_formatter mycreate_JFormattedTextField_with_date_formatter = new create_JFormattedTextField_with_date_formatter();
        mycreate_JFormattedTextField_with_date_formatter.create_JFrame("Example JFormattedTextField with a numeric formatter");
        mycreate_JFormattedTextField_with_date_formatter.create_JPanel();
        mycreate_JFormattedTextField_with_date_formatter.create_DateFormat();
        mycreate_JFormattedTextField_with_date_formatter.create_JFormattedTextField();
        mycreate_JFormattedTextField_with_date_formatter.add_JFormattedTextField_to_JPanel();
        mycreate_JFormattedTextField_with_date_formatter.add_JPanel_to_JFrame();
        mycreate_JFormattedTextField_with_date_formatter.display_JFrame();
    }
}
