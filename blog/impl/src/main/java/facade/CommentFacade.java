package facade;

import dao.ICommentDao;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 * Created by Raluca on 30.09.2015.
 */
public class CommentFacade implements ICommentFacade {
    @Autowired
    public ICommentDao commentDao;
    public List<Comment> getAllComments(Long articleId){
        return this.commentDao.getAllComments(articleId);
    }
    public Comment getComment(Long articleId,Long commentId){
        return  this.commentDao.getComment(articleId,commentId);
    }
    public void saveComment(Comment comment){
        this.commentDao.saveComment(comment);

    }
    public void updateComment(Comment comment){
        this.commentDao.updateComment(comment);

    }
    public void deleteComment(Long articleId,Long commentId){
        this.commentDao.deleteComment(articleId,commentId);

    }
    public ICommentDao getCommentDao(){
        return commentDao;
    }
    public void setCommentDao(ICommentDao commentDao){
        this.commentDao=commentDao;
    }

}
