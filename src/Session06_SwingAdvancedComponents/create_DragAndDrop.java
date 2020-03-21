/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session06_SwingAdvancedComponents;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

/**
 *
 * @author June
 */
public class create_DragAndDrop extends JFrame {

    JTextField field;
    JButton button;

    public create_DragAndDrop() {
        setTitle("Built-in Drag and Drop");
        setLayout(new GridLayout(1, 2));
// Creates an array and initializes the JList
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul"};
        JList l = new JList(month);
        field = new JTextField();
        field.setBounds(30, 50, 50, 25);
        add(field);
        add(l);
// Enables the drag on JList
        l.setDragEnabled(true);
// Sets the transferable property for the text box
        field.setTransferHandler(new TransferHandler("text"));
        setSize(330, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new create_DragAndDrop();
    }
}
