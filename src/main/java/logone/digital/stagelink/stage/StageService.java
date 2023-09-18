package logone.digital.stagelink.stage;


import logone.digital.stagelink.etudiant.EtudiantAlreadyExistException;
import logone.digital.stagelink.etudiant.EtudiantDto;
import logone.digital.stagelink.etudiant.EtudiantEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StageService implements IStageService {
    final StageRepository stageRepository;


    @Override
    public StageDto create(StageEntity stage) {

        Optional<StageEntity> theStage= stageRepository.findById(stage.getId());
        if (theStage.isPresent()){
            throw new StageAlreadyExistException("Stage with this id already exist");
        }

        return  StageDto.toDto(
                stageRepository.save(stage));
    }



    @Override
    public List<StageDto> readAll() {
        return stageRepository.findAll().stream()
                .map(StageDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StageEntity readOneByDomaine(String domaine) {
        return (StageEntity) stageRepository.findByDomaine(domaine)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public StageDto update(StageDto stage) {
        return StageDto.toDto(
                stageRepository.save(StageDto.toEntity(stage)));
    }

   /* @Override
    public void deleteOneById(Long id) {
        stageRepository.deleteById(id);
    }*/

    @Override
    public void deleteOne(StageDto stage) {
        stageRepository.delete(StageDto.toEntity(stage));
    }

    public String deleteOneById(Long id) {
        if(stageRepository.existsById(id)){
            stageRepository.deleteById(id);
            return "Delete with success";
        }else {
            throw new NoSuchElementException("No User with that Id");
        }
    }
}

