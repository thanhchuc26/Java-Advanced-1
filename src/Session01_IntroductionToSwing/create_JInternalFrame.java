/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

/**
 *
 * @author June
 */
import javax.swing.*;

public class create_JInternalFrame {

    static JInternalFrame createFrame(String JInternalFrameName) {
        JInternalFrame myInternalFrame = new JInternalFrame(JInternalFrameName);
        myInternalFrame.setResizable(true);
        myInternalFrame.setClosable(true);
        myInternalFrame.setMaximizable(true);
        myInternalFrame.setIconifiable(true);
        myInternalFrame.setSize(200, 200);
        myInternalFrame.setVisible(true);
        return myInternalFrame;
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Internal Frames Example");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 600);
        myFrame.setLocationRelativeTo(null);
        JDesktopPane myDesktop = new JDesktopPane();
        myFrame.setContentPane(myDesktop);
        JInternalFrame myInternalFrame = createFrame("Internal Frame 1");
        myInternalFrame.setLocation(80, 200);
        myDesktop.add(myInternalFrame);
        myInternalFrame = createFrame("Internal Frame 2");
        myInternalFrame.setLocation(300, 200);
        myDesktop.add(myInternalFrame);
        myFrame.setVisible(true);
    }
}

/*
JInternalFrame: là các cửa sổ con nằm trong JFrame

Các bước tạo JInternalFrame:
1. Tạo JFrame
2. Tạo JDesktopPane (là khung chứa các JInternalFrame)
3. setContentPane(myDesktop) cho JFrame
4. Tạo JInternalFrame
5. add JInternalFrame vào JDesktopPane
6. Hiển thị JFrame
*/