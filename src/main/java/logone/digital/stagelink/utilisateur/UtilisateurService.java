package logone.digital.stagelink.utilisateur;

import logone.digital.stagelink.stage.StageDto;
import logone.digital.stagelink.stage.StageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UtilisateurService implements IUtilisateurService{

    final UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto create(UtilisateurDto utilisateur) {
        return UtilisateurDto.toDto(
                utilisateurRepository.save(UtilisateurDto.toEntity(utilisateur)));
    }

    @Override
    public List<UtilisateurDto> readAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDto readOneById(Long id) {
        return UtilisateurDto.toDto(utilisateurRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Utilisateur not exist")));
    }

    @Override
    public UtilisateurDto update(UtilisateurDto utilisateur) {
        return UtilisateurDto.toDto(
                utilisateurRepository.save(UtilisateurDto.toEntity(utilisateur)));
    }

    @Override
    public void deleteOneById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public void deleteOne(UtilisateurDto utilisateur) {
        utilisateurRepository.delete(UtilisateurDto.toEntity(utilisateur));
    }
}



