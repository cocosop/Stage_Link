package logone.digital.stagelink.etudiant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import logone.digital.stagelink.postulation.PostulationEntity;
import logone.digital.stagelink.stage.StageEntity;
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
@Table(name = "_etudiant")
@Builder
public class EtudiantEntity implements Serializable {

        @Serial
        private static final  long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

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



        @JsonIgnore
        @ManyToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
        private Set<StageEntity> stageEntities;

        @JsonIgnore
        @OneToMany(mappedBy = "etudiant")
        private Set<PostulationEntity> postulationEntities;


}
