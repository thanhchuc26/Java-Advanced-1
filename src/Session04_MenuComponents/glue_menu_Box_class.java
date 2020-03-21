/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session04_MenuComponents;

/**
 *
 * @author June
 *
 */
// Import the necessary classes
import javax.swing.*;

public class glue_menu_Box_class {

    public static void main(String[] args) {
        JFrame frm;
        JMenuBar mnbBar;
        JMenu mnuFile, mnuEdit, mnuView, mnuHelp;
        mnbBar = new JMenuBar();
// Creates a frame
        frm = new JFrame();
        frm.setSize(400, 400);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.add(mnbBar);
        mnuFile = new JMenu("File");
        mnuEdit = new JMenu("Edit");
        mnuView = new JMenu("View");
        mnuHelp = new JMenu("Help");
// Add the menus
        mnbBar.add(mnuFile);
        mnbBar.add(mnuEdit);
        mnbBar.add(mnuView);
// Add a Horizontal Glue
        mnbBar.add(Box.createHorizontalGlue());
// Add the last menu
        mnbBar.add(mnuHelp);
        frm.setJMenuBar(mnbBar);
        frm.setVisible(true);
    }

}
