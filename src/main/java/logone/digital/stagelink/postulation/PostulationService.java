package logone.digital.stagelink.postulation;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import logone.digital.stagelink.etudiant.*;
import logone.digital.stagelink.stage.NoSuchStageExistException;
import logone.digital.stagelink.stage.StageEntity;
import logone.digital.stagelink.stage.StageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

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


    public Instant generateDate(){
        Instant today = Instant.now();
        return  today;
    }
    public String generateStatut(){
        String statut = "Encours";
        return  statut;
    }

    @Override
    public PostulationDtoResponse create(PostulationDtoRequest postulation) {
        PostulationEntity postulation1 = this.postulationMapper.postulationDtoVersPostulation(postulation);
        EtudiantEntity etudiantEntity = this.etudiantRepository.findByEmail(postulation.getEmail())
                .orElseThrow(()->new NoSuchEtudiantExistException());
        StageEntity stageEntity = this.stageRepository.findById(postulation.getIdStage())
                .orElseThrow(()->new NoSuchStageExistException());
        postulation1.setDatePostulation(this.generateDate());
        postulation1.setStatut(this.generateStatut());
        postulation1.setStage(stageEntity);
        postulation1.setEtudiant(etudiantEntity);
        return this.postulationMapper.postulationVersPostulationDto(this.postulationRepository.save(postulation1));
    }




    @Override
    public PostulationDtoResponse update(PostulationDtoRequest postulation,Long idPostulation) throws EtudiantAlreadyExistException {
        try {

            PostulationEntity postulationEntity = this.postulationRepository.findByIdPostulation(idPostulation)
                    .orElseThrow(() -> new Error("The postulation with this " + idPostulation + " doesn't exist in our data base"));
            // Mappe la requête sur l'entité
            PostulationEntity postulation1 = this.postulationMapper.postulationDtoVersPostulation(postulation);
            // Conserve l'id, les rôles et le statut de l'entité originale
            postulation1.setIdPostulation(postulationEntity.getIdPostulation());
            postulation1.setDatePostulation(postulationEntity.getDatePostulation());
            postulation1.setEtudiant(postulationEntity.getEtudiant());
            postulation1.setStage(postulationEntity.getStage());
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
    public List<PostulationDtoResponse> getAllPostulationByEmail(String email) {
        List<PostulationEntity> postulation =  this.postulationRepository.findByEtudiant_Email(email);
        List<PostulationDtoResponse> postulationDtoResponses = new ArrayList<>();
        postulation.forEach(postulation1 -> postulationDtoResponses.add(this.postulationMapper.postulationVersPostulationDto(postulation1)));
        return postulationDtoResponses;
    }

    @Override
    public  List<PostulationDtoResponse> getAllPostulationByTitreStage(String titreStage) {
        List<PostulationEntity> postulation =  this.postulationRepository.findAllByStage_TitreStage(titreStage);
        List<PostulationDtoResponse> postulationDtoResponses = new ArrayList<>();
        postulation.forEach(postulation1 -> postulationDtoResponses.add(this.postulationMapper.postulationVersPostulationDto(postulation1)));
        return postulationDtoResponses;
    }

//    @Override
//    public  List<PostulationDtoResponse> getAllNbrePostulation(Long idStages) {
//        List<PostulationEntity> postulation =  this.postulationRepository.countAllByStage_IdStage(idStages);
//        List<PostulationDtoResponse> postulationDtoResponses = new ArrayList<>();
//        postulation.forEach(postulation1 -> postulationDtoResponses.add(this.postulationMapper.postulationVersPostulationDto(postulation1)));
//        return postulationDtoResponses;
//    }
//    @Override
//    public  List<PostulationDtoResponse> getAllPostulationById(Long idPostulation) {
//        Optional<PostulationEntity> postulation =  this.postulationRepository.findByIdPostulation(idPostulation);
//        List<PostulationDtoResponse> postulationDtoResponses = new ArrayList<>();
//        postulation.forEach(postulation1 -> postulationDtoResponses.add(this.postulationMapper.postulationVersPostulationDto(postulation1)));
//        return postulationDtoResponses;
//    }

    @Override
    public PostulationDtoResponse readOneById(Long idPostulation) {
        try {
            return this.postulationMapper.postulationVersPostulationDto(this.postulationRepository.findByIdPostulation(idPostulation).get());
        }catch (Exception ex){
            throw new PostulationAlreadyExistsException("This email " +idPostulation+ " doesn't exist in our data base");
        }
    }

}


