package logone.digital.stagelink.entreprise;

import logone.digital.stagelink.stage.StageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntrepriseRepository extends CrudRepository<EntrepriseEntity, Long> {

      Optional<EntrepriseEntity> findByEmail(String email);
      Optional<EntrepriseEntity> findByNomEntreprise(String nomEntreprise);


      void  deleteByEmail(String email);
}
