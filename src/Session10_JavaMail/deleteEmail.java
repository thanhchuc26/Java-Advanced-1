/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session10_JavaMail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author June
 */
public class deleteEmail {

    static Message[] messages;
    static Folder emailFolder;
    static Store store;

    public static void read_EmailPOP3(String host, String storeType, String user, String password) {
        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
//            properties.put("mail.pop3.starttls.enable", "true");
            properties.put("mail.pop3.startssl.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            emailFolder = store.getFolder("inbox");
            emailFolder.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
            messages = emailFolder.getMessages();
//            System.out.println("messages.length---" + messages.length);
//            for (int i = 0, n = messages.length; i < n; i++) {
//                Message message = messages[i];
//                System.out.println("---------------------------------");
//                System.out.println("Email Number " + (i + 1));
//                System.out.println("Subject: " + message.getSubject());
//                System.out.println("From: " + message.getFrom()[0]);
//                System.out.println("Text: " + message.getContent().toString());
//            }

            //close the store and folder objects
//            emailFolder.close(false);
//            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read_EmailIMAP(String host, String storeType, String user, String password) {
        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
//            properties.put("mail.pop3.starttls.enable", "true");
            properties.put("mail.imap.startssl.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            //create the folder object and open it
            emailFolder = store.getFolder("Inbox");
//            Folder emailFolder = store.getFolder("[Gmail]/Sent Mail");
            emailFolder.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
            messages = emailFolder.getMessages();
//            System.out.println("messages.length---" + messages.length);

//            for (int i = 0, n = messages.length; i < n; i++) {
//                Message message = messages[i];
//                System.out.println("---------------------------------");
//                System.out.println("Email Number " + (i + 1));
//                System.out.println("Subject: " + message.getSubject());
//                System.out.println("From: " + message.getFrom()[0]);
//                System.out.println("Text: " + message.getContent().toString());
//
//            }

            //close the store and folder objects
//            emailFolder.close(false);
//            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleEmailPOP3BySubject(String hostPOP3, String mailStoreTypePOP3, String username, String password, String subjectToDelete) {
        System.out.println("Deletting email with subject " + subjectToDelete + "...");
        read_EmailPOP3(hostPOP3, mailStoreTypePOP3, username, password);
        for (int i = 0, n = messages.length; i < n; i++) {
            Message message = messages[i];
            try {
                String messageSubject = message.getSubject();
                if (messageSubject.contains(subjectToDelete)) {
                    //Marked DELETE for message
                    message.setFlag(Flags.Flag.DELETED, true);
                    // DELETE message
                    boolean expunge = true;
                    emailFolder.close(expunge);
                    // another way:
                    //emailFolder.expunge();
                    //emailFolder.close(false);
                    System.out.println("Delete email with subject " + subjectToDelete + " success");
                    break;
                }
            } catch (MessagingException ex) {
                Logger.getLogger(deleteEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            // disconnect
            store.close();
        } catch (MessagingException ex) {
            Logger.getLogger(deleteEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void deleEmailIMAPBySubject(String hostIMAP, String mailStoreTypeIMAP, String username, String password, String subjectToDelete) {
        System.out.println("Deletting email with subject " + subjectToDelete + "...");
        read_EmailIMAP(hostIMAP, mailStoreTypeIMAP, username, password);
        for (int i = 0, n = messages.length; i < n; i++) {
            Message message = messages[i];
            try {
                String messageSubject = message.getSubject();
                if (messageSubject.contains(subjectToDelete)) {
                    //Marked DELETE for message
                    message.setFlag(Flags.Flag.DELETED, true);
                    // DELETE message
                    boolean expunge = true;
                    emailFolder.close(expunge);
                    // another way:
                    //emailFolder.expunge();
                    //emailFolder.close(false);
                    System.out.println("Delete email with subject " + subjectToDelete + " success");
                    break;
                }
            } catch (MessagingException ex) {
                Logger.getLogger(deleteEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            // disconnect
            store.close();
        } catch (MessagingException ex) {
            Logger.getLogger(deleteEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        String hostPOP3 = "pop.gmail.com";// change accordingly
        String mailStoreTypePOP3 = "pop3";
        String hostIMAP = "imap.gmail.com";// change accordingly
        String mailStoreTypeIMAP = "imap";
        String username = "CraigLConner1";// change accordingly
        String password = "CraigLConner11823";// change accordingly
        String subjectToDelete = "Help us protect you: Security advice from Google";
//        deleEmailPOP3BySubject(hostPOP3, mailStoreTypePOP3, username, password, subjectToDelete);
        deleEmailIMAPBySubject(hostIMAP, mailStoreTypeIMAP, username, password, subjectToDelete);
    }
}
