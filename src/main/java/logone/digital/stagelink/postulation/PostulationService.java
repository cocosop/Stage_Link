package logone.digital.stagelink.postulation;
import logone.digital.stagelink.etudiant.*;
import logone.digital.stagelink.stage.NoSuchStageExistException;
import logone.digital.stagelink.stage.StageEntity;
import logone.digital.stagelink.stage.StageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostulationService implements IPostulationService {
    final PostulationRepository postulationRepository;
    final PostulationMapper postulationMapper;
    final StageRepository stageRepository;
    final EtudiantRepository etudiantRepository;

    public String generateStatut(){
        String statut = "En cours";
        return  statut;
    }
    public Instant generateDate(){
        Instant today = Instant.now();
        return  today;
    }

    @Override
    public PostulationDtoResponse create(PostulationDtoRequest postulation) {
        PostulationEntity postulation1 = this.postulationMapper.postulationDtoVersPostulation(postulation);
        EtudiantEntity etudiantEntity = this.etudiantRepository.findByEmail(postulation.getEmail())
                .orElseThrow(()->new NoSuchEtudiantExistException());
        StageEntity stageEntity = this.stageRepository.findBytitreStage(postulation.getTitreStage())
                .orElseThrow(()->new NoSuchStageExistException());
        postulation1.setDatePostulation(this.generateDate());
        postulation1.setStatut(this.generateStatut());
        postulation1.setStage(stageEntity);
        postulation1.setEtudiant(etudiantEntity);
        return this.postulationMapper.postulationVersPostulationDto(this.postulationRepository.save(postulation1));
    }

    @Override
    public List<PostulationDtoResponse> readAll() {
        return null;
    }

    @Override
    public PostulationDtoResponse readOneById(Long id) {
        return null;
    }

    @Override
    public PostulationDtoResponse update(PostulationDtoRequest postulation) throws EtudiantAlreadyExistException {
        try {
            EtudiantEntity etudiantEntity = this.etudiantRepository.findByEmail(postulation.getEmail())
                    .orElseThrow(() -> new NoSuchEtudiantExistException());
            StageEntity stageEntity = this.stageRepository.findBytitreStage(postulation.getTitreStage())
                    .orElseThrow(() -> new NoSuchEtudiantExistException());
            Optional<PostulationEntity> postulationEntity =this.postulationRepository.findByIdPostulation(postulation.getIdPostulation());
            PostulationEntity postulation1 = this.postulationMapper.postulationDtoVersPostulation(postulation);
            // Conserve l'id, les rôles et le statut de l'entité originale
            postulation1.setIdPostulation(postulation1.getIdPostulation());
            postulation1.setDatePostulation(postulation1.getDatePostulation());
            postulation1.setEtudiant(etudiantEntity);
            postulation1.setStage(stageEntity);
            // Sauvegarde l'entité modifiée
            return this.postulationMapper.postulationVersPostulationDto(this.postulationRepository.save(postulation1));
        } catch (PostulationAlreadyExistsException e) {
            // Relance les exceptions personnalisées
            throw e;
        } catch (Exception e) {
            // Traite les autres exceptions
            e.printStackTrace();
            // Retourne null ou une réponse par défaut
            return null;
        }
    }

    @Override
    public void deleteOneById(Long idPostulation) {

    }

    @Override
    public List<PostulationDtoResponse> getAllPostulationByEmail(String email) {
        List<PostulationEntity> postulation =  this.postulationRepository.findByEtudiant_Email(email);
        List<PostulationDtoResponse> postulationDtoResponses = new ArrayList<>();
        postulation.forEach(postulation1 -> postulationDtoResponses.add(this.postulationMapper.postulationVersPostulationDto(postulation1)));
        return postulationDtoResponses;
    }


}


