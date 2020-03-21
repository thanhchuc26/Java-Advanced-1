/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session05_baitap;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author June
 */
public class session05_baitap01 extends JFrame {

    JPanel mainPanel;
    JList<String> listBatch;
    JSplitPane splitPaneData;
    JTextArea listStudentInformation;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Show student information");
        setSize(430, 450);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel();
    }

    void create_and_add_splitPaneData_to_mainPanel() throws ClassNotFoundException, SQLException {
        splitPaneData = new JSplitPane();
        listBatch = new JList<>(getListBatchName());
        listStudentInformation = new JTextArea();
        JScrollPane jScrollPane1 = new JScrollPane();
        JScrollPane jScrollPane2 = new JScrollPane();
        listStudentInformation.setEditable(false);
        jScrollPane1.setViewportView(listBatch);
        splitPaneData.setLeftComponent(jScrollPane1);
        listStudentInformation.setColumns(30);
        listStudentInformation.setRows(5);
        jScrollPane2.setViewportView(listStudentInformation);
        splitPaneData.setRightComponent(jScrollPane2);
        splitPaneData.setOneTouchExpandable(true);
        splitPaneData.setDividerLocation(70);
        splitPaneData.setPreferredSize(new Dimension(400, 400));
        mainPanel.add(splitPaneData);

        listBatch.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                String[] listStudent;
                try {
                    listStudent = getListStudent(listBatch.getSelectedValue());
                    listStudentInformation.setText("");
                    for (int i = 0; i < listStudent.length; i++) {
                        listStudentInformation.append(listStudent[i]);
                        listStudentInformation.append("\n");

                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(session05_baitap01.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        listBatch.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if ((ke.getKeyCode() == 38) || (ke.getKeyCode() == 40)) {
                    String[] listStudent;
                    try {
                        listStudent = getListStudent(listBatch.getSelectedValue());
                        listStudentInformation.setText("");
                        for (int i = 0; i < listStudent.length; i++) {
                            listStudentInformation.append(listStudent[i]);
                            listStudentInformation.append("\n");

                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(session05_baitap01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    void addMainPanel_to_JFrame() {
        add(this.mainPanel);
    }

    void displayJFrame() {
        setVisible(true);
    }

    String[] getListBatchName() throws ClassNotFoundException, SQLException {
        Connection conn;
        Statement stmt;
        String[] listBatchName;

        Class.forName(database.JDBC_DRIVER);
        conn = DriverManager.getConnection(database.DB_URL + database.DATABASENAME + database.USER + database.PASS);
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "SELECT batch FROM student group by batch";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            rs.last();
            listBatchName = new String[rs.getRow()];
            int i = -1;
            rs.beforeFirst();
            while (rs.next()) {
                i++;
                listBatchName[i] = rs.getString("batch");
            }
        }
        stmt.close();
        conn.close();
        return listBatchName;
    }

    String[] getListStudent(String batchName) throws ClassNotFoundException, SQLException {
        Connection conn;
        String[] listStudent;

        Class.forName(database.JDBC_DRIVER);
        conn = DriverManager.getConnection(database.DB_URL + database.DATABASENAME + database.USER + database.PASS);
        String sql = "SELECT studentid, name FROM student where batch like ?";
        PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstmt.setString(1, batchName);
        try (ResultSet rs = pstmt.executeQuery()) {
            rs.last();
            listStudent = new String[rs.getRow()];
            int i = -1;
            rs.beforeFirst();
            while (rs.next()) {
                i++;
                listStudent[i] = rs.getString("studentid") + "\t" + rs.getString("name");
            }
        }
        conn.close();
        return listStudent;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        session05_baitap01 showData = new session05_baitap01();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        showData.create_JFrame();
        showData.create_mainPanel();
        showData.create_and_add_splitPaneData_to_mainPanel();
        showData.addMainPanel_to_JFrame();
        showData.displayJFrame();
    }
}
