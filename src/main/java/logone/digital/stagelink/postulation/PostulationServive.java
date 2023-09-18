package logone.digital.stagelink.postulation;


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
public class PostulationServive implements IPostulationService {
    final PostulationRepository postulationRepository;

    //Ici nous avons remplacer le constructeur avec @AllArgsConstructor de lombok
    //qui genere le constructeur lors de l'execution pour éviter le boilerplate du code

    @Override
    public PostulationDto create(PostulationEntity postulation) {

        Optional<PostulationEntity> thePostulant= postulationRepository.findByCode(postulation.getCode());
        if (thePostulant.isPresent()){
            throw new PostulationAlreadyExistsException("Postulant with this email already exist");
        }

        return  PostulationDto.toDto(
                postulationRepository.save(postulation));
    }

    @Override
    public List<PostulationDto> readAll() {
        return postulationRepository.findAll().stream()
                .map(PostulationDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostulationDto readOneById(Long id) {
        return PostulationDto.toDto(postulationRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Postulation not exist")));
    }

    @Override
    public PostulationDto update(PostulationDto postulation) {
        return PostulationDto.toDto(
                postulationRepository.save(PostulationDto.toEntity(postulation)));
    }

    @Override
    public void deleteOneById(Long id) {
        postulationRepository.deleteById(id);
    }

    @Override
    public void deleteOne(PostulationDto postulation) {
        postulationRepository.delete(PostulationDto.toEntity(postulation));
    }
}


