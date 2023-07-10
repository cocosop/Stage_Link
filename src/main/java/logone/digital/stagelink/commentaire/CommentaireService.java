package logone.digital.stagelink.commentaire;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentaireService implements IServiceCommentaire {
    private final CommentaireRepository commentaireRepository;
    @Override
    public CommentaireDto create(CommentaireDto commentaireDto) {
        Commentaire commentaire= new Commentaire();
        commentaire.setMessage(commentaireDto.message());
        commentaire.setForum(commentaireDto.forum());
        Commentaire savedCommentaire = commentaireRepository.save(commentaire);
        return new CommentaireDto(savedCommentaire.getId(),
                savedCommentaire.getMessage(),
                savedCommentaire.getForum());
    }

    @Override
    public List<CommentaireDto> getAll() {
        return commentaireRepository.findAll().stream()
                .map(commentaire -> new  CommentaireDto(commentaire.getId(),
                        commentaire.getMessage(),
                        commentaire.getForum()))
                .collect(Collectors.toList());
    }

    @Override
    public CommentaireDto update(CommentaireDto commentaireDto) {
        Commentaire commentaire= new Commentaire();
        commentaire.setMessage(commentaireDto.message());
        commentaire.setForum(commentaireDto.forum());
        Commentaire savedCommentaire = commentaireRepository.save(commentaire);
        return new CommentaireDto(savedCommentaire.getId(),
                savedCommentaire.getMessage(),
                savedCommentaire.getForum());

    }

    @Override
    public void deleteById(Integer id) {
        commentaireRepository.deleteById(id);
    }

}
