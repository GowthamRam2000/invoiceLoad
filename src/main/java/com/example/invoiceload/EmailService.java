import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Service
public class EmailService {
    // Constants for email server connection
    private static final String HOST = "outlook.office365.com";
    private static final String USERNAME = "your-email@example.com";
    private static final String PASSWORD = "your-password";
    private static final String FOLDER = "inbox";
    private static final String DOWNLOAD_FOLDER = "your-download-folder/";

    // Method to download attachments and move messages to trash
    public void downloadAndMoveToTrash() throws MessagingException, IOException {
        // ... (see below)
    }

    // Method to download attachments from an email message
    private void downloadAttachments(Message message) throws MessagingException, IOException {
        // ... (see below)
    }

    // Method to move a message to the trash folder
    private void moveToTrash(Message message, Folder sourceFolder, Folder trashFolder) throws MessagingException {
        // ... (see below)
    }
}
