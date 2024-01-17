package logone.digital.stagelink.stage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StageRepository extends JpaRepository<StageEntity, Long> {
    Optional<StageEntity> findBytitreStage(String titreStage);
    List<StageEntity> findByEntreprise_Email(String email);


}
