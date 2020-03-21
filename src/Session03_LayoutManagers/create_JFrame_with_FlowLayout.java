/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class create_JFrame_with_FlowLayout extends JFrame {

    JPanel myJPanel;
    JLabel myJlabel;
    JTextField myJTextField;
    JButton myJButtonLeft, myJButtonCenter, myJButtonRight;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 100);
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
        myJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void create_JLabel() {
        myJlabel = new JLabel("Ho ten: ");
    }

    public void add_JLabel_to_JPanel() {
        myJPanel.add(myJlabel);
    }

    public void create_JTextField() {
        myJTextField = new JTextField(10);
        myJTextField.setText("Batch 129");
    }

    public void add_JTextField_to_JPanel() {
        myJPanel.add(myJTextField);
    }

    public void create_JButtonLeft() {
        myJButtonLeft = new JButton("Left");
        myJButtonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                myJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                myJPanel.validate();
                myJPanel.repaint();
            }
        });
    }

    public void create_JButtonCenter() {
        myJButtonCenter = new JButton("Center");
        myJButtonCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                myJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                myJPanel.validate();
                myJPanel.repaint();
            }
        });
    }

    public void create_JButtonRight() {
        myJButtonRight = new JButton("Right");
        myJButtonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                myJPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
                myJPanel.validate();
                myJPanel.repaint();
            }
        });
    }

    public void add_JButton_to_JPanel() {
        myJPanel.add(myJButtonLeft);
        myJPanel.add(myJButtonCenter);
        myJPanel.add(myJButtonRight);
    }

    public static void main(String[] args) {
        create_JFrame_with_FlowLayout myFlowLayout = new create_JFrame_with_FlowLayout();
        myFlowLayout.create_JFrame("JFrame with FlowLayout");
        myFlowLayout.create_JPanel();
        myFlowLayout.set_Layout_JPanel();
        myFlowLayout.create_JLabel();
        myFlowLayout.add_JLabel_to_JPanel();
        myFlowLayout.create_JTextField();
        myFlowLayout.add_JTextField_to_JPanel();
        myFlowLayout.create_JButtonLeft();
        myFlowLayout.create_JButtonCenter();
        myFlowLayout.create_JButtonRight();
        myFlowLayout.add_JButton_to_JPanel();
        myFlowLayout.add_JPanel_to_JFrame();
        myFlowLayout.display_JFrame();
    }
}

/*
Lớp FlowLayout được sử dụng để sắp xếp các thành phần trong một line, 
line sau nối tiếp line trước (trong một luồng từ trái qua phải left-to-right flow). 
Nó là Layout mặc định của applet hoặc panel.

Lớp FlowLayout này bao gồm các trường sau:
static int CENTER: Giá trị này chỉ rằng mỗi hàng của các thành phần nên được căn chỉnh vào giữa.
static int LEADING: Giá trị này chỉ rằng mỗi hàng của các thành phần nên được căn chỉnh theo cạnh chủ đạo 
(leading edge) theo hướng của container, ví dụ: căn chỉnh theo cạnh trái theo hướng left-to-right.
static int LEFT: Giá trị này chỉ rằng mỗi hàng của các thành phần nên được căn chỉnh trái.
static int RIGHT: Giá trị này chỉ rằng mỗi hàng của các thành phần nên được căn chỉnh phải.
static int TRAILING: Giá trị này chỉ rằng mỗi hàng của các thành phần nên được căn chỉnh theo cạnh 
trailing edge theo hướng của container, ví dụ: căn chỉnh theo cạnh phải theo hướng left-to-right.

Các constructor được sử dụng phổ biến của lớp FlowLayout
FlowLayout(): tạo một Flow Layout với căn chỉnh trung tâm 
và một khoảng cách gap theo chiều dọc và ngang là 5 đơn vị.
FlowLayout(int align): tạo một Flow Layout với căn chỉnh align đã cho 
và một khoảng cách gap theo chiều dọc và ngang là 5 đơn vị.
FlowLayout(int align, int hgap, int vgap): tạo một Flow Layout với căn chỉnh align đã cho 
và một khoảng cách gap theo chiều dọc và ngang đã được xác định.
*/