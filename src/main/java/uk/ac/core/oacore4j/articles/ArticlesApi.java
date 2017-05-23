package uk.ac.core.oacore4j.articles;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import uk.ac.core.oacore4j.Utils;
import uk.ac.core.oacore4j.articles.response.Article;

import java.util.Map;


/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */

public interface ArticlesApi {

    String CORE_HOST = "https://core.ac.uk/";
    String API_PATH = "api-v2/articles/";

    String CORE_ID = "coreId";
    String METADATA = "metadata";
    String FULL_TEXT = "fulltext";
    String CITATIONS = "citations";
    String SIMILAR = "similar";
    String DUPLICATE = "duplicate";
    String URLS = "urls";
    String FAITHFUL_METADATA = "faithfulMetadata";


    @GET("get/{coreId}")
    Call<Article> getArticleById(@Path(CORE_ID) Integer coreId,
                                 @Query(METADATA) Boolean metadata,
                                 @Query(FULL_TEXT) Boolean fullText,
                                 @Query(CITATIONS) Boolean citations,
                                 @Query(SIMILAR) Boolean similar,
                                 @Query(DUPLICATE) Boolean duplicate,
                                 @Query(URLS) Boolean urls,
                                 @Query(FAITHFUL_METADATA) Boolean faithfulMetadata);

    @GET("get/{coreId}")
    Call<Article> getArticleById(@Path(CORE_ID) Integer coreId,
                                 @QueryMap Map<String, Object> options);


    static ArticlesApi serviceFactory(String apiKey){

        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(ArticlesApi.CORE_HOST + ArticlesApi.API_PATH)
        .addConverterFactory(GsonConverterFactory.create())
        .client(Utils.createClient(apiKey))
        .build();

        return retrofit.create(ArticlesApi.class);

    }


}
