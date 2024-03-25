package logone.digital.stagelink.sendEmail;

import logone.digital.stagelink.etudiant.EtudiantDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SendEmailController {

    @Autowired
    private  SendEmailService sendEmailService;

    @PostMapping("/sendEmail/{email}")
    public  String sendEmail(@PathVariable  String email, @RequestBody ModelEmail modelEmail){
    sendEmailService.sendEmail(email, modelEmail);
        return "Successfully sent the email !!";
    }


}
