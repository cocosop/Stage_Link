package logone.digital.stagelink.forum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForumService implements IServiceForum {
    private final ForumRepository forumRepository;
    @Override
    public ForumDto create(ForumDto forumDto) {
        Forum forum= new Forum();
        forum.setPublication(forumDto.publication());
        forum.setCommentaires(forumDto.commentaires());
        Forum savedForum = forumRepository.save(forum);
        return new ForumDto(savedForum.getId(),
                savedForum.getPublication(),
                savedForum.getCommentaires());
    }

    @Override
    public List<ForumDto> getAll() {
        return forumRepository.findAll().stream()
                .map(forum -> new ForumDto(forum.getId(),
                        forum.getPublication(),
                        forum.getCommentaires()))
                .collect(Collectors.toList());
    }

    @Override
    public ForumDto update(ForumDto forumDto) {
        Forum forum= new Forum();
        forum.setPublication(forumDto.publication());
        forum.setCommentaires(forumDto.commentaires());
        Forum savedForum = forumRepository.save(forum);
        return new ForumDto(savedForum.getId(),
                savedForum.getPublication(),
                savedForum.getCommentaires());


    }

    @Override
    public void deleteById(Integer id) {
        forumRepository.deleteById(id);

    }
}
