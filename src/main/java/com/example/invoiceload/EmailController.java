package com.example.invoiceload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/downloadAndMoveToTrash")
    public String downloadAndMoveToTrash() {
        try {
            emailService.downloadAndMoveToTrash();
            return "Emails downloaded and moved to trash successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}