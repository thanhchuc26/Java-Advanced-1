/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class create_JCheckBox  implements ItemListener {
    private JCheckBox checkMoney, checkHouse, checkCar;
    private JLabel lbMoney, lbHouse, lbCar;
    public void create_Simple_JCheckBox(){
        //create JFrame
        JFrame myJFrame = new JFrame("JCheckbox Example");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(300, 150);
        // create JPanel container three checkBox
        JPanel panelCheckBox = new JPanel(new GridLayout(4, 0, 5, 5));
        
        // create three checkBox
        JCheckBox myJCheckBox1 = new JCheckBox("Money");
        JCheckBox myJCheckBox2 = new JCheckBox("Car");
        JCheckBox myJCheckBox3 = new JCheckBox("House");
        // add three checkBox to panelCheckBox
        panelCheckBox.add(myJCheckBox1);
        panelCheckBox.add(myJCheckBox2);
        panelCheckBox.add(myJCheckBox3);
        // create JPanel container three checkBox
        JPanel panelLabel = new JPanel(new GridLayout(4, 0, 5, 5));
        // create three Label
        JLabel myJLabel1 = new JLabel("Money");
        myJLabel1.setEnabled(false);
        JLabel myJLabel2 = new JLabel("Car");
        myJLabel2.setEnabled(false);
        JLabel myJLabel3 = new JLabel("House");
        myJLabel3.setEnabled(false);
        // add three Label to panelLabel
        panelLabel.add(myJLabel1);
        panelLabel.add(myJLabel2);
        panelLabel.add(myJLabel3);
        // create mainPanel container panelCheckBox and panelLabel
        JPanel mainPanel = new JPanel(new BorderLayout());
        // add panelCheckBox and panelShow to main panel
        mainPanel.add(panelCheckBox, BorderLayout.WEST);
        mainPanel.add(panelLabel, BorderLayout.CENTER);
        // display JFrame
        myJFrame.add(mainPanel);
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setVisible(true);
    }
    /*
    JFrame gồm có 2 phần chính là phần bên trái chứa 3 JCheckBox, phần bên phải chứa 3 JLabel tương ứng
    
    Khi tạo CheckBox ta đã dùng phương thức khởi tạo JCheckBox checkBox = new JCheckBox(name); 
    đây là cách tạo ra 1 JCheckBox với text tương ứng. 
    Ngoài ra chúng ta có các phương thức khởi tạo khác như:
– JCheckBox(): Tạo ra 1 JCheckBox không có text, không có icon, không được check.
– JCheckBox(Action a): Tạo JCheckBox với một action
– JCheckBox(Icon icon): Tạo JCheckBox với một icon
– JCheckBox(Icon icon, boolean selected): Tạo JCheckBox có icon và thiết đặt chọn hay không.
– JCheckBox(String text, boolean selected): Tạo JCheckBox có text và thiết đặt chọn hay không.
– JCheckBox(String text, Icon icon): Tạo JCheckBox có text, có icon
– JCheckBox(String text, Icon icon, boolean selected): Tạo JCheckBox có text, có icon, thiết đặt đựoc chọn hay không.
    */
    
    public void create_JCheckbox_with_event(){
        //create JFrame
        JFrame myJFrame = new JFrame("JCheckbox Example");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(300, 150);
        // create JPanel container three checkBox
        JPanel panelCheckBox = new JPanel(new GridLayout(4, 0, 5, 5));
        
        // create three checkBox
//        private JCheckBox checkMoney, checkHouse, checkCar;

        checkMoney = new JCheckBox("Money");
        checkMoney.addItemListener(this);
        checkCar = new JCheckBox("Car");
        checkCar.addItemListener(this);
        checkHouse = new JCheckBox("House");
        checkHouse.addItemListener(this);
        // add three checkBox to panelCheckBox
        panelCheckBox.add(checkMoney);
        panelCheckBox.add(checkCar);
        panelCheckBox.add(checkHouse);
        // create JPanel container three checkBox
        JPanel panelLabel = new JPanel(new GridLayout(4, 0, 5, 5));
        // create three Label
        //    private JLabel lbMoney, lbHouse, lbCar;
        lbMoney = new JLabel("Checkbox Money selected");
        lbMoney.setEnabled(false);
        lbCar = new JLabel("Checkbox Car selected");
        lbCar.setEnabled(false);
        lbHouse = new JLabel(" CheckboxHouse selected");
        lbHouse.setEnabled(false);
        // add three Label to panelLabel
        panelLabel.add(lbMoney);
        panelLabel.add(lbCar);
        panelLabel.add(lbHouse);
        // create mainPanel container panelCheckBox and panelLabel
        JPanel mainPanel = new JPanel(new BorderLayout());
        // add panelCheckBox and panelShow to main panel
        mainPanel.add(panelCheckBox, BorderLayout.WEST);
        mainPanel.add(panelLabel, BorderLayout.CENTER);
        // display JFrame
        myJFrame.add(mainPanel);
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setVisible(true);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkMoney) {
            lbMoney.setEnabled(checkMoney.isSelected());
            return;
        }
        if (e.getSource() == checkCar) {
            lbCar.setEnabled(checkCar.isSelected());
            return;
        }
        if (e.getSource() == checkHouse) {
            lbHouse.setEnabled(checkHouse.isSelected());
            return;
        }
    }
    /*
    Để bắt được sự kiện khi check vào checkBox ta cần addItemListener cho mỗi checkBox.
    
    Khi này, class của chúng ta cần implements interface ItemListener và viết đè phương thức 
    public void itemStateChanged(ItemEvent e). 
    Phương thức này chính là phương thức để chúng ta thực hiện công việc khi check vào checkBox. 
    Trong ví dụ này chúng ta sẽ bắt sự kiện check mỗi khi check vào một checkBox nào đó. 
    Sau đó sẽ kiểm tra xem checkBox đó được chọn hay bị bỏ chọn để set hiển thị hoặc không hiển thị JLabel tương ứng.
    
    Để kiểm tra xem checkBox có được chọn hay không ta dùng phương thức isSelected().
    
    
    */
    public static void main(String[] args) {
        create_JCheckBox myJCheckBox1=new create_JCheckBox();
        myJCheckBox1.create_Simple_JCheckBox();
        create_JCheckBox myJCheckBox2=new create_JCheckBox();
        myJCheckBox2.create_JCheckbox_with_event();
    }
}

/*
Lớp JCheckBox là một trình triển khai của một checkbox, là một item mà có thể được lựa chọn (selected) 
hoặc không được lựa chọn (unselected), và hiển thị trạng thái của nó tới người dùng.
*/