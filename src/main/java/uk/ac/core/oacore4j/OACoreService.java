package uk.ac.core.oacore4j;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import uk.ac.core.oacore4j.articles.ArticlesService;


/**
 * @author Giorgio Basile
 * @since 24/05/2017
 */
public class OACoreService {

    private static final String CORE_API = "https://core.ac.uk/api-v2/";
    private static final String API_KEY = "apiKey";

    private ArticlesService articlesService;
    private String apiKey;
    private Retrofit retrofit;


    public OACoreService(String apiKey){
        this.apiKey = apiKey;
        this.retrofit = createRetrofit(apiKey);

        this.articlesService = retrofit.create(ArticlesService.class);
        // this.repositoriesService = new RepositoriesService(retrofit.create(RepositoriesApi.class));
    }

    public ArticlesService getArticlesService() {
        return articlesService;
    }

    private Retrofit createRetrofit(String apiKey){

        return new Retrofit.Builder()
        .baseUrl(CORE_API)
        .addConverterFactory(JacksonConverterFactory.create())
        .client(createClient(apiKey))
        .build();
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
