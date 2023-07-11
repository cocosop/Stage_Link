package logone.digital.stagelink.utilisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private Long id;

    @Column
    private String nom;

    @Column
    private String telephone;

    @Column
    private  String email;

    @Column
    private String adresse;

    @Column
    private String mot_de_passe;

    @Column
    private Instant dateInscription;

    /*@JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private Set<BlogEntity> blog;*/


}
