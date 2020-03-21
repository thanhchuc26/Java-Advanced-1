/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session10_JavaMail;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author June
 */
public class replyEmail {

    static String hostIMAP = "imap.gmail.com";// change accordingly
    static String mailStoreTypeIMAP = "imap";
    static String username = "CraigLConner1";// change accordingly
    static String password = "CraigLConner11823";// change accordingly
    static String replyTo = "CraigLConner1@gmail.com";
    static Store store;
    static Folder emailFolder;
    static Message[] messages;
    static String smtpServer = "smtp.gmail.com";

    public static void read_EmailIMAP(String hostIMAP, String mailStoreTypeIMAP, String username, String password) throws NoSuchProviderException, MessagingException {
        //create properties field
        Properties properties = new Properties();

        properties.put("mail.imap.host", hostIMAP);
        properties.put("mail.imap.port", "993");
        //properties.put("mail.pop3.starttls.enable", "true");
        properties.put("mail.imap.startssl.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);
        //create the IMAP store object and connect with the pop server
        store = emailSession.getStore("imaps");
        store.connect(hostIMAP, username, password);
        //create the folder object and open it
        emailFolder = store.getFolder("Inbox");
        // Folder emailFolder = store.getFolder("[Gmail]/Sent Mail");
        emailFolder.open(Folder.READ_ONLY);
        messages = emailFolder.getMessages();
    }

    static void replyEmail(String replyTo) throws MessagingException, IOException {
        System.out.println("Replying to " + replyTo);
        read_EmailIMAP(hostIMAP, mailStoreTypeIMAP, username, password);
        for (int i = 0, n = messages.length; i < n; i++) {
            Message message = messages[i];
            if (message.getFrom()[0].toString().toLowerCase().contains(replyTo.toLowerCase())) {
                replyTo = InternetAddress.toString(message.getReplyTo());
                Properties props = System.getProperties();
                props.put("mail.smtp.host", smtpServer);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.starttls.enable", "true");
                final String login = username;
                final String pwd = password;
                Authenticator pa = null;
                if (login != null && pwd != null) {
                    props.put("mail.smtp.auth", "true");
                    pa = new Authenticator() {

                        @Override
                        public PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(login, pwd);
                        }
                    };
                }//else: no authentication
                Session session = Session.getInstance(props, pa);
                // — Create a new message –
                Message msg = new MimeMessage(session);
                // — Set the FROM and TO fields –
                msg.setFrom(new InternetAddress(username));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(replyTo, false));
                msg.setReplyTo(InternetAddress.parse(replyTo, false));
                // — Set the subject and body text –
                String subject = "Reply: " + message.getSubject();
                msg.setSubject(subject);
                // Create your new message part  
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText("Orginal message:\n");
                // Create a multi-part to combine the parts  
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                // Create and fill part for the forwarded content  
                messageBodyPart = new MimeBodyPart();
                messageBodyPart.setDataHandler(message.getDataHandler());
                // Add part to multi part  
                multipart.addBodyPart(messageBodyPart);
                // Associate multi-part with message  
                msg.setContent(multipart);

                msg.setSentDate(new Date());
                msg.saveChanges();
                Transport.send(msg);
                System.out.println("Reply success");
                break;
            }
            //            System.out.println("---------------------------------");
            //            System.out.println("Email Number " + (i + 1));
            //            System.out.println("Subject: " + message.getSubject());
            //            System.out.println("From: " + message.getFrom()[0]);
            //            System.out.println("Text: " + message.getContent().toString());
        }

        emailFolder.close(false);
        store.close();
    }

    public static void main(String[] args) throws MessagingException, IOException {
        replyEmail(replyTo);
    }
}
