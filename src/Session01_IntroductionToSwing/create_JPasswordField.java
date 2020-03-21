/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class create_JPasswordField  extends JFrame {
    public create_JPasswordField() {
        // create JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1, 5, 5));

        // create and add JTextField
        JPasswordField myJPasswordField = new JPasswordField(20);
        add(myJPasswordField);

        // add a JButton
        add(new JButton("OK"));

        // Display JFrame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        create_JPasswordField myJPasswordField=new create_JPasswordField();
    }
    
}

/*
JPasswordField là đối tượng cho phép chúng ta nhập vào một dòng text giống như JTextField 
nhưng được ẩn bởi các dấu sao (*) hoặc chấm tròn để tạo nên mật khẩu (password). 
JPasswordField thường được sử dụng cùng JTextField để tạo nên cặp User name và password
*/