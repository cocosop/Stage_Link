package logone.digital.stagelink.sendEmail;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelEmail {
    private String subject;
    private String message;
}
