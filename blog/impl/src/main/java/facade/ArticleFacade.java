package facade;

import dao.IArticleDao;
import model.Article;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Raluca on 30.09.2015.
 */
public class ArticleFacade implements IArticleFacade {
    @Autowired
    private IArticleDao articleDao;

    public List<Article> getAll(){
        return this.articleDao.getAll();
    }

    public Article get(Long id){
        return  this.articleDao.get(id);
    }

    public void save(Article article) {
        this.articleDao.save(article);
    }

    public void update(Article article) {
        this.articleDao.update(article);
    }

    public void remove(Long id) {
        this.articleDao.remove(id);
    }



    public IArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(IArticleDao articleDao) {
        this.articleDao = articleDao;
    }
}

