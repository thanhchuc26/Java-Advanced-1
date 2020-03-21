/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author June
 */
public class create_JRadioButton extends JFrame implements ItemListener {

    private JRadioButton radBoy, radGirl;
    private JLabel lbGender;

    public create_JRadioButton() {
        // add main panel
        add(createMainPanel());
        // set display
        setTitle("JRadioButton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // create main panel
    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        // add two radiobutton and a label to frame
        panel.add(radBoy = createRadioButton("Boy", true));
        panel.add(radGirl = createRadioButton("Girl", false));
        panel.add(lbGender = createLabel("You are a boy"));

        // create ButtonGroup for radBoy and radGirl
        ButtonGroup genderGroup = new ButtonGroup();
        // add radBoy and radGirl into Group
        genderGroup.add(radBoy);
        genderGroup.add(radGirl);

        return panel;
    }

    // create a JRadioButton with name
    private JRadioButton createRadioButton(String name, boolean select) {
        JRadioButton rad = new JRadioButton(name, select);
        rad.addItemListener(this);
        return rad;
    }

    // create a JLabel with text
    private JLabel createLabel(String text) {
        JLabel lb = new JLabel(text);
        return lb;
    }

    private void changeSelect() {
        lbGender.setText("You are a " + (radBoy.isSelected() ? "boy" : "girl"));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        changeSelect();
    }

    public static void main(String[] args) {
        create_JRadioButton myJRadioButton = new create_JRadioButton();
    }
}

/*
JRadioButton là một đối tượng cho phép chúng ta chọn lựa các thuộc tính giốn như JCheckBox. 
Tuy nhiên chúng ta hay sử dụng JRadioButton khi mà muốn người dùng chỉ chọn được một trong các thuộc tính. 
Ví dụ chọn giới tính thì người dùng chỉ được chọn là Nam hoặc Nữ.

Cách tạo JRadioButton – How to create JRadioButton
Để tạo được JRadioButton chúng ta dùng một trong các hàm khởi tạo sau:
– JRadioButton(): Tạo JRadioButton không có text, không được chọn trước.
– JRadioButton(Action a): Tạo JRadioButton với sự kiện a
– JRadioButton(Icon icon): Tạo JRadioButton với icon
– JRadioButton(Icon icon, boolean selected): Tạo JRadioButton với icon và đặt là được chọn hay không
– JRadioButton(String text): Tạo JRadioButton với text
– JRadioButton(String text, boolean selected): Tạo JRadioButton với text và đặt là được chọn hay không
– JRadioButton(String text, Icon icon): Tạo JRadioButton với text và icon
– JRadioButton(String text, Icon icon, boolean selected): Tạo JRadioButton với text, icon và đặt lựa chọn.

Bây giờ chúng ta sẽ thực hiện tạo JFrame gồm 2 JRadioButton là Boy và Girl (Boy được chọn mặc định) 
cùng với 1 JLabel để hiển thực hiện hiển thị kết quả khi chọn JRadioButton.

Đặt JRadioButton vào nhóm – Set group for JRadioButton
Để làm được việc mà chỉ cho phép người dùng chọn một trong các JRadioButton chúng ta cần đặt các JRadioButton 
vào một nhóm – ButtonGroup. Tức là chúng ta cần tạo ra một ButtonGroup và đặt chúng vào trong ButtonGroup đó. 

Bắt sự kiện cho JRadioButton – Action on JRadioButton
Tiếp theo sẽ là bắt sự kiện cho JRadioButton, nó tương tự như bắt sự kiện cho JCheckBox. 
Chúng ta cần implements giao diện ItemListener để thực hiện addItemListener cho các JRadioButton. 
Tiếp theo là viết phương thức itemStateChanged để bắt sự kiện. 
Kiểm tra một JRadioButton được chọn hay không bằng phương thức isSelected().
*/