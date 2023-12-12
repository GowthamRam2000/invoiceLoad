import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Service
public class EmailService {

    private static final String HOST = "outlook.office365.com";
    private static final String USERNAME = "your-email@example.com";
    private static final String PASSWORD = "your-password";
    private static final String FOLDER = "inbox";
    private static final String DOWNLOAD_FOLDER = "your-download-folder/";

    public void downloadAndMoveToTrash() throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");

        Session session = Session.getDefaultInstance(properties, null);
        Store store = session.getStore();
        store.connect(HOST, USERNAME, PASSWORD);

        Folder emailFolder = store.getFolder(FOLDER);
        emailFolder.open(Folder.READ_WRITE);

        Message[] messages = emailFolder.getMessages();
        for (Message message : messages) {
            downloadAttachments(message);
            moveToTrash(message);
        }

        emailFolder.close(true);
        store.close();
    }

    private void downloadAttachments(Message message) throws MessagingException, IOException {
        Multipart multipart = (Multipart) message.getContent();
        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);
            if (bodyPart instanceof MimeBodyPart) {
                MimeBodyPart mimeBodyPart = (MimeBodyPart) bodyPart;
                if (Part.ATTACHMENT.equalsIgnoreCase(mimeBodyPart.getDisposition())) {
                    String fileName = mimeBodyPart.getFileName();
                    mimeBodyPart.saveFile(new File(DOWNLOAD_FOLDER + fileName));
                }
            }
        }
    }

    private void moveToTrash(Message message) throws MessagingException {
         private void moveToTrash(Message message) throws MessagingException {
    // Mark the message as deleted
    message.setFlag(Flags.Flag.DELETED, true);
}
}

