/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author June
 */
public class create_JFrame_with_CardLayout extends JFrame {

    JPanel myCardLayout, myJPanel1, myJPanel2, myJPanel3, myJPanel4, buttonPanel;
    JButton buttonNext, buttonPrevious, buttonAnyCard;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3));
        setTitle(title);
        setSize(400, 200);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JPanel() {
        myCardLayout = new JPanel();
    }

    public void create_buttonPanel() {
        buttonPanel = new JPanel();
    }

    public void set_Layout_JPanel() {
        myCardLayout.setLayout(new CardLayout());
    }

    public void add_JPanel_to_JFrame() {
        add(myCardLayout);
        add(buttonPanel);
    }

    public JButton create_JButton(String title) {
        JButton myJButton = new JButton(title);
        return myJButton;
    }

    public void create_4JPanel() {
        myJPanel1 = new JPanel();
        myJPanel2 = new JPanel();
        myJPanel3 = new JPanel();
        myJPanel4 = new JPanel();
    }

    public void add_4JButton_to_4JPanel() {
        myJPanel1.add(create_JButton("Cơ"));
        myJPanel2.add(create_JButton("Rô"));
        myJPanel3.add(create_JButton("Chuồn"));
        myJPanel4.add(create_JButton("Bích"));
    }

    public void add_4JPanel_to_myCardLayout() {
        myCardLayout.add(myJPanel1, "Co");
        myCardLayout.add(myJPanel2, "Ro");
        myCardLayout.add(myJPanel3, "Chuon");
        myCardLayout.add(myJPanel4, "Bich");
    }

    public void create_buttonNext() {
        buttonNext = new JButton("Next card");
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cardLayout = (CardLayout) myCardLayout.getLayout();
                cardLayout.next(myCardLayout);
            }
        });
    }

    public void create_buttonPrevious() {
        buttonPrevious = new JButton("Previous card");
        buttonPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cardLayout = (CardLayout) myCardLayout.getLayout();
                cardLayout.previous(myCardLayout);
            }
        });
    }

    public void create_buttonnAnyCard() {
        buttonAnyCard = new JButton("Show \"Chuon\" card");
        buttonAnyCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cardLayout = (CardLayout) myCardLayout.getLayout();
                cardLayout.show(myCardLayout,"Chuon");
            }
        });
    }

    public void add_3JButton_to_buttonPanel() {
        buttonPanel.add(buttonPrevious);
        buttonPanel.add(buttonNext);
        buttonPanel.add(buttonAnyCard);
    }

    public static void main(String[] args) {
        create_JFrame_with_CardLayout mycreate_JFrame_with_CardLayout = new create_JFrame_with_CardLayout();
        mycreate_JFrame_with_CardLayout.create_JFrame("JFrame with CardLayout");
        mycreate_JFrame_with_CardLayout.create_JPanel();
        mycreate_JFrame_with_CardLayout.create_buttonPanel();
        mycreate_JFrame_with_CardLayout.set_Layout_JPanel();
        mycreate_JFrame_with_CardLayout.create_4JPanel();
        mycreate_JFrame_with_CardLayout.add_4JButton_to_4JPanel();
        mycreate_JFrame_with_CardLayout.add_4JPanel_to_myCardLayout();
        mycreate_JFrame_with_CardLayout.create_buttonPrevious();
        mycreate_JFrame_with_CardLayout.create_buttonNext();
        mycreate_JFrame_with_CardLayout.create_buttonnAnyCard();
        mycreate_JFrame_with_CardLayout.add_3JButton_to_buttonPanel();
        mycreate_JFrame_with_CardLayout.add_JPanel_to_JFrame();
        mycreate_JFrame_with_CardLayout.display_JFrame();
    }
}

/*
Lớp CardLayout quản lý các thành phần theo một phương thức mà chỉ có một thành phần là nhìn thấy (visible) 
tại một thời điểm. Nó xem xét mỗi thành phần như là một card, và container hoạt động như là một stack 
của các card, và đó là lý do tại sao gọi là CardLayout.

Các constructor của lớp CardLayout
CardLayout(): tạo một Card Layout với các khoảng cách theo chiều dọc và ngang là 0.
CardLayout(int hgap, int vgap): tạo một Card Layout với các khoảng cách gap theo chiều dọc và ngang đã cho

Các phương thức được sử dụng phổ biến của lớp CardLayout
public void next(Container parent): được sử dụng để lật tới card tiếp theo của container đã cho
public void previous(Container parent): được sử dụng để lật tới card trước đó của container đã cho
public void first(Container parent): được sử dụng để lật tới card đầu tiên của container đã cho
public void last(Container parent): được sử dụng để lật tới card cuối cùng của container đã cho
public void show(Container parent, String name): được sử dụng để lật tới card đã được xác định bởi tên name đã cho.
*/