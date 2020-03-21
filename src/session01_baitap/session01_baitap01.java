/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01_baitap;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author June
 */
public class session01_baitap01 extends JFrame{
    JPanel myJPanel;
    JLabel lblUser;
    JLabel lblPassword;
    JLabel lblStatusUserName;
    JLabel lblStatusPassword;
    JLabel lblStatusLogin;
    JTextField txtUserName;
    JPasswordField txtPassword;
    JButton btnLogin;
    JButton btnExit;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setSize(330, 170);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_JPanel() {
        myJPanel = new JPanel();
    }

    void addJPanel_to_JFrame() {
        add(this.myJPanel);
    }

    void create_JLabelUser() {
        lblUser = new JLabel("User name: ");
    }

    void addJLabelUser_to_JPanel() {
        myJPanel.add(lblUser);
    }

    void create_JTextFieldUser() {
        txtUserName = new JTextField(20);
    }

    void addJTextFieldUser_to_JPanel() {
        myJPanel.add(txtUserName);
    }

    void create_JButtonLogin() {
        btnLogin = new JButton("Login");
        btnLogin.setPreferredSize(new Dimension(70, 20));
    }

    void addJButtonLogin_to_JPanel() {
        myJPanel.add(btnLogin);
    }

    void create_JLabelPassword() {
        lblPassword = new JLabel("Password:   ");
    }

    void addJLabelPassword_to_JPanel() {
        myJPanel.add(lblPassword);
    }

    void create_JTextFieldPassword() {
        txtPassword = new JPasswordField(20);
    }

    void addJTextFieldPassword_to_JPanel() {
        myJPanel.add(txtPassword);
    }

    void create_JButtonExit() {
        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension(70, 20));
    }

    void addJButtonExit_to_JPanel() {
        myJPanel.add(btnExit);
    }

    void create_JLabelStatusUserName() {
        lblStatusUserName = new JLabel("Status textbox user name: ");
        lblStatusUserName.setPreferredSize(new Dimension(300, 20));
    }

    void addJLabelStatusUserName_to_JPanel() {
        myJPanel.add(lblStatusUserName);
    }

    void create_JLabelStatusPassword() {
        lblStatusPassword = new JLabel("Status textbox password: ");
        lblStatusPassword.setPreferredSize(new Dimension(300, 20));
    }

    void addJLabelStatusPassword_to_JPanel() {
        myJPanel.add(lblStatusPassword);
    }

    void create_JLabelStatusLogin() {
        lblStatusLogin = new JLabel("Status login: ");
        lblStatusLogin.setPreferredSize(new Dimension(300, 20));
    }

    void addJLabelStatusLogin_to_JPanel() {
        myJPanel.add(lblStatusLogin);
    }

    void displayJFrame() {
        setVisible(true);
    }

    void add_Focus_JTextFieldUser() {
        txtUserName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                lblStatusUserName.setText("Status textbox user name: got focus");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                lblStatusUserName.setText("Status textbox user name: lost focus");
            }
        });
    }

    void add_Focus_JTextFieldPassword() {
        txtPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                lblStatusPassword.setText("Status textbox password: got focus");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                lblStatusPassword.setText("Status textbox password: lost focus");
            }
        });
    }

    void add_event_for_JButtonLogin() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txtUserName.getText().equalsIgnoreCase("")) {
                    lblStatusLogin.setText("Status login: User name empty");
                    txtUserName.requestFocus();
                }
                if (txtPassword.getText().equalsIgnoreCase("")) {
                    lblStatusLogin.setText("Status login: Password empty");
                    txtPassword.requestFocus();
                }
                if ((txtUserName.getText().equalsIgnoreCase("")) && (txtPassword.getText().equalsIgnoreCase(""))) {
                    lblStatusLogin.setText("Status login: User name and password empty");
                    txtUserName.requestFocus();
                }
                if (!(txtUserName.getText().equalsIgnoreCase("")) && !(txtPassword.getText().equalsIgnoreCase(""))) {
                    lblStatusLogin.setText("Status login: login successful");
                }
            }
        });
    }

    void add_event_for_JButtonExit() {
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        session01_baitap01 myForm = new session01_baitap01();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception : " + ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        myForm.create_JFrame();
        myForm.create_JPanel();
        myForm.create_JLabelUser();
        myForm.addJLabelUser_to_JPanel();
        myForm.create_JTextFieldUser();
        myForm.addJTextFieldUser_to_JPanel();
        myForm.create_JButtonLogin();
        myForm.addJButtonLogin_to_JPanel();
        myForm.create_JLabelPassword();
        myForm.addJLabelPassword_to_JPanel();
        myForm.create_JTextFieldPassword();
        myForm.addJTextFieldPassword_to_JPanel();
        myForm.create_JButtonExit();
        myForm.addJButtonExit_to_JPanel();
        myForm.create_JLabelStatusUserName();
        myForm.addJLabelStatusUserName_to_JPanel();
        myForm.create_JLabelStatusPassword();
        myForm.addJLabelStatusPassword_to_JPanel();
        myForm.create_JLabelStatusLogin();
        myForm.addJLabelStatusLogin_to_JPanel();
        myForm.addJPanel_to_JFrame();
        myForm.displayJFrame();
        myForm.add_Focus_JTextFieldUser();
        myForm.add_Focus_JTextFieldPassword();
        myForm.add_event_for_JButtonExit();
        myForm.add_event_for_JButtonLogin();
    }
}
