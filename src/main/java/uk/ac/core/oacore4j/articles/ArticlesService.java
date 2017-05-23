package uk.ac.core.oacore4j.articles;

import retrofit2.Call;
import uk.ac.core.oacore4j.articles.response.Article;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */
public class ArticlesService {

    private String apiKey;
    private ArticlesApi articlesApis;

    public ArticlesService(String apiKey){
        this.apiKey = apiKey;
    }

    public Article getArticleById(Integer coreId, HashMap<String, Object> params) throws IOException {
        Call<Article> request = articlesApis.getArticleById(coreId, params);
        return request.execute().body();
    }





}
