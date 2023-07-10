package logone.digital.stagelink.forum;

import java.util.List;

public interface IServiceForum {
    ForumDto create(ForumDto forumDto);
    List<ForumDto> getAll();
    ForumDto update(ForumDto forumDto);
    void deleteById(Integer id);
}
