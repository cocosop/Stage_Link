package logone.digital.stagelink.entreprise;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import logone.digital.stagelink.stage.StageEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_entreprise")
@Builder
public class EntrepriseEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String responsable;


    @JsonIgnore
    @OneToMany(mappedBy = "entreprise1", cascade = CascadeType.ALL)
    private Set<StageEntity> stage;


}
