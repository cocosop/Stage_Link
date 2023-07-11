package logone.digital.stagelink.utilisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import logone.digital.stagelink.forum.Forum;
import logone.digital.stagelink.postulation.PostulationEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_utilisateur")
@Builder
public class UtilisateurEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected String nom;

    @Column
    protected String telephone;

    @Column
    protected   String email;

    @Column
    protected String adresse;

    @Column
    protected String motDePasse;

    @Column
    protected Instant dateInscription;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    protected Set<Forum> forum;


}
