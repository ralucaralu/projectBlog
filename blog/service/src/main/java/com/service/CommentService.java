package com.service;

import facade.ICommentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import model.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Raluca on 01.10.2015.
 */
@Controller
public class CommentService {
    @Autowired
    private ICommentFacade commentFacade;

    @RequestMapping(value = "/article/{articleId}/comment", method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getAllComments(@PathVariable("articleId")Long articleId){
        return this.commentFacade.getAllComments(articleId);
    }

    @RequestMapping(value = "/article/{articleId}/comment/{commentId}", method = RequestMethod.GET)
    @ResponseBody
    public Comment getComment(@PathVariable("articleId")Long articleId, @PathVariable("commentId")Long commentId){
        return this.commentFacade.getComment(articleId,commentId);
    }
    @RequestMapping(value = "/article/{articleId}/comment", method = RequestMethod.POST)
    @ResponseBody
    public void saveComment (@PathVariable("articleId")Long articleId,@RequestBody Comment comment){
        comment.setArticleId(articleId);
        this.commentFacade.saveComment(comment);
    }
    @RequestMapping(value = "/article/{articleId}/comment/{commentId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateComment (@PathVariable("articleId")Long articleId,@PathVariable("commentId") Long commentId,@RequestBody Comment comment){
        comment.setId(commentId);
        comment.setArticleId(articleId);
        this.commentFacade.updateComment(comment);

    }
    @RequestMapping(value = "/article/{articleId}/comment/{commentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteComment (@PathVariable("articleId")Long articleId,@PathVariable("commentId") Long commentId){
        this.commentFacade.deleteComment(articleId,commentId);

    }
    public ICommentFacade getCommentFacade(){
        return commentFacade;
    }
    public void setCommentFacade(ICommentFacade commentFacade){
        this.commentFacade=commentFacade;
    }
}
