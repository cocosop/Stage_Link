package logone.digital.stagelink.stage;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import logone.digital.stagelink.entreprise.EntrepriseRepository;
import logone.digital.stagelink.entreprise.NoSuchEntrepriseExistException;
import logone.digital.stagelink.postulation.PostulationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StageService implements IStageService {
    final StageRepository stageRepository;
    final StageMapper stageMapper;
    final EntrepriseRepository entrepriseRepository;
    final PostulationRepository postulationRepository;


    @Override
    public StageDtoResponse create(StageDtoRequest stage) {
        StageEntity stage1 = this.stageMapper.stageDtoVersStage(stage);
        EntrepriseEntity entrepriseEntity = this.entrepriseRepository.findByEmail(stage.getEmail())
                .orElseThrow(()-> new NoSuchEntrepriseExistException());
        stage1.setEntreprise(entrepriseEntity);
        System.out.println(stage.getEmail());
        return this.stageMapper.stageVersStageDto(this.stageRepository.save(stage1));
    }

    @Override
    public List<StageDtoResponse> readAll() {
        List<StageEntity> stage = (List<StageEntity>) this.stageRepository.findAll();
        List<StageDtoResponse> stageDtoResponses = new ArrayList<>();
        stage.forEach(stage1 -> stageDtoResponses.add(this.stageMapper.stageVersStageDto(stage1)));
        return stageDtoResponses;
    }



    @Override
    public void deleteOneById(Long idStage) {
        stageRepository.deleteById(idStage);
    }

    @Override
    public StageDtoResponse update(StageDtoRequest stage, Long idStage) {
        try {
            // Recherche l'entité par email
            StageEntity stageEntity = this.stageRepository.findById(idStage)
                    .orElseThrow(() -> new Error("This stage with this " + idStage + " doesn't exist in our data base"));
            // Mappe la requête sur l'entité
            StageEntity stage1 = this.stageMapper.stageDtoVersStage(stage);
            stage1.setIdStage(stageEntity.getIdStage());
            stage1.setEntreprise(stageEntity.getEntreprise());
            // Sauvegarde l'entité modifiée
            return this.stageMapper.stageVersStageDto(this.stageRepository.save(stage1));
        }catch (Exception e){
            //Relance les exceptions
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public StageDtoResponse readOneById(Long idStage) {
        return this.stageMapper.stageVersStageDto(stageRepository.findById(idStage)
                .orElseThrow(()->new NoSuchElementException("this stage not exist")));
    }
    @Override
    public List <StageDtoResponse> getAllStagesByNomEntreprise(String email) {
        List<StageEntity> stage = (List<StageEntity>) this.stageRepository.findByEntreprise_Email(email);
        List<StageDtoResponse> stageDtoResponses = new ArrayList<>();
        stage.forEach(stage1 -> stageDtoResponses.add(this.stageMapper.stageVersStageDto(stage1)));
        return stageDtoResponses;
    }


}

