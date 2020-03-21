/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class create_JFrame_with_GridBagLayout extends JFrame {

    JPanel myJPanel;
    GridBagConstraints myGridBagConstraints;
    JButton myJButton1, myJButton2, myJButton3, myJButton4, myJButton5, myJButton6, myJButton7;

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
        myJPanel.setLayout(new GridBagLayout());
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void set_GridBagConstraints() {
        myGridBagConstraints = new GridBagConstraints();
        myGridBagConstraints.gridx = 0;
        myGridBagConstraints.gridy = 0;
        myGridBagConstraints.gridwidth = 1;
        myGridBagConstraints.gridheight = 1;
        myJButton1 = new JButton("Button 1");
        myJPanel.add(myJButton1, myGridBagConstraints);
        myGridBagConstraints.gridx = 1;
        myJButton2 = new JButton("Button 2");
        myJPanel.add(myJButton2, myGridBagConstraints);
        myGridBagConstraints.gridx = 2;
        myJButton3 = new JButton("Button 3");
        myJPanel.add(myJButton3, myGridBagConstraints);
        myGridBagConstraints.gridx = 0;
        myGridBagConstraints.gridy = 1;
        myGridBagConstraints.gridwidth = 2;
        myGridBagConstraints.gridheight = 1;
        myGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        myJButton4 = new JButton("Button 4");
        myJPanel.add(myJButton4, myGridBagConstraints);
        myGridBagConstraints.gridx = 2;
        myGridBagConstraints.gridwidth = 1;
        myGridBagConstraints.gridheight = 2;
        myGridBagConstraints.fill = GridBagConstraints.VERTICAL;
        myJButton5 = new JButton("Button 5");
        myJPanel.add(myJButton5, myGridBagConstraints);
        myGridBagConstraints.gridx = 0;
        myGridBagConstraints.gridy = 2;
        myGridBagConstraints.gridwidth = 1;
        myGridBagConstraints.gridheight = 1;
        myJButton6 = new JButton("Button 6");
        myJPanel.add(myJButton6, myGridBagConstraints);
        myGridBagConstraints.gridx = 1;
        myJButton7 = new JButton("Button 7");
        myJPanel.add(myJButton7, myGridBagConstraints);
    }

    public static void main(String[] args) {
        create_JFrame_with_GridBagLayout myGridBagLayout = new create_JFrame_with_GridBagLayout();
        myGridBagLayout.create_JFrame("JFrame with GridBagLayout");
        myGridBagLayout.create_JPanel();
        myGridBagLayout.set_Layout_JPanel();
        myGridBagLayout.set_GridBagConstraints();
        myGridBagLayout.add_JPanel_to_JFrame();
        myGridBagLayout.display_JFrame();
    }
}

/*
GridBagLayout là một lớp quản lý layout linh động. 
Đối tượng của GridBagLayout căn chỉnh các thành phần theo chiều dọc, ngang 
hoặc theo baseline của chúng mà không yêu cầu các thành phần phải có cùng kích cỡ.

Lớp GridBagLayout có GridBagLayout() constructor để tạo một GridBag Layout.

Lớp GridBagLayout này gồm các trường sau:
static int DEFAULT_SIZE: Chỉ kích cỡ từ đó các thành phần hoặc khoảng cách gap 
nên được sử dụng cho một giá trị dãy cụ thể.
static int PREFERRED_SIZE: Chỉ kích cỡ được ưu tiên từ đó các thành phần hoặc khoảng cách gap 
nên được sử dụng cho một giá trị dãy cụ thể.
*/