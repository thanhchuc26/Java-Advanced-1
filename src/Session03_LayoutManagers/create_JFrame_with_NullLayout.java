/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class create_JFrame_with_NullLayout extends JFrame {

    JPanel myJPanel;
    JButton myJButton;
    JTextField myJTextField;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(400, 300);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JPanel() {
        myJPanel = new JPanel();
    }

    public void set_Layout_JPanel() {
        myJPanel.setLayout(null);
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void add_components_to_JPanel() {
        myJButton = new JButton("Click");
        myJButton.setBounds(50, 50, 75, 25);
        myJPanel.add(myJButton);
        myJTextField = new JTextField();
        myJTextField.setBounds(130, 50, 200, 25);
        myJPanel.add(myJTextField);
    }

    public static void main(String[] args) {
        create_JFrame_with_NullLayout myNullLayout = new create_JFrame_with_NullLayout();
        myNullLayout.create_JFrame("JFrame with NullLayout");
        myNullLayout.create_JPanel();
        myNullLayout.set_Layout_JPanel();
        myNullLayout.add_components_to_JPanel();
        myNullLayout.add_JPanel_to_JFrame();
        myNullLayout.display_JFrame();
    }
}

/*
Một khung chứa được trình bày theo kiểu Null Layout có nghĩa là người lập trình phải tự làm tất cả
từ việc qui định kích thước của khung chứa, cũng như kích thước và vị trí của từng đối tượng component
trong khung chứa.

Để thiết lập cách trình bày là Null Layout cho một container ta chỉ việc gọi phương thức setLayout(null)
với tham số là null.

Một số phương thức của lớp trừu tượng Component dùng để định vị và qui định kích thước của component
khi đưa chúng vào khung chứa trình bày theo kiểu tự do:
o  Public void setLocation(Point p)
o  Public void setSize(Dimension p)
o  Public void setBounds(Rectangle r)
Ví dụ:
o  MyButton.setSi ze(new Dimension(20, 10));
o  MyButton.setLocati on(new Point(10, 10));
o  MyButton.setBounds(10, 10, 20, 10);
*/