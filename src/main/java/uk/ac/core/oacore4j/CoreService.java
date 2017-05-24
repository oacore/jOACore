package uk.ac.core.oacore4j;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import uk.ac.core.oacore4j.articles.ArticlesService;

/**
 * @author Giorgio Basile
 * @since 24/05/2017
 */
public class CoreService {

    private static final String API_KEY = "apiKey";


    private ArticlesService articlesApi;
    private String apiKey;


    public CoreService(String apiKey){
        this.apiKey = apiKey;
        this.articlesApi = ArticlesService.serviceFactory(createClient(apiKey));
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


    private OkHttpClient createClient(String apiKey){
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
        httpClient.interceptors().add(chain -> {
            Request request = chain.request();
            HttpUrl url = request.url().newBuilder().addQueryParameter(API_KEY, apiKey).build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        });
        return httpClient.build();
    }
}
