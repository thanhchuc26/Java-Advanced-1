/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import java.awt.*;
import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

/**
 *
 * @author June
 */
public class create_JFrame_with_Uniform_Translucency extends JFrame {

    public create_JFrame_with_Uniform_Translucency() {
        super("TranslucentWindow");
        setLayout(new GridBagLayout());

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a sample button.
        add(new JButton("I am a Button"));
    }

    public static void main(String[] args) {
        // Determine if the GraphicsDevice supports translucency.
        GraphicsEnvironment ge
                = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        //If translucent windows aren't supported, exit.
        if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
            System.err.println(
                    "Translucency is not supported");
            System.exit(0);
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                create_JFrame_with_Uniform_Translucency myUniformTranslucency = new create_JFrame_with_Uniform_Translucency();

                // Set the window to 55% opaque (45% translucent).
                myUniformTranslucency.setOpacity(0.55f);

                // Display the window.
                myUniformTranslucency.setVisible(true);
            }
        });
    }
}
