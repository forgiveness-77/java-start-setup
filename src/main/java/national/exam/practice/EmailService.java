package national.exam.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendTestEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("peacelove.4orgiveness@gmail.com");
        message.setTo("fpeacelove77@gmail.com"); // Send a test to yourself
        message.setSubject("Test Email from Spring Boot");
        message.setText("Hello! This is a test email sent via Gmail SMTP.");

        mailSender.send(message);
        System.out.println("Email sent successfully!");
    }
}