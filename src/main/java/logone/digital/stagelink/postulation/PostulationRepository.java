package logone.digital.stagelink.postulation;


import logone.digital.stagelink.entreprise.EntrepriseEntity;
import logone.digital.stagelink.etudiant.EtudiantEntity;
import logone.digital.stagelink.stage.StageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostulationRepository extends JpaRepository<PostulationEntity,Long> {
    List<PostulationEntity> findAllByStage_TitreStage(String titreStage);
    Optional<PostulationEntity> findByIdPostulation(Long idPostulation);

    List<PostulationEntity> findByEtudiant_Email(String email);

//    @Query(value = "SELECT * FROM _postulation WHERE `email` =:email AND `titre_stage` =:titreStage", nativeQuery = true)
//    List<PostulationEntity> findByEmailAndTitre(@Param("email")  String email,  @Param("titreStage") String titreStage);

    @Query(value = "SELECT COUNT(*) FROM `_postulation` p WHERE p.`id_stage` = :idStage ", nativeQuery = true)
    Long countAllByStage_IdStage(@Param("idStage") Long idStage);
}

