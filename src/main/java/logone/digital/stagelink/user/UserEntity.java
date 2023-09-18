package logone.digital.stagelink.user;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
@Builder
public class UserEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "numéro-de-telephone")
    private String telephone;

    @NaturalId(mutable = true)
    @Column(name = "email")
    private String email;

    @Column
    private String adresse;

    @Column(name = "mot-de-passe")
    private String motDePasse;

    @Column
    private Instant dateInscription;

    @Column(name = "etat-compte")
    private boolean active;

    @Column(name = "roles")
    private String roles;

}
