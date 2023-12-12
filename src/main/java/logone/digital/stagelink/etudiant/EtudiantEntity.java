package logone.digital.stagelink.etudiant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import logone.digital.stagelink.postulation.PostulationEntity;
import logone.digital.stagelink.stage.StageEntity;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_etudiant")
@Builder
public class EtudiantEntity implements Serializable {

        @Serial
        private static final  long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nom_etudiant")
        private String nom;

        @Column
        private String prenom;

        @Column
        private String matricule;

        @Column
        private String competences;

        @Column
        private String interets;

        @Column
        private String parcoursAcademique;

        @Column(name = "numméro-de-telephone")
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
        private boolean statut;

        //@JsonIgnore
        @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
        private Set<StageEntity> stage;

        //@JsonIgnore
        @OneToMany(mappedBy = "etudiant2", cascade = CascadeType.ALL)
        private Set<PostulationEntity> postulation;




}
