package logone.digital.stagelink.stage;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import logone.digital.stagelink.entreprise.EntrepriseRepository;
import logone.digital.stagelink.entreprise.NoSuchEntrepriseExistException;
import logone.digital.stagelink.etudiant.EtudiantAlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StageService implements IStageService {
    final StageRepository stageRepository;
    final StageMapper stageMapper;
    final EntrepriseRepository entrepriseRepository;


    @Override
    public StageDtoResponse create(StageDtoRequest stage) {
        StageEntity stage1 = this.stageMapper.stageDtoVersStage(stage);
        EntrepriseEntity entrepriseEntity = this.entrepriseRepository.findByNomEntreprise(stage.getNomEntreprise())
                .orElseThrow(()-> new NoSuchEntrepriseExistException());
        stage1.setEntreprise(entrepriseEntity);
        System.out.println(stage.getNomEntreprise());
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
    public void deleteOneById(Long id) {
        stageRepository.deleteById(id);
    }

    @Override
    public StageDtoResponse update(StageDtoRequest stage, Long id) {
        try {
            // Recherche l'entité par email
            StageEntity stageEntity = this.stageRepository.findById(id)
                    .orElseThrow(() -> new Error("This stage with this " + id + " doesn't exist in our data base"));
            // Mappe la requête sur l'entité
            StageEntity stage1 = this.stageMapper.stageDtoVersStage(stage);
            stage1.setId(stageEntity.getId());
            // Sauvegarde l'entité modifiée
            return this.stageMapper.stageVersStageDto(this.stageRepository.save(stage1));
        }catch (Exception e){
            //Relance les exceptions
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public StageDtoResponse readOneById(Long id) {
        return this.stageMapper.stageVersStageDto(stageRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("this stage not exist")));
    }

    public StageDtoResponse getStagesByNomEntreprise(String nomEntreprise) {
        return this.stageMapper.stageVersStageDto(stageRepository.findStagesByNomEntreprise(nomEntreprise));
    }
}

