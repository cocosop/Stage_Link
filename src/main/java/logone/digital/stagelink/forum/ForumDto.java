package logone.digital.stagelink.forum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import logone.digital.stagelink.commentaire.Commentaire;

import java.util.List;

public record ForumDto(Integer id, @NotBlank String publication,@Valid List<Commentaire>commentaires) {
}
