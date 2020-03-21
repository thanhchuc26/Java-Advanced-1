/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class create_JFrame_with_BoxLayout extends JFrame{
    JPanel myJPanel;
    JButton buttonChange,myJButton1, myJButton2, myJButton3,myJButton4,myJButton5;
    BoxLayout boxLayout;
    boolean axis = true;
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
        boxLayout = new BoxLayout(myJPanel, BoxLayout.X_AXIS);
        myJPanel.setLayout(boxLayout);
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }
    public void create_JButton_and_add_JButton_to_JPanel(){
        buttonChange=new JButton("Change");
        myJPanel.add(buttonChange);
        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int ax = axis ? BoxLayout.Y_AXIS : BoxLayout.X_AXIS;
        // reset boxLayout
        boxLayout = new BoxLayout(myJPanel, ax);
        // set boxLayout to mainPanel
        boxLayout.layoutContainer(myJPanel);
        axis = !axis;
            }
        });
        myJButton1=new JButton("Button 1");
        myJPanel.add(myJButton1);
        myJButton2=new JButton("Button 2");
        myJPanel.add(myJButton2);
        myJButton3=new JButton("Button 3");
        myJPanel.add(myJButton3);
        myJButton4=new JButton("Button 4");
        myJPanel.add(myJButton4);
        myJButton5=new JButton("Button 5");
        myJPanel.add(myJButton5);
    }
    public static void main(String[] args) {
        create_JFrame_with_BoxLayout myBoxLayout = new create_JFrame_with_BoxLayout();
        myBoxLayout.create_JFrame("JFrame with BoxLayout");
        myBoxLayout.create_JPanel();
        myBoxLayout.set_Layout_JPanel();
        myBoxLayout.create_JButton_and_add_JButton_to_JPanel();
        myBoxLayout.add_JPanel_to_JFrame();
        myBoxLayout.display_JFrame();
    }
}

/*
chú ý khi sử dụng BoxLayout: hàm khởi tạo của BoxLayout có đối chính là Container của chúng ta.
BoxLayout(Container target, int axis): Tạo BoxLayout với cách bố trí là axis.
Vì vậy chúng ta cần khởi tạo Container (JPanel) trước, 
sau đó khởi tạo BoxLayout và cuối cùng dùng hàm setLayout để đặt Layout cho JPanel.
Việc sắp xếp các đối tượng theo chiều ngang hay dọc phục thuộc vào đối số axis, X_AXIS 
sẽ sắp xếp theo chiều ngang, Y_AXIS là theo chiều dọc.

Lớp BoxLayout, trong java.swing package, được sử dụng để sắp xếp các thành phần 
hoặc theo chiều dọc hoặc theo chiều ngang. Để phục vụ mục đích này, lớp BoxLayout cung cấp 4 hằng:
1. public static final int X_AXIS
2. public static final int Y_AXIS
3. public static final int LINE_AXIS
4. public static final int PAGE_AXIS

Constructor của lớp BoxLayout
BoxLayout(Container c, int axis): tạo một box layout mà sắp xếp các thành phần theo trục đã cho.
*/