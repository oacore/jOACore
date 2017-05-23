package uk.ac.core.oacore4j.articles.response;

import java.util.List;

/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */
public class Articles {

    private List<Article> articleList;

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
