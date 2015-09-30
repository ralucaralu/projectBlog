package dao;

import model.Article;

import java.util.List;

/**
 * Created by Raluca on 30.09.2015.
 */
public interface IArticleDao {
    List<Article> getAll();
    Article get(Long id);
    void save(Article article);
    void update(Article article);
    void remove(Long id);
}
