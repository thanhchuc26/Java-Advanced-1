/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session05_ListsAndPanes;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author June
 */
public class create_Simple_JList extends JFrame {

    private int width = 300;
    private int height = 200;

    // create array string color to show in list
    String[] colorName = {"blue", "green", "red"};
    // create array color
    Color[] backGroundColor = {Color.blue, Color.green, Color.red};
    JList<String> myJList;

    // create JList width array color
    public create_Simple_JList() {
        // set layout for contenPane
        getContentPane().setLayout(new FlowLayout());

        // add list color
        add(createJList());

        // set display
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Simple JList");
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JList createJList() {
        // create list
        myJList = new JList<String>(colorName);
        // add listen to get action when select item in JList
        myJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                changeBackGround();
            }
        });
        return myJList;
    }

    // change background JFrame
    private void changeBackGround() {
        getContentPane().setBackground(
                backGroundColor[myJList.getSelectedIndex()]);
    }

    public static void main(String[] args) {
        create_Simple_JList myJList = new create_Simple_JList();
    }
}


/*
* Các phương thức khởi tạo của JList:
– JList(): tạo một JList rỗng
– JList(E[] listData): tạo 1 JList với một mảng dữ liệu
– JList(ListModel dataModel): tạo JList với một model đã có
– JList(Vector listData): tạo JList với dữ liệu trong vecto

* Cách bắt sự kiện khi chọn một item trong list ta add phương thức addListSelectionListener cho JList. 
Sau đó sẽ viết đè phương thức valueChanged để thực hiện công việc mong muốn. 
Sử dụng phương thức getSelectedIndex để lấy vị trí được chọn trong JList

* Chú ý trong Ví dụ trên do chúng ta sử dụng trực tiếp JFrame nên muốn thay đổi được màu nền của Frame 
chúng ta cần setLayout cho JFrame và khi thực hiện thay màu nền cần thưc hiện gọi getContentPane().setBackground.
 */
