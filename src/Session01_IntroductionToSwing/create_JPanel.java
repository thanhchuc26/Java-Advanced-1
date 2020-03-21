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
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author June
 */
public class create_JPanel extends JFrame implements ActionListener{
    private int numlabel = 0; // number JLabel in panel
    JPanel panel1, panel2;
 
    public create_JPanel() {
        createJFrame();
    }
 
    // create JFrame
    private void createJFrame() {
        setTitle("Create JPanel");
        setLayout(new GridLayout(2, 1, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        createContent();
 
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    private void createContent() {
        // create panel1 with layout default is FlowLayout
        panel1 = new JPanel();
        // add a label into panel1
        addJLabel(panel1);
 
        // create panel2 with GridLayout
        panel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel2.add(createJButton("Add a JLabel"));
        panel2.add(createJButton("Remove all JLabel"));
 
        // add panel1 and panel2 into JFrame
        add(panel1);
        add(panel2);
    }
 
    // add JLabel to panel and repaint
    private void addJLabel(JPanel panel) {
        panel.add(new JLabel("JLabel" + (++numlabel)));
        panel.validate();
        panel.repaint();
    }
 
    // remove all JLabel and repaint JPanel
    private void removeAllJLabel(JPanel panel) {
        panel.removeAll();
        panel.validate();
        panel.repaint();
        numlabel = 0;
    }
 
    // create a JButton
    private JButton createJButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }
 
    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command == "Add a JLabel") {
            addJLabel(panel1);
            System.out.println("add" + panel1.getComponentCount());
        }
        if (command == "Remove all JLabel") {
            removeAllJLabel(panel1);
        }
    }
    public static void main(String[] args) {
        create_JPanel myJPanel=new create_JPanel();
    }
}


/*
JPanel là một container (thùng chứa) nó dùng để chứa các đối tượng tương tự như JFrame 
tuy nhiên nó không phải là 1 JFrame. Dễ hiểu hơn thì bạn có thể hình dùng ngôi nhà của chúng ta là 1 JFrame, 
còn phòng ngủ, phòng khách, phòng ăn đó là các JPanel, tức là trong một JFrame chứa các JPanel, 
trong mỗi JPanel lại có thể chứa các đối tượng hoặc thậm chí là các JPanel khác.

Ví dụ: Tạo 1 JFrame chứa 2 JPanel, 1 JPanel chứa các JLabel, 
1 JPanel chứa 2 JButton cho phép thêm hoặc loại bỏ JLabel.
Trong ví dụ này chúng ta tạo ra 2 JPanel, 
panel1 được khởi tạo mặc định, không có tham số truyền vào 
nên nó có Layout mặc định là FlowLayout 
(cách bố trí mà các đối tượng nối tiếp nhau). 
panel2 được khởi tạo với Layout chỉ định là GridLayout 
(bố trí các đối tượng theo từng ô bằng nhau).
Các bạn cũng chú ý đến 2 hàm addJLabel(JPanel panel) 
và removeAllJLabel(JPanel panel), 
sau khi dùng phương thức add, hoặc removeAll của JPanel, 
muốn những thay đổi đó (thêm JLabel, hoặc xóa toàn bộ JLabel) 
được hiển thị, cập nhật trên JFrame thì chúng ta 
cần gọi 2 phương thức validate() và repaint() 
để vẽ lại các đối tượng mà JPanel có. 
Chúng ta cũng có thể làm tương tự với JFrame.
*/
