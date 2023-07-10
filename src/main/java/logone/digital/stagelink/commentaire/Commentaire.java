package logone.digital.stagelink.commentaire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import logone.digital.stagelink.forum.Forum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "commentaires")
public class Commentaire implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String message;
    @JsonIgnore
    @ManyToOne
    private Forum forum;
}
