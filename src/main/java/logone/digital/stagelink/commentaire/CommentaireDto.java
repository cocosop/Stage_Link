package logone.digital.stagelink.commentaire;

import jakarta.validation.constraints.NotBlank;
import logone.digital.stagelink.forum.Forum;

public record CommentaireDto(Integer id,
                             @NotBlank String message, Forum forum) {
}
