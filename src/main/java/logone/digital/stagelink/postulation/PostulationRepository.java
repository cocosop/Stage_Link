package logone.digital.stagelink.postulation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulationRepository extends JpaRepository<PostulationEntity,Long> {
}

