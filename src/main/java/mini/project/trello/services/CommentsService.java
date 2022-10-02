package mini.project.trello.services;

import mini.project.trello.entities.Comments;

import java.util.List;

public interface CommentsService {

    Comments addComment(Comments comment);

    List<Comments> getAllComments();

    Comments getComment(Long id);

    void deleteComment(Comments comment);

    Comments saveComment(Comments comment);

}
