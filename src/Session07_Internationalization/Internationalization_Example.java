/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session07_Internationalization;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class Internationalization_Example extends JFrame {

    JPanel mainPanel;
    JLabel lblUsername, lblPassword, lblLanguage;
    JComboBox cmbLanguage;
    JButton btnLogin, btnExit;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Internationalization Example");
        setSize(250, 140);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel();
    }

    void create_and_add_components_to_mainPanel() {
        lblUsername = new JLabel("User name");
        mainPanel.add(lblUsername);
        mainPanel.add(new JTextField(20));
        lblPassword = new JLabel("Password ");
        mainPanel.add(lblPassword);
        mainPanel.add(new JTextField(20));
        lblLanguage = new JLabel("Language");
        mainPanel.add(lblLanguage);
        String[] language = {"English", "VietNam"};
        cmbLanguage = new JComboBox(language);
        mainPanel.add(cmbLanguage);
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(96, 20));
//        subPanel1.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.add(subPanel1);
        btnLogin = new JButton("Login");
        mainPanel.add(btnLogin);
        JPanel subPanel2 = new JPanel();
        subPanel2.setPreferredSize(new Dimension(26, 20));
//        subPanel2.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.add(subPanel2);
        btnExit = new JButton("Exit");
        mainPanel.add(btnExit);

        cmbLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (cmbLanguage.getSelectedItem().toString()) {
                    case "English":
                        changeLanguage("en", "US");
                        break;
                    case "VietNam":
                        changeLanguage("vi", "VN");
                        break;
                }
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

    void addMainPanel_to_JFrame() {
        add(this.mainPanel);
    }

    void displayJFrame() {
        setVisible(true);
    }

    private void changeLanguage(String language, String country) {
        Locale currentLocale;
        ResourceBundle myResourceBundle;
        String resource = "session07.MessagesBundle_" + language + "_" + country;
        currentLocale = new Locale(language, country);
        myResourceBundle = ResourceBundle.getBundle(resource, currentLocale);
        setTitle(myResourceBundle.getString("title"));
        lblUsername.setText(myResourceBundle.getString("username"));
        lblPassword.setText(myResourceBundle.getString("password"));
        lblLanguage.setText(myResourceBundle.getString("language"));
        btnLogin.setText(myResourceBundle.getString("login"));
        btnExit.setText(myResourceBundle.getString("exit"));
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Internationalization_Example myForm = new Internationalization_Example();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        myForm.create_JFrame();
        myForm.create_mainPanel();
        myForm.create_and_add_components_to_mainPanel();
        myForm.addMainPanel_to_JFrame();
        myForm.displayJFrame();
        switch (myForm.cmbLanguage.getSelectedItem().toString()) {
            case "English":
                myForm.changeLanguage("en", "US");
                break;
            case "VietNam":
                myForm.changeLanguage("vi", "VN");
                break;
        }
    }
}
