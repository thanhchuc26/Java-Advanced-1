/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session04_MenuComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author June
 */
public class create_full_menu extends JFrame {

    JPanel myJPanel;
    JMenuBar myJMenuBar;
    JMenu menuFile,
            menuEdit,
            menuView,
            menuView_Split,
            menuEditors;
    JMenuItem menuItemNewProject,
            menuItemNewFile,
            menuItemExit,
            //            menuItemEditors,
            menuItemVertically,
            menuItemHorizontally,
            menuItemClear;
    JCheckBoxMenuItem menuItemShowEditorToolbar;
    JRadioButtonMenuItem menuItemSource,
            menuItemHistory;
    ButtonGroup menuView_Editors;
    JPopupMenu popupMenu;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 200);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JPanel() {
        myJPanel = new JPanel();
        myJPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                popupMenu.show(myJPanel, me.getX(), me.getY());
            }

            @Override
            public void mousePressed(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(myJPanel, me.getX(), me.getY());
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void create_JMenuBar() {
        myJMenuBar = new JMenuBar();
    }

    public void add_JMenuBar_to_JFrame() {
        setJMenuBar(myJMenuBar);
    }

    public void create_JMenu() {
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuView = new JMenu("View");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuEdit.setMnemonic(KeyEvent.VK_E);
        menuView.setMnemonic(KeyEvent.VK_V);
        popupMenu = new JPopupMenu();
    }

    public void add_JMenu_to_JMenuBar() {
        myJMenuBar.add(menuFile);
        myJMenuBar.add(menuEdit);
        myJMenuBar.add(menuView);
    }

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void create_JMenuItem_for_JMenuFile() {
        ImageIcon icon = createImageIcon("iconnewFile.png");
        System.out.println(this.getClass().getResource("iconnewFile.png"));
//        menuItemNewProject = new JMenuItem("New Project...");
        menuItemNewProject = new JMenuItem("New Project...", icon);
        menuItemNewFile = new JMenuItem("New File...");
        menuItemExit = new JMenuItem("Exit");
        menuItemExit.setMnemonic(KeyEvent.VK_X);
        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

    public void add_JMenuItem_to_JMenuFile() {
        menuFile.add(menuItemNewProject);
        menuFile.add(menuItemNewFile);
        menuFile.add(menuItemExit);
    }

    public void create_JMenuItem_for_JMenuView() {
        menuEditors = new JMenu("Editors");
        menuItemSource = new JRadioButtonMenuItem("Source");
        menuItemHistory = new JRadioButtonMenuItem("History");
        menuView_Editors = new ButtonGroup();
        menuView_Editors.add(menuItemSource);
        menuView_Editors.add(menuItemHistory);
        menuEditors.add(menuItemSource);
        menuEditors.add(menuItemHistory);
        menuView_Split = new JMenu("Split");
        menuItemVertically = new JMenuItem("Vertically");
        menuItemHorizontally = new JMenuItem("Horizontally");
        menuItemClear = new JMenuItem("Clear");
        menuView_Split.add(menuItemVertically);
        menuView_Split.add(menuItemHorizontally);
        menuItemShowEditorToolbar = new JCheckBoxMenuItem("Show Editor Toolbar");
    }

    public void add_JMenuItem_to_JMenuView() {
        menuView.add(menuEditors);
        menuView.add(menuView_Split);
        menuView.add(menuItemClear);
        menuView.addSeparator();
        menuView.add(menuItemShowEditorToolbar);
    }

    public void add_JMenuItem_to_PopupMenu() {
        popupMenu.add(menuFile);
        popupMenu.addSeparator();
        popupMenu.add(menuItemNewFile);
    }

    public static void main(String[] args) {
        create_full_menu myMenu = new create_full_menu();
        myMenu.create_JFrame("JFrame with Menu");
        myMenu.create_JPanel();
        myMenu.create_JMenuBar();
        myMenu.add_JMenuBar_to_JFrame();
        myMenu.create_JMenu();
        myMenu.add_JMenu_to_JMenuBar();
        myMenu.create_JMenuItem_for_JMenuFile();
        myMenu.add_JMenuItem_to_JMenuFile();
        myMenu.create_JMenuItem_for_JMenuView();
        myMenu.add_JMenuItem_to_JMenuView();
        myMenu.add_JMenuItem_to_PopupMenu();
        myMenu.add_JPanel_to_JFrame();
        myMenu.display_JFrame();
    }
}
