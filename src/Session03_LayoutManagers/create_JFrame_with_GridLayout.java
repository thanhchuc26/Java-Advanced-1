/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class create_JFrame_with_GridLayout extends JFrame {

    JPanel myJPanel;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(300, 300);
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
        myJPanel.setLayout(new GridLayout(3, 3));
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public JButton create_JButton(String title) {
        JButton myJButton = new JButton(title);
        return myJButton;
    }

    public void add_JButton_to_JPanel() {
        int i;
        for (i = 0; i < 9; i++) {
            myJPanel.add(create_JButton(String.valueOf(i + 1)));
            myJPanel.validate();
            myJPanel.repaint();
        }
    }

    public static void main(String[] args) {
        create_JFrame_with_GridLayout myFlowLayout = new create_JFrame_with_GridLayout();
        myFlowLayout.create_JFrame("JFrame with GridLayout");
        myFlowLayout.create_JPanel();
        myFlowLayout.set_Layout_JPanel();
        myFlowLayout.add_JButton_to_JPanel();
        myFlowLayout.add_JPanel_to_JFrame();
        myFlowLayout.display_JFrame();
    }
}

/*
Lớp GridLayout sắp xếp các thành phần trong một lưới hình chữ nhật. 
Một thành phần được hiển thị trong mỗi hình chữ nhật.

Lớp GridLayout gồm các constructor sau:
1. GridLayout(): Tạo một grid layout với mặc định là một cột mỗi thành phần, trong một hàng đơn.
2. GridLayout(int rows, int columns): Tạo một grid layout với số hàng và cột đã cho, 
và không có khoảng cách giữa các thành phần.
3. GridLayout(int rows, int columns, int hgap, int vgap): Tạo một grid layout với các hàng và cột đã cho 
cùng với các khoảng cách theo chiều dọc và ngang đã xác định.

Các phương thức của lớp GridLayout trong Java Swing
1.void addLayoutComponent(String name, Component comp): Thêm thành phần comp đã cho với tên đã xác định 
tới layout.
2. void layoutContainer(Container parent): Bố trí container đã cho bởi sử dụng layout này.
3. Dimension minimumLayoutSize(Container parent): Xác định kích cỡ tối thiểu của tham số container 
bởi sử dụng Grid Layout.
4. Dimension preferredLayoutSize(Container parent): Xác định kích cỡ được ưu tiên của tham số container 
bởi sử dụng Grid Layout.
5. void removeLayoutComponent(Component comp): Xóa thành phần đã cho từ layout.
6. void setColumns(int cols): Thiết lập số cột trong layout này tới giá trị đã cho.
7. void setHgap(int hgap): Thiết lập khoảng cách theo chiều ngang giữa các thành phần tới giá trị đã cho.
8. void setRows(int rows): Thiết lập số hàng trong layout này tới giá trị đã cho.
9. void setVgap(int vgap): Thiết lập khoảng cách theo chiều dọc giữa các thành phần tới giá trị đã cho.
*/