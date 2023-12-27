package logone.digital.stagelink.stage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StageRepository extends JpaRepository<StageEntity, Long> {
//    Optional<StageEntity> findById(Long id);


    @Query(value = "SELECT * FROM _stage WHERE nom_entreprise =:nom", nativeQuery = true)
    StageEntity findStagesByNomEntreprise(@Param("nom") String nomEntreprise);

}
