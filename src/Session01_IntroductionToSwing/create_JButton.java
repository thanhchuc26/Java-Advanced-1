/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author June
 */
public class create_JButton implements ActionListener{

    private JLabel myJLabel;
    private int countClick=0;
    private JButton btnGreen;

    public void create_Simple_JButton() {
        // create frame
        JFrame myJFrame = new JFrame("JButton Example 1");
        myJFrame.setLayout(new GridLayout(2, 1, 5, 5));
        myJFrame.setSize(300, 200);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create JLabel
        myJLabel = new JLabel("My JLabel");
        
        myJLabel.setHorizontalAlignment(JLabel.CENTER);
        myJFrame.add(myJLabel);
        // create JButton with text "Click Button"
        JButton myJButton = new JButton("Click Button");
        // add action
        myJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                countClick++;
                changeTextJLabel();

            }
        });
        myJFrame.add(myJButton);
        // display frame
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setVisible(true);
    }

    // change text of lb
    private void changeTextJLabel() {
        if (countClick==1)
            myJLabel.setText("You are clicked JButton "+countClick+" time");
        else
            myJLabel.setText("You are clicked JButton "+countClick+" times");
    }
    /*
    Một số điểm lưu ý
* Khởi tạo JButton: chúng ta có một số phương thức khởi tạo JButton
– JButton() : Tạo một Button không có text hoặc icon
– JButton(Action a) : Tạo một Button có thuộc tính được lấy từ một Action
– JButton(Icon icon) : Tạo một Button chỉ định một icon
– JButton(String text) : Tạo một Button chỉ định text
– JButton(String text, Icon icon) : Tạo một Button chỉ định text và icon
* Tạo action cho Jbutton ta sử dụng phương thức addActionListener của JButton để thực hiện việc này. 
    Sau đó có thể tạo mới 1 ActionListener ngay trong đó như ví dụ trên. 
    Các bạn chỉ cần viết new Action sau đó ấn Ctrl + Space (cách) NetBean hoặc Eclipse sẽ hiển thị cho các bạn 
    danh sách các phương thức và interface, bạn chọn ActionListener() 
    nó sẽ tự động tạo phương thức ActionPerformed() cho các bạn. 
    Sau đó chúng ta gọi phương thức changeTextJLabel() để thay đổi text của JLabel khi ta click vào button. 
    Lưu ý do ta tạo mới cái ActionListener ngay trong addActionListener nên không thể gọi trực tiếp setText 
    của JLabel. Nếu muốn gọi trực tiếp ta cần gọi thông qua tên class: MyJButton.lb.setText(), 
    tuy nhiên chúng ta ít làm theo cách này.
    */
    
    public void create_JButton_with_event(){
        // create JFrame
        JFrame myJFrame = new JFrame("JButton Example");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(300, 300);
        myJFrame.setLayout(new GridLayout(3, 1, 5, 5));
        // add JFrame content
        myJLabel = new JLabel("Background default");
        myJLabel.setOpaque(true);
        myJFrame.add(myJLabel);
        //create JButton with title is Green
        btnGreen = createJButton("Green");
        myJFrame.add(btnGreen);
        //create JButton with title is Blue
        myJFrame.add(createJButton("Blue"));
        // display JFrame
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setVisible(true);
    }
    // create JButton with text is title
    private JButton createJButton(String title) {
        JButton myJButton = new JButton(title);
        // add action for JButton
        myJButton.addActionListener(this);
        return myJButton;
    }
    // change text and background of JLabel when click button
    private void changeBackgroundJLabel(Color bgcolor, String nameBgcolor) {
        myJLabel.setBackground(bgcolor);
        myJLabel.setText("Background is " + nameBgcolor);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // click button green
        if (e.getSource() == btnGreen) {
            changeBackgroundJLabel(Color.green, "Green");
        }
        // click button blue
        if (e.getActionCommand() == "Blue") {
            changeBackgroundJLabel(Color.blue, "Blue");
        }
    }
    /*
Trong ví dụ 2 này chúng ta tạo một JLabel và 2 JButton được đặt trong một GriLayour với 3 hàng và 1 cột. 
    Khi click vào button “Green” hoặc “Blue” thì text và background của JLabel được thay đổi.

2 cách tạo và bắt sự kiện trong ví dụ này cũng khác hoàn toàn so với ví dụ trước. 
    Ở đây chúng ta implements Interface ActionListener để phục vụ việc lắng nghe sự kiện. 
    Khi implements Interface này thì chúng ta cần phải Override phương thức actionPerfomed() 
    của nó để thực hiện việc lắng nghe sự kiện. Đối của phương thức này là 1 ActionEvent e, 
    đây chính là sự kiện mà nó nghe được.
Để biết được chính xác button nào được ấn thì ta cần so sánh nó với các button. Đối với btnGreen, nó là 1 biến “toàn cục” của class nên ta có thể so sánh bằng cách dùng e.getSource() == btnGreen để kiểm tra, tuy nhiên với button Blue thì nó không phải vậy mà nó là một JButton được tạo trong phương thức createJButton() nên muốn kiểm tra được nó ta so sánh với nhãn text của nó bằng lệnh e.getActionCommand() == “Blue”.

Bạn lại chú ý lên phương thức createJButton() nó trả về 1 JButton. 
    Các button được tạo bới phương thức này cần được addActionListener(this). 
    Vì chúng ta đã implements Interface ActionListener nên phương thức này có đối là this 
    tức là tác động đến chính cái ActionListener đó do đó mà các button có thể nghe được sự kiện.

Đặt Magin cho JButton:
Nếu text của Jbutton hơi dài quá so với kích thước của nó, 
    bạn có thể đặt khoảng cách giữa biên của button tới text bằng cách dùng phương thức:
setMargin(new Insets(int bottom, int left, int right, int top));
VD: btn.setMargin(new Insets(0, 0, 0, 0)); text sẽ cách các biên là 0 (sát biên).
    */
    public static void main(String[] args) {
        create_JButton myJButton1 = new create_JButton();
        myJButton1.create_Simple_JButton();
        create_JButton myJButton2 = new create_JButton();
        myJButton2.create_JButton_with_event();
    }
}

/*
Lớp JButton được sử dụng để tạo một nút button mà có trình triển khai là độc lập nền tảng. 
Thành phần này có một label và tạo một sự kiện (event) khi được nhấn. Nó cũng có thể có Image.
*/