/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session08_Networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author June
 */
public class getExchangeRate extends javax.swing.JFrame {

    /**
     * Creates new form getExchangeRate
     */
    static Vector<String> headerTableExchangeRate = null;
    static Vector<String> dataTableExchangeRate = null;

    public getExchangeRate() {
        initComponents();
    }

    static Vector<String> getExchangeRateVCB() throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        Vector data = new Vector();
        URL url = new URL("https://www.vietcombank.com.vn/ExchangeRates/ExrateXML.aspx");
        URLConnection uRLConnection = url.openConnection();
        InputStream inputStream = uRLConnection.getInputStream();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder buider = factory.newDocumentBuilder();
        Document doc = (Document) buider.parse(inputStream);
        Element exchangeRates = doc.getDocumentElement();
        NodeList exchangeRateList = exchangeRates.getElementsByTagName("Exrate");
        lblUpdateTimeAndSource.setText("Update time: " + exchangeRates.getElementsByTagName("DateTime").item(0).getTextContent() + ". Source: " + exchangeRates.getElementsByTagName("Source").item(0).getTextContent());
        for (int i = 0; i < exchangeRateList.getLength(); i++) {
            Vector<String> temp = new Vector<>();
            Node node = exchangeRateList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element exchangeRate = (Element) node;
                temp.add(exchangeRate.getAttribute("CurrencyCode"));
                temp.add(exchangeRate.getAttribute("CurrencyName"));
                temp.add(exchangeRate.getAttribute("Buy"));
                temp.add(exchangeRate.getAttribute("Transfer"));
                temp.add(exchangeRate.getAttribute("Sell"));
                data.add(temp);
            }
        }
        return data;
    }

    static void createTableExchangeRateHeader() {
        headerTableExchangeRate = new Vector<>();
        headerTableExchangeRate.add("Mã ngoại tệ");
        headerTableExchangeRate.add("Tên ngoại tệ");
        headerTableExchangeRate.add("Mua tiền mặt");
        headerTableExchangeRate.add("Mua chuyển khoản");
        headerTableExchangeRate.add("Bán");
    }

    static void createTableExchangeRateData_VCB() throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        dataTableExchangeRate = new Vector<>();
        dataTableExchangeRate = getExchangeRateVCB();
    }

    static void loadDataTableExchangeRate() {
        DefaultTableModel model = new DefaultTableModel(dataTableExchangeRate, headerTableExchangeRate);
        tblExchangeRate.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExchangeRate = new javax.swing.JTable();
        lblUpdateTimeAndSource = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Load exchange rate VCB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblExchangeRate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblExchangeRate);

        lblUpdateTimeAndSource.setText("Update time and source");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(lblUpdateTimeAndSource))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUpdateTimeAndSource)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            createTableExchangeRateHeader();
            createTableExchangeRateData_VCB();
            loadDataTableExchangeRate();
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(getExchangeRate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getExchangeRate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(getExchangeRate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(getExchangeRate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(getExchangeRate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new getExchangeRate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lblUpdateTimeAndSource;
    private static javax.swing.JTable tblExchangeRate;
    // End of variables declaration//GEN-END:variables
}