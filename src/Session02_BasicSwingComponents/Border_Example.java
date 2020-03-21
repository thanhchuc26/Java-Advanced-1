/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author June
 */
public class Border_Example extends JFrame {

    JPanel mainPanel;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Border Example");
        setSize(580, 480);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel();
    }

    void emptyBorder() {
        JLabel lbl = new JLabel("Empty border", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        JPanel subPanel = new JPanel();
//        subPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        subPanel.setBorder(BorderFactory.createEmptyBorder());
        subPanel.add(lbl);
        mainPanel.add(subPanel);
    }

    void lineBorder() {
        JLabel lbl = new JLabel("Line border", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        JPanel subPanel = new JPanel();
        subPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
    }

    void etchedRaisedBorder() {
        JLabel lbl = new JLabel("Etched raised border", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        JPanel subPanel = new JPanel();
        subPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
    }

    void etchedLoweredBorder() {
        JLabel lbl = new JLabel("Etched lowered border", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        JPanel subPanel = new JPanel();
        subPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
    }

    void bevelRaisedBorder() {
        JLabel lbl = new JLabel("Bevel raised border", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        JPanel subPanel = new JPanel();
        subPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
    }

    void bevelLoweredBorder() {
        JLabel lbl = new JLabel("Bevel lowered border", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        JPanel subPanel = new JPanel();
        subPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
    }

    void titleBorder() {
        Border titleBorder;
        Border greenBorder = BorderFactory.createLineBorder(Color.green);
        // Default title border
        JLabel lbl = new JLabel("Default title border", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        JPanel subPanel = new JPanel();
        subPanel.setBorder(BorderFactory.createTitledBorder("Title"));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
        
        // Default title border with green border
        lbl = new JLabel("Default title border with green border", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        subPanel = new JPanel();
         titleBorder = BorderFactory.createTitledBorder(greenBorder, "title");
        subPanel.setBorder(BorderFactory.createTitledBorder(titleBorder, "Title"));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
        
        // Title border center just and default position
        lbl = new JLabel("Title border center just and default prsition", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        subPanel = new JPanel();
        titleBorder = BorderFactory.createTitledBorder(greenBorder, "Title",TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        subPanel.setBorder(BorderFactory.createTitledBorder(titleBorder, ""));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
        
        // Title border center just and above top
        lbl = new JLabel("Title border center just and above top", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        subPanel = new JPanel();
        titleBorder = BorderFactory.createTitledBorder(null, "Title",TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
        subPanel.setBorder(BorderFactory.createTitledBorder(titleBorder, ""));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
        
        // Title border right just and below top
        lbl = new JLabel("Title border right just and below top", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        subPanel = new JPanel();
        titleBorder = BorderFactory.createTitledBorder(null, "Title",TitledBorder.RIGHT, TitledBorder.BELOW_TOP);
        subPanel.setBorder(BorderFactory.createTitledBorder(titleBorder, ""));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
        
        // Title border default just and below bottom
        lbl = new JLabel("Title border default just and below bottom", JLabel.CENTER);
        lbl.setPreferredSize(new Dimension(250, 30));
        subPanel = new JPanel();
        titleBorder = BorderFactory.createTitledBorder(null, "Title",TitledBorder.DEFAULT_POSITION, TitledBorder.BELOW_BOTTOM);
        subPanel.setBorder(BorderFactory.createTitledBorder(titleBorder, ""));
        subPanel.add(lbl);
        mainPanel.add(subPanel);
    }

    void addMainPanel_to_JFrame() {
        add(mainPanel);
    }

    void displayJFrame() {
        setVisible(true);
    }

    public static void main(String[] args) {
        Border_Example borderExample = new Border_Example();
        borderExample.create_JFrame();
        borderExample.create_mainPanel();
        borderExample.emptyBorder();
        borderExample.lineBorder();
        borderExample.etchedRaisedBorder();
        borderExample.etchedLoweredBorder();
        borderExample.bevelRaisedBorder();
        borderExample.bevelLoweredBorder();
        borderExample.titleBorder();
        borderExample.addMainPanel_to_JFrame();
        borderExample.displayJFrame();
    }
}

/*
– Empty border là border trống, nó thường được dùng để tạo khoảng trống, 
công dụng như sử dụng padding để đặt khoảng cách giữa nội dung và bên ngoài.
– Line border là loại border nét liền với màu sắc nào đó.
– Raised etched border là dạng border nét nổi, khắc nổi lên trên.
– Lowered etched border là border khắc nhưng chìm xuống dưới.
– Raised bevel border là border dạng tạo góc xiên nổi lên.
– Lowered bevel border là border dạng tạo góc chìm xuống.
Title Border là dạng border có tiêu đề. Bạn có thể đặt tiêu đề ở trái, phải, giữa, trên dưới border,…
Ngoài ra bạn còn có thể đặt cái border là một trong các dạng border nào đó mà đã được tạo ra, 
nếu không thì mặc định border sẽ là màu blue mờ mờ.
 */
