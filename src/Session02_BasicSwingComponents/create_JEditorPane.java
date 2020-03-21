/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session02_BasicSwingComponents;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

/**
 *
 * @author June
 */
public class create_JEditorPane extends JFrame {

    private JTextField urlValue;
    private JEditorPane contents;

    public create_JEditorPane() {
        super("Web Browser");
        Container conObj = getContentPane();
        urlValue = new JTextField("Enter URL here");
        urlValue.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPages(e.getActionCommand());
            }
        });
        conObj.add(urlValue, BorderLayout.NORTH);
        contents = new JEditorPane();
        contents.setEditable(false);
        contents.addHyperlinkListener(
                new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    getPages(e.getURL().toString());
                }
                if (e instanceof HTMLFrameHyperlinkEvent) {
                    HTMLFrameHyperlinkEvent evt
                            = (HTMLFrameHyperlinkEvent) e;
                    HTMLDocument doc = (HTMLDocument) contents.getDocument();
                    doc.processHTMLFrameHyperlinkEvent(evt);
                } else {
                    try {
                        contents.setPage(e.getURL());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        conObj.add(new JScrollPane(contents),
                BorderLayout.CENTER);
        setSize(400, 300);
        setVisible(true);
    }

    private void getPages(String location) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            contents.setPage(location);
            urlValue.setText(location);
        } catch (IOException io) {
            JOptionPane.showMessageDialog(this, "Error retrieving data from the specified URL site", "Check URL", JOptionPane.ERROR_MESSAGE);
        }
        setCursor(Cursor.getPredefinedCursor(
                Cursor.DEFAULT_CURSOR));
    }

    public static void main(String args[]) {
        create_JEditorPane urlObj = new create_JEditorPane();
        urlObj.addWindowListener(
                new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
