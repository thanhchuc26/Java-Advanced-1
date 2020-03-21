/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author June
 */
public class create_JFrame_with_SpringLayout extends JFrame {

    JPanel myJPanel;
    SpringLayout layout;

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
        layout = new SpringLayout();
        myJPanel.setLayout(layout);
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void add_Components_to_JPanel() {
        JButton btn1 = new JButton("Button1");
        JButton btn2 = new JButton("Button2");
        JButton btn3 = new JButton("Button3");
        JButton btn4 = new JButton("Button4");
        JButton btn5 = new JButton("Button5");
        myJPanel.add(btn1);
        myJPanel.add(btn2);
        myJPanel.add(btn3);
        myJPanel.add(btn4);
        myJPanel.add(btn5);
        // Set the distances between the edges . Put the first button at pixel
        // co-ordinates (10,10) relative to the panel’s frame
        layout.putConstraint(SpringLayout.WEST, btn1, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, btn1, 10, SpringLayout.NORTH, this);
        // Put the second button 5 pixels to the right of the first button and 20
        // pixels below the top panel edge.
        layout.putConstraint(SpringLayout.WEST, btn2, 5, SpringLayout.EAST, btn1);
        layout.putConstraint(SpringLayout.NORTH, btn2, 20, SpringLayout.NORTH, this);
        // Put the third button 50 pixels to the left of the
        // panel edge and 20 pixels above the second button.
        layout.putConstraint(SpringLayout.WEST, btn3, 50, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, btn3, 20, SpringLayout.SOUTH, btn2);
        // Put the fourth button 50 pixels to the right of the
        // third button and 20 pixels below the top panel edge.
        layout.putConstraint(SpringLayout.WEST, btn4, 50, SpringLayout.EAST, btn3);
        layout.putConstraint(SpringLayout.NORTH, btn4, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, btn5, 50, SpringLayout.EAST, btn4);
        layout.putConstraint(SpringLayout.NORTH, btn5, 10, SpringLayout.SOUTH, btn4);
    }

    public static void main(String[] args) {
        create_JFrame_with_SpringLayout mySpringLayout = new create_JFrame_with_SpringLayout();
        mySpringLayout.create_JFrame("JFrame with SpringLayout");
        mySpringLayout.create_JPanel();
        mySpringLayout.set_Layout_JPanel();
        mySpringLayout.add_Components_to_JPanel();
        mySpringLayout.add_JPanel_to_JFrame();
        mySpringLayout.display_JFrame();
    }
}

/*
Lớp SpringLayout đặt vị trí các con của Container liên kết với nó tuân theo một tập hợp các ràng buộc.

Lớp này có SpringLayout() constructor để tạo một SpringLayout mới.

Lớp SpringLayout bao gồm các trường sau:
static String BASELINE: Xác định baseline của một thành phần.
static String EAST: Xác định cạnh phải của hình chữ nhật bao của một thành phần.
static String HEIGHT: Xác định chiều cao của hình chữ nhật bao của một thành phần.
static String HORIZONTAL_CENTER: Xác định sự căn chỉnh ngang của hình chữ nhật bao của một thành phần.
static String NORTH: Xác định cạnh trên của hình chữ nhật bao của một thành phần.
static String SOUTH: Xác định cạnh dưới của hình chữ nhật bao của một thành phần.
static String VERTICAL_CENTER: Xác định sự căn chỉnh dọc của hình chữ nhật bao của một thành phần.
static String WEST: Xác định cạnh trái của hình chữ nhật bao của một thành phần.
static String WIDTH: Xác định độ rộng của hình chữ nhật bao của một thành phần.
*/