package dao;

import model.Comment;
import java.util.List;

/**
 * Created by Raluca on 30.09.2015.
 */
public interface ICommentDao {
    public List<Comment> getAllComments(Long articleId);
    public Comment getComment(Long articleId,Long commentId);

    public void saveComment(Comment comment);
    public void updateComment(Comment comment);
    public void deleteComment(Long articleId,Long commentId);
}
