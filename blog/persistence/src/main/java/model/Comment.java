package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Raluca on 30.09.2015.
 */
@Entity
@Table(name="comment")
public class Comment {
    @Id()
    @GeneratedValue(generator="idIncrementor")
    @GenericGenerator(name="idIncrementor" , strategy="increment")
    private Long id;

    @Column(name="content")
    private String content;

    @Column(name="articleId")
    private Long articleId;

    public Comment(){};

    public Comment(String content, Long articleId) {
        this.content=content;
        this.articleId=articleId;
    }

    public void setArticleId(Long articleId) {
    }

    public void setId() {
    }

    public void setId(Long commentId) {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getArticleId() {
        return articleId;
    }

    public Long getId() {
        return id;
    }
}
