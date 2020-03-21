/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class create_JOptionPane extends JFrame {

    JPanel mainPanel;
    JButton btnInputDialog, btnConfirmDialog, btnMessageDialog, btnOptionDialog;
    JLabel lblMessage;
    JTextField txtMessage;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("JOptionPane Example");
        setSize(350, 120);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel();
    }

    void btnInputDialog() {
        btnInputDialog = new JButton("Input Dialog");
        btnInputDialog.setPreferredSize(new Dimension(150, 25));
        mainPanel.add(btnInputDialog);
        btnInputDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String str = JOptionPane.showInputDialog(null, "Please enter the message:", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
                txtMessage.setText(str);
            }
        });
    }

    void btnConfirmDialog() {
        btnConfirmDialog = new JButton("Confirm Dialog");
        btnConfirmDialog.setPreferredSize(new Dimension(150, 25));
        mainPanel.add(btnConfirmDialog);
        btnConfirmDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = JOptionPane.showConfirmDialog(null, "Do you want to insert string \"Confirm dialog\" to textbox message?", "Comfirm Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == 0) {
                    txtMessage.setText("Confirm dialog");
                } else {
                    txtMessage.setText("");
                }
            }
        });
    }

    void btnMessageDialog() {
        btnMessageDialog = new JButton("Message Dialog");
        btnMessageDialog.setPreferredSize(new Dimension(150, 25));
        mainPanel.add(btnMessageDialog);
        btnMessageDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Content of message textbox: " + txtMessage.getText(), "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    void btnOptionDialog() {
        btnOptionDialog = new JButton("Option Dialog");
        btnOptionDialog.setPreferredSize(new Dimension(150, 25));
        mainPanel.add(btnOptionDialog);
        btnOptionDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = JOptionPane.showConfirmDialog(null, "Do you want to insert string \"Option dialog\" to textbox message?", "Option Dialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == 0) {
                    txtMessage.setText("Option dialog");
                } else {
                    if (i == 1) {
                        txtMessage.setText("");
                    } else {

                    }
                }
            }
        });
    }

    void create_and_add_lblMessage_to_mainPanel() {
        lblMessage = new JLabel("Message:      ");
        mainPanel.add(lblMessage);
    }

    void create_and_add_txtMessage_to_mainPanel() {
        txtMessage = new JTextField(20);
        mainPanel.add(txtMessage);
    }

    void addMainPanel_to_JFrame() {
        add(this.mainPanel);
    }

    void displayJFrame() {
        setVisible(true);
    }

    public static void main(String[] args) {
        create_JOptionPane mainFrame = new create_JOptionPane();
        mainFrame.create_JFrame();
        mainFrame.create_mainPanel();
        mainFrame.btnInputDialog();
        mainFrame.btnConfirmDialog();
        mainFrame.btnMessageDialog();
        mainFrame.btnOptionDialog();

        mainFrame.create_and_add_lblMessage_to_mainPanel();
        mainFrame.create_and_add_txtMessage_to_mainPanel();
        mainFrame.addMainPanel_to_JFrame();
        mainFrame.displayJFrame();
    }
}

/*
JOptionPane: là thành phần có vai trò như một hộp thoại (dialog box) 
được sử dụng để thông báo đến người dùng 1 điều gì đó hoặc lấy giá trị từ người người dùng cuối.

Constructor khởi tạo:
* JOptionPane()
* JOptionPane(Object message)
* JOptionPane(Object message, int messageType): 
trong đó messageType có 5 loại (ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE).
* JOptionPane(Object message, int messageType, int optionType): 
trong đó optionType có 4 loại (DEFAULT_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION, OK_CANCEL_OPTION).
* JOptionPane(Object message, int messageType, int optionType, Icon icon)

Một số phương thức dùng với JOptionPane:
* public void setMessage(Object newMessage)
* public Object getMessage()
* public void setIcon(Icon newIcon)
* public Icon getIcon()
* public void setMessageType(int newType)
* public int getMessageType()
* public void setOptionType(int newType)
* public int getOptionType()

Thông thường khi dùng JOptionPane, chúng ta không cần phải tạo một thực thể của nó 
mà có thể sử dụng trực tiếp thông qua một vài phương thức sau:
* public static String showInputDialog(Object message)
* public static String showInputDialog(Object message, Object initialSelectionValue)
* public static String showInputDialog(Component parentComponent, Object message)
* public static String showInputDialog(Component parentComponent, Object message, Object initialSelectionValue)
* public static String showInputDialog(Component parentComponent, Object message, String title, int messageType)
* public static Object showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue)
* public static void showMessageDialog(Component parentComponent, Object message)
* public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType)
* public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType, Icon icon)
* public static int showConfirmDialog(Component parentComponent, Object message)
* public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType)
* public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType)
* public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon)
* public static void showMessageDialog(Component parentComponent, Object message)
* public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType)
* public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType, Icon icon)
* public static int showConfirmDialog(Component parentComponent, Object message)
* public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType)
* public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType)
* public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon)
 */
