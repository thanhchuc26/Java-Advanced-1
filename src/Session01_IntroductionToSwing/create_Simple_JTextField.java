/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class create_Simple_JTextField extends JFrame {

    /*
    JTextField là một đối tượng cho phép người dùng nhập một dòng văn bản. 
    Thường dùng để nhập dữ liệu với các thông tin ngắn.
    
    Các hàm khởi tạo JTextField
– JTextField(): Tạo mới 1 JTextField
JTextField(Document doc, String text, int columns): Tạo 1 JTextField sử dụng mô hình lưu trữ văn bản với đoạn text 
    và số cột (coloumns)
JTextField(int columns): Tạo JTextField trống với độ rộng là columns
JTextField(String text): Tạo JTextField với text cho trước
JTextField(String text, int columns): Tạo JTextField với text và độ rộng cho trước.
     */
    public create_Simple_JTextField() {
        // create JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1, 5, 5));

        // create and add JTextField
        JTextField myJTextField = new JTextField(20);
        add(myJTextField);

        // add a JButton
        add(new JButton("OK"));

        // Display JFrame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        create_Simple_JTextField myJTextField1 = new create_Simple_JTextField();
    }
}
