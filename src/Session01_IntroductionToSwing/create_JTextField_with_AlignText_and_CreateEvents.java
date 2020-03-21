/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class create_JTextField_with_AlignText_and_CreateEvents extends JFrame implements KeyListener {

    /*
    Căn lề và tạo sự kiện cho JTextField
Trong ví dụ này chúng ta sẽ tạo 1 JTextFiel mà khi nhập vào thì text của chúng ta được căn lề phải 
    (mặc định là lề trái), khi ấn phím enter thì sẽ hiển thị dữ liệu vừa nhập lên 1 JLabel.
    
    Cũng giống như JButton, JTextField cũng bắt được sự kiện của chuột và thậm chí là cả của các phím trên bàn phím nữa. 
    Để bắt sự kiện của các phím ta sử dụng phương thức addKeyListener() 
    và làm tương tự như các cách bắt sự kiện của JButton nhưng với KeyListener chứ không phải với ActionListener.
    
Sử dụng phương thức setHorizontalAlignment để căn lề cho JTextField.

Một số phương thức khác
getSelectedText(): lấy đoạn text được chọn trong JTextField
setSelectionStart(int selectionStart) và setSelectionEnd(int selectionEnd) đặt vị trí bắt đầu và kết thúc để chọn text. 
    Nếu không có phương thức setSelectionStart thì text sẽ được chọn từ vị trí hiện thời của con trỏ 
    (nhỏ hơn selectionEnd) đến selectionEnd. 
    Nếu không có phương thức setSelectionEnd thì text sẽ được chọn từ vị trí selectionStart đến vị trí hiện thời 
    của con trỏ (lớn hơn selectionStart).
getCaretPosition() và setCaretPosition(position) lấy và đặt vị trí hiện thời của con trỏ.
     */
    private JTextField tf;
    private JLabel lb;

    public create_JTextField_with_AlignText_and_CreateEvents() {
        createJFrame();
        addContent();
        displayJFrame();
    }

    // create JFrame
    private void createJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1, 5, 5));
    }

    // display JFrame
    private void displayJFrame() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addContent() {
        tf = new JTextField(20);
        tf.setHorizontalAlignment(JTextField.RIGHT);// can trai
        tf.addKeyListener(this);
        add(tf);

        lb = new JLabel("Not data");
        add(lb);
    }

    private void updateData() {
        lb.setText(tf.getText());
    }

    @Override
    public void keyPressed(KeyEvent e) {// nhan vao phim
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            updateData();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { // nha phim ra
    }

    @Override
    public void keyTyped(KeyEvent e) { // nhap 1 phim
    }

    public static void main(String[] args) {
        create_JTextField_with_AlignText_and_CreateEvents myJTextField = new create_JTextField_with_AlignText_and_CreateEvents();
    }
}
