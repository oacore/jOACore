package uk.ac.core.oacore4j.articles;

import retrofit2.Call;
import retrofit2.http.*;
import uk.ac.core.oacore4j.articles.request.SearchRequest;
import uk.ac.core.oacore4j.articles.request.SimilarRequest;
import uk.ac.core.oacore4j.articles.response.ArticleResponse;
import uk.ac.core.oacore4j.articles.response.ArticleSearchResponse;
import uk.ac.core.oacore4j.articles.response.ArticleSimilarResponse;

import java.util.List;
import java.util.Map;


/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */

public interface ArticlesService {

    String CORE_ID = "coreId";
    String METADATA = "metadata";
    String FULL_TEXT = "fulltext";
    String CITATIONS = "citations";
    String SIMILAR = "similar";
    String DUPLICATE = "duplicate";
    String URLS = "urls";
    String FAITHFUL_METADATA = "faithfulMetadata";

    String LIMIT = "limit";
    String QUERY = "query";
    String PAGE = "page";
    String PAGE_SIZE = "pageSize";


    @GET("articles/get/{coreId}")
    Call<ArticleResponse> getArticleById(@Path(CORE_ID) Integer coreId,
                                         @Query(METADATA) Boolean metadata,
                                         @Query(FULL_TEXT) Boolean fullText,
                                         @Query(CITATIONS) Boolean citations,
                                         @Query(SIMILAR) Boolean similar,
                                         @Query(DUPLICATE) Boolean duplicate,
                                         @Query(URLS) Boolean urls,
                                         @Query(FAITHFUL_METADATA) Boolean faithfulMetadata);

    @GET("articles/get/{coreId}")
    Call<ArticleResponse> getArticleById(@Path(CORE_ID) Integer coreId,
                                         @QueryMap Map<String, Object> options);

    @POST("articles/get")
    Call<List<ArticleResponse>> getArticlesById(@Body List<Integer> coreIds,
                                                @Query(METADATA) Boolean metadata,
                                                @Query(FULL_TEXT) Boolean fullText,
                                                @Query(CITATIONS) Boolean citations,
                                                @Query(SIMILAR) Boolean similar,
                                                @Query(DUPLICATE) Boolean duplicate,
                                                @Query(URLS) Boolean urls,
                                                @Query(FAITHFUL_METADATA) Boolean faithfulMetadata);

    @POST("articles/get")
    Call<List<ArticleResponse>> getArticlesById(@Body List<Integer> coreIds,
                                                @QueryMap Map<String, Object> options);

    @GET("articles/similar")
    Call<ArticleSimilarResponse> getSimilarArticles(@Body SimilarRequest similarRequest,
                                                    @Query(LIMIT) Integer limit,
                                                    @Query(METADATA) Boolean metadata,
                                                    @Query(FULL_TEXT) Boolean fullText,
                                                    @Query(CITATIONS) Boolean citations,
                                                    @Query(SIMILAR) Boolean similar,
                                                    @Query(DUPLICATE) Boolean duplicate,
                                                    @Query(URLS) Boolean urls,
                                                    @Query(FAITHFUL_METADATA) Boolean faithfulMetadata);

    @POST("articles/similar")
    Call<ArticleSimilarResponse> getSimilarArticles(@Body SimilarRequest similarRequest,
                                                    @QueryMap Map<String, Object> options);

    @GET("articles/search")
    Call<List<ArticleSearchResponse>> searchArticles(@Body List<SearchRequest> similarRequest,
                                                     @Query(LIMIT) Integer limit,
                                                     @Query(METADATA) Boolean metadata,
                                                     @Query(FULL_TEXT) Boolean fullText,
                                                     @Query(CITATIONS) Boolean citations,
                                                     @Query(SIMILAR) Boolean similar,
                                                     @Query(DUPLICATE) Boolean duplicate,
                                                     @Query(URLS) Boolean urls,
                                                     @Query(FAITHFUL_METADATA) Boolean faithfulMetadata);

    @POST("articles/search")
    Call<List<ArticleSearchResponse>> searchArticles(@Body List<SearchRequest> similarRequest,
                                                     @QueryMap Map<String, Object> options);

    @GET("articles/search/{query}")
    Call<ArticleSearchResponse> searchArticles(@Path(QUERY) String query,
                                               @Query(PAGE) Integer page,
                                               @Query(PAGE_SIZE) Integer pageSize,
                                               @Query(METADATA) Boolean metadata,
                                               @Query(FULL_TEXT) Boolean fullText,
                                               @Query(CITATIONS) Boolean citations,
                                               @Query(SIMILAR) Boolean similar,
                                               @Query(DUPLICATE) Boolean duplicate,
                                               @Query(URLS) Boolean urls,
                                               @Query(FAITHFUL_METADATA) Boolean faithfulMetadata);

    @GET("articles/search/{query}")
    Call<ArticleSearchResponse> searchArticles(@Path(QUERY) String query,
                                               @QueryMap Map<String, Object> options);


}
