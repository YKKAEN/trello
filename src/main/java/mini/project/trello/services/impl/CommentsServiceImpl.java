package mini.project.trello.services.impl;

import mini.project.trello.entities.Comments;
import mini.project.trello.repositories.CommentsRepository;
import mini.project.trello.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Comments addComment(Comments comment) {
        return commentsRepository.save(comment);
    }

    @Override
    public List<Comments> getAllComments() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments getComment(Long id) {
        return commentsRepository.getById(id);
    }

    @Override
    public void deleteComment(Comments comment) {
        commentsRepository.delete(comment);
    }

    @Override
    public Comments saveComment(Comments comment) {
        return commentsRepository.save(comment);

    }
}
