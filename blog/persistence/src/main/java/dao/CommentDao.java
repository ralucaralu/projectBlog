package dao;

import model.Comment;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.TransactionRolledbackException;
import java.util.List;

/**
 * Created by Raluca on 30.09.2015.
 */
public class CommentDao implements ICommentDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    public List<Comment> getAllComments(Long articleId) {
        Query query= this.entityManager.createQuery("from Comment where articleId=:articleId");
        query.setParameter("articleId",articleId);

        return query.getResultList();//To change body of implemented methods use File | Settings | File Templates.
    }


    public Comment getComment(Long articleId, Long commentId) {
        Query query= this.entityManager.createQuery("from Comment where articleId=:articleId");
        query.setParameter("articleId",articleId);
        query.setParameter("articleId",commentId);
        List<Comment> result=query.getResultList();
        if(result!=null && !result.isEmpty()) {
            return result.get(0);
        }
        return (Comment)query.getSingleResult();  //To change body of implemented methods use File | Settings | File Templates.
    }



    @Transactional
    public void saveComment(Comment comment) {
        this.entityManager.persist(comment);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Transactional
    public void updateComment(Comment comment) {
        Comment commentFromDb=this.getComment(comment.getArticleId(),comment.getId());
        if(commentFromDb!=null){
            commentFromDb.setContent(comment.getContent());
            this.entityManager.persist(commentFromDb);
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Transactional
    public void deleteComment(Long articleId, Long commentId) {
        Comment commentFromDb=this.getComment(articleId,commentId);
        if(commentFromDb!=null){
            this.entityManager.remove(commentFromDb);
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
