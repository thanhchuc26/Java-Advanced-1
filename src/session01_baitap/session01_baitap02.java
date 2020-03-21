/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01_baitap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author June
 */
public class session01_baitap02 extends JFrame {

    JPanel mainPanel, subPanel1, subPanel2, subPanel3, subPanel4, subPanel5, subPanel6;
    JLabel lblTitle, lblStudentID, lblUserName, lblPassword, lblconfirmPassword, lblEmail, lblPhone, lblCourse, lblgender, lblOtherComments;
    JTextField txtStudentID, txtUserName, txtEmail, txtPhone;
    JPasswordField txtPassword, txtconfirmPassword;
    JCheckBox chkJava, chkJDBC, chkEJB, chkJSP;
    JRadioButton radioMale, radioFemale;
    JTextArea txtAreaOtherComments;
    JButton btnRegistry, btnExit;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration");
        setSize(510, 480);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel();
    }

    void addMainPanel_to_JFrame() {
        add(this.mainPanel);
    }

    void create_and_add_SubPanel1_to_mainPanel() {
        subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(50, 20));
//        subPanel1.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.add(this.subPanel1);
    }

    void create_and_add_lblTiltle_to_mainPanel() {
        lblTitle = new JLabel("REGISTRATION FORM");
        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblTitle.setForeground(Color.red);
        mainPanel.add(lblTitle);
    }

    void create_and_add_SubPanel2_to_mainPanel() {
        subPanel2 = new JPanel();
        subPanel2.setPreferredSize(new Dimension(50, 20));
//        subPanel2.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.add(this.subPanel2);
    }

    void create_and_add_SubPanel3_to_mainPanel() {
        subPanel3 = new JPanel();
        subPanel3.setPreferredSize(new Dimension(450, 20));
//        subPanel3.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.add(this.subPanel3);
    }

    void create_and_add_lblStudentID_to_mainPanel() {
        lblStudentID = new JLabel("Student ID");
//        lblStudentID.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblStudentID.setForeground(Color.blue);
        mainPanel.add(lblStudentID);
    }

    void create_and_add_txtStudentID_to_mainPanel() {
        txtStudentID = new JTextField(20);
        mainPanel.add(txtStudentID);
    }

    void create_and_add_lblUserName_to_mainPanel() {
        lblUserName = new JLabel("           User name");
//        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblUserName.setForeground(Color.blue);
        mainPanel.add(lblUserName);
    }

    void create_and_add_txtUserName_to_mainPanel() {
        txtUserName = new JTextField(20);
        mainPanel.add(txtUserName);
    }

    void create_and_add_lblPassword_to_mainPanel() {
        lblPassword = new JLabel("Password ");
//        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblPassword.setForeground(Color.blue);
        mainPanel.add(lblPassword);
    }

    void create_and_add_txtPassword_to_mainPanel() {
        txtPassword = new JPasswordField(20);
        mainPanel.add(txtPassword);
    }

    void create_and_add_lblconfirmPassword_to_mainPanel() {
        lblconfirmPassword = new JLabel("Confirm password");
//        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblconfirmPassword.setForeground(Color.blue);
        mainPanel.add(lblconfirmPassword);
    }

    void create_and_add_txtconfirmPassword_to_mainPanel() {
        txtconfirmPassword = new JPasswordField(20);
        mainPanel.add(txtconfirmPassword);
    }

    void create_and_add_lblEmail_to_mainPanel() {
        lblEmail = new JLabel("Email        ");
//        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblEmail.setForeground(Color.blue);
        mainPanel.add(lblEmail);
    }

    void create_and_add_txtEmail_to_mainPanel() {
        txtEmail = new JTextField(20);
        mainPanel.add(txtEmail);
    }

    void create_and_add_lblPhone_to_mainPanel() {
        lblPhone = new JLabel("                   Phone");
//        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblPhone.setForeground(Color.blue);
        mainPanel.add(lblPhone);
    }

    void create_and_add_txtPhone_to_mainPanel() {
        txtPhone = new JTextField(20);
        mainPanel.add(txtPhone);
    }

    void create_and_add_lblCourse_mainPanel() {
        lblCourse = new JLabel("Course    ");
//        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblCourse.setForeground(Color.blue);
        mainPanel.add(lblCourse);
    }

    void create_and_add_chkCourse_to_mainPanel() {
        chkJava = new JCheckBox("Java");
        chkJDBC = new JCheckBox("JDBC");
        chkEJB = new JCheckBox("EJB");
        chkJSP = new JCheckBox("JSP");
        mainPanel.add(chkJava);
        mainPanel.add(chkJDBC);
        mainPanel.add(chkEJB);
        mainPanel.add(chkJSP);
    }

    void create_and_add_SubPanel4_to_mainPanel() {
        subPanel4 = new JPanel();
        subPanel4.setPreferredSize(new Dimension(230, 20));
//        subPanel4.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.add(this.subPanel4);
    }

    void create_and_add_lblGender_to_mainPanel() {
        lblgender = new JLabel("Gender    ");
//        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblgender.setForeground(Color.blue);
        mainPanel.add(lblgender);
    }

    void addlblGender_to_mainPanel() {
//        mainPanel.add(lblgender);
    }

    void create_and_add_radioGender_to_mainPanel() {
        radioMale = new JRadioButton("Male");
        radioFemale = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);
        mainPanel.add(radioMale);
        mainPanel.add(radioFemale);
    }

    void create_and_add_SubPanel5_to_mainPanel() {
        subPanel4 = new JPanel();
        subPanel4.setPreferredSize(new Dimension(320, 20));
//        subPanel4.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.add(this.subPanel4);
    }

    void create_and_add_lblOtherComments_to_mainPanel() {
        lblOtherComments = new JLabel("Other comments:");
//        lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 20));
        lblOtherComments.setForeground(Color.blue);
        mainPanel.add(lblOtherComments);
    }

    void create_and_add_SubPanel6_to_mainPanel() {
        subPanel4 = new JPanel();
        subPanel4.setPreferredSize(new Dimension(400, 20));
//        subPanel4.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.add(this.subPanel4);
    }

    void create_and_add_txtAreaOtherComments_to_mainPanel() {
        txtAreaOtherComments = new JTextArea(10, 60);
        txtAreaOtherComments.setWrapStyleWord(true);
        txtAreaOtherComments.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(txtAreaOtherComments);
        mainPanel.add(scroll);
    }

    void create_and_add_btnRegistry_to_mainPanel() {
        btnRegistry = new JButton("Registry");
        btnRegistry.setPreferredSize(new Dimension(90, 30));
        mainPanel.add(btnRegistry);
    }

    void create_and_add_btnExit_to_mainPanel() {
        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension(90, 30));
        mainPanel.add(btnExit);
    }

    void displayJFrame() {
        setVisible(true);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        session01_baitap02 myForm = new session01_baitap02();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception : " + ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        myForm.create_JFrame();
        myForm.create_mainPanel();
        myForm.create_and_add_SubPanel1_to_mainPanel();
        myForm.create_and_add_lblTiltle_to_mainPanel();
        myForm.create_and_add_SubPanel2_to_mainPanel();
        myForm.create_and_add_SubPanel3_to_mainPanel();
        myForm.create_and_add_lblStudentID_to_mainPanel();
        myForm.create_and_add_txtStudentID_to_mainPanel();
        myForm.create_and_add_lblUserName_to_mainPanel();
        myForm.create_and_add_txtUserName_to_mainPanel();
        myForm.create_and_add_lblPassword_to_mainPanel();
        myForm.create_and_add_txtPassword_to_mainPanel();
        myForm.create_and_add_lblconfirmPassword_to_mainPanel();
        myForm.create_and_add_txtconfirmPassword_to_mainPanel();
        myForm.create_and_add_lblEmail_to_mainPanel();
        myForm.create_and_add_txtEmail_to_mainPanel();
        myForm.create_and_add_lblPhone_to_mainPanel();
        myForm.create_and_add_txtPhone_to_mainPanel();
        myForm.create_and_add_lblCourse_mainPanel();
        myForm.create_and_add_chkCourse_to_mainPanel();
        myForm.create_and_add_SubPanel4_to_mainPanel();
        myForm.create_and_add_lblGender_to_mainPanel();
        myForm.create_and_add_radioGender_to_mainPanel();
        myForm.create_and_add_SubPanel5_to_mainPanel();
        myForm.create_and_add_lblOtherComments_to_mainPanel();
        myForm.create_and_add_SubPanel6_to_mainPanel();
        myForm.create_and_add_txtAreaOtherComments_to_mainPanel();
        myForm.create_and_add_btnRegistry_to_mainPanel();
        myForm.create_and_add_btnExit_to_mainPanel();
        myForm.addMainPanel_to_JFrame();
        myForm.displayJFrame();
    }
}
