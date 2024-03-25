package logone.digital.stagelink.sendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void  sendEmail(String email, ModelEmail modelEmail){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("your-email@example.com");
        simpleMailMessage.setTo(fromEmail);
        simpleMailMessage.setSubject(modelEmail.getSubject());
        simpleMailMessage.setText(modelEmail.getMessage());
        simpleMailMessage.setTo(email);

        mailSender.send(simpleMailMessage);
    }
}
