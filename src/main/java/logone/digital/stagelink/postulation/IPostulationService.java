package logone.digital.stagelink.postulation;
import java.util.List;
import java.util.Optional;

public interface IPostulationService {
    PostulationDto create(PostulationEntity postulation);

    List<PostulationDto> readAll();
    PostulationDto readOneById(Long id);

    PostulationDto update(PostulationDto postulation);

    void deleteOneById(Long id);

    //    void deleteOneById(Long id);
    void deleteOne(PostulationDto postulation);
}
