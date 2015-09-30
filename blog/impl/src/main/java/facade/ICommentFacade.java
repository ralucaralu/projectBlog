package facade;

import model.Comment;

import java.util.List;

/**
 * Created by Raluca on 30.09.2015.
 */
public interface ICommentFacade {
    List<Comment> getAllComments(Long articleId);
    Comment getComment(Long articleId, Long commentId);
    void saveComment(Comment comment);
    void deleteComment(Long articleId, Long commentId);
    void updateComment(Comment comment);
}
