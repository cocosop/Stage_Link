package logone.digital.stagelink.commentaire;

import java.util.List;

public interface IServiceCommentaire {
    CommentaireDto create(CommentaireDto commentaireDto);
    List<CommentaireDto> getAll();
    CommentaireDto update(CommentaireDto commentaireDto);
    void deleteById(Integer id);
}
