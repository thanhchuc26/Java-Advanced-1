/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class create_JTextField_with_get_set_and_data_processing  extends JFrame implements ActionListener{
    /*
    Lấy, đặt và xử lý dữ liệu từ JTextField
Trong ví dụ này chúng ta sẽ làm 1 demo nhỏ, có thêm 1 JButton để nhập lại dữ liệu 
    – Một demo tính tiễn lãi (Không thông báo nếu dữ liệu sai nhưng sẽ tự nhảy đến JTextField nếu nó không có dữ liệu).
    
    Những điều đáng chú ý
– Muốn lấy dữ liệu (mà ở đây thực chất là một chuỗi) từ JTextField ta dùng phương thức getText().
– Muốn đặt dữ liệu cho JtextField ta dùng phương thức setText(String text).
– Phương thức requestFocus() giúp con trỏ nhảy (tập trung) đến JTextField đó.
– Phương thức setEditable(boolean edit) để đặt có được nhập dữ liệu cho JTextField hay không.
    */
    private JTextField tfTienGui, tfLaiXuat, tfThang, tfTienLai;
 
    public create_JTextField_with_get_set_and_data_processing() {
        // ------------ create JFrame ------------ //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));
 
        // ------------ add content ------------ //
 
        int size = 15;
        add(new JLabel("Tiền gửi"));
        tfTienGui = new JTextField(size);
        add(tfTienGui);
 
        add(new JLabel("Lãi xuất / Tháng"));
        tfLaiXuat = new JTextField(size);
        add(tfLaiXuat);
 
        add(new JLabel("Tháng"));
        tfThang = new JTextField(size);
        add(tfThang);
 
        add(new JLabel("Tiền lãi"));
        tfTienLai = new JTextField(size);
        tfTienLai.setEditable(false);// khong cho phep nhap du lieu
        add(tfTienLai);
 
        add(createJButton("Tính"));
        add(createJButton("Nhập lại"));
 
        // ------------ display ------------
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    private JButton createJButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }
    private void process() {
        // check data
        String text = tfTienGui.getText();
        double tienGui = 0, tienLai = 0, thang = 0, laiXuat = 0;
 
        // tien gui
        if (text.equals("")) {
            tfTienGui.requestFocus(); // nhay den de nhap tien gui
        } else {
            tienGui = Double.parseDouble(text);
 
            // lai xuat
            text = tfLaiXuat.getText();
            if (text.equals("")) {
                tfLaiXuat.requestFocus(); // nhay den de nhap lai xuat
            } else {
                laiXuat = Double.parseDouble(text);
 
                // thang
                text = tfThang.getText();
                if (text.equals("")) {
                    tfThang.requestFocus(); // nhay den de nhap thang
                } else {
                    thang = Integer.parseInt(tfThang.getText());
                }
            }
        }
 
        // process data
        double lai = tienGui * laiXuat * thang;
        tfTienLai.setText(String.valueOf(lai)); // hien thi ket qua
    }
 
    private void clear() {
        tfTienGui.setText("");
        tfTienGui.requestFocus(); // nhay ve de nha tien gui
        tfLaiXuat.setText("");
        tfThang.setText("");
        tfTienLai.setText("");
    }
 
    // methods of ActionListener
    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        System.out.println(command);
        if (command == "Tính") {
            process();
        }
        if (command == "Nhập lại") {
            clear();
        }
    }
    public static void main(String[] args) {
        create_JTextField_with_get_set_and_data_processing myJTextField=new create_JTextField_with_get_set_and_data_processing();
    }
}
