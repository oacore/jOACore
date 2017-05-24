package uk.ac.core.oacore4j;

import uk.ac.core.oacore4j.articles.ArticlesService;

/**
 * @author Giorgio Basile
 * @since 24/05/2017
 */
public class CoreService {

    private ArticlesService articlesApi;
    private String apiKey;

    public CoreService(String apiKey){
        this.apiKey = apiKey;
        this.articlesApi = ArticlesService.serviceFactory(apiKey);
    }

    public ArticlesService getArticlesApi() {
        return articlesApi;
    }

    public void setArticlesApi(ArticlesService articlesApi) {
        this.articlesApi = articlesApi;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
