package logone.digital.stagelink.stage;


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

    //Ici nous avons remplacer le constructeur avec @AllArgsConstructor de lombok
    //qui genere le constructeur lors de l'execution pour éviter le boilerplate du code

    @Override
    public StageDto create(StageDto stagedto) {
        return StageDto.toDto(
                stageRepository.save(StageDto.toEntity(stagedto)));
    }

    @Override
    public List<StageDto> readAll() {
        return stageRepository.findAll().stream()
                .map(StageDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StageDto readOneById(Long id) {
        return StageDto.toDto(stageRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Stage not exist")));
    }

    @Override
    public StageDto update(StageDto stage) {
        return StageDto.toDto(
                stageRepository.save(StageDto.toEntity(stage)));
    }

    @Override
    public void deleteOneById(Long id) {
        stageRepository.deleteById(id);
    }

    @Override
    public void deleteOne(StageDto stage) {
        stageRepository.delete(StageDto.toEntity(stage));
    }
}

