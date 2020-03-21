/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session04_MenuComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author June
 */
public class ToolBar extends JFrame implements ActionListener {

    public static final String NEW = "new";
    public static final String OPEN = "open";
    public static final String SAVE = "save";
    
    public static String iconNew = "iconnewFile.png";
    public static String iconOpen = "iconopenFile.png";
    public static String iconSave = "iconsaveFile.png";
    
    private JTextArea ta;
    
    public ToolBar() {
        setJMenuBar(createMenuBar());
        addContent();
        setDisplay();
    }

    /**
     * set display for JFrame with title is "Demo JToolBar"
     */
    private void setDisplay() {
        setTitle("Demo JToolBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * demo menu
     */
    private JMenuBar createMenuBar() {
        JMenuBar mb = new JMenuBar();
        mb.add(new JMenu("File"));
        mb.add(new JMenu("Help"));
        return mb;
    }

    /**
     * add content of JFrame, it contain a JToolBar and a JTextArea to display
     * event on toolbar
     */
    private void addContent() {
        setLayout(new BorderLayout());
        add(createToolBar(), BorderLayout.PAGE_START);
        add(new JScrollPane(ta = createTextArea(15, 30)), BorderLayout.CENTER);
    }

    /**
     * create a toolbar
     */
    private JToolBar createToolBar() {
        JToolBar tb = new JToolBar();
//        tb.setRollover(true);
//        tb.setFloatable(false);
        tb.add(createButton(iconNew, "New", NEW, "Create a new file"));
        tb.add(createButton(iconOpen, "Open", OPEN, "Open a file"));
        tb.add(createButton(iconSave, "Save", SAVE, "Save this file"));
        tb.addSeparator(new Dimension(30, 20));
        tb.add(new JTextField(10));
        return tb;
    }

    /**
     * create a JTextArea to display events
     */
    private JTextArea createTextArea(int row, int col) {
        JTextArea ta = new JTextArea(row, col);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        // ta.setEditable(false);
        return ta;
    }

    /**
     * create a Button, it has a icon, tex (if not found icon), actionCommand
     * and tool tip text
     */
    private JButton createButton(String iconLink, String text, String command,
            String toolTip) {
        JButton btn = new JButton();
        btn.setActionCommand(command);
        btn.setToolTipText(toolTip);
        
        ImageIcon icon = createIcon(iconLink);
        if (icon == null) {
            btn.setText(text);
        } else {
            btn.setIcon(icon);
        }
        btn.setActionCommand(command);
        btn.addActionListener(this);
        return btn;
    }

    /**
     * create icon
     */
    private ImageIcon createIcon(String iconLink) {
        URL imageURL = getClass().getResource(iconLink);
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.out.println("image " + iconLink + " not found");
            return null;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String action = "null";
        if (command.equals(NEW)) {
            action = "new file";
        } else if (command.equals(OPEN)) {
            action = "open file";
        } else if (command.equals(SAVE)) {
            action = "save file";
        }
        ta.append(action + "\n");
    }

    public static void main(String[] args) {
        ToolBar myToolBar = new ToolBar();
    }
}
