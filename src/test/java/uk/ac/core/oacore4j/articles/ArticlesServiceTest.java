package uk.ac.core.oacore4j.articles;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import uk.ac.core.oacore4j.OACoreService;
import uk.ac.core.oacore4j.articles.request.SearchRequest;
import uk.ac.core.oacore4j.articles.request.SimilarRequest;
import uk.ac.core.oacore4j.articles.response.ArticleResponse;
import uk.ac.core.oacore4j.articles.response.ArticleSearchResponse;
import uk.ac.core.oacore4j.articles.response.ArticleSimilarResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */

class ArticlesServiceTest {

    /** this is just a testing API key, please register your own API key at: https://core.ac.uk/services#api */
    private static final String TEST_API_KEY = "btYj73TKGQahoUzL41yHANnJVeClvPIX";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getArticleById() throws IOException {

        OACoreService coreService = new OACoreService(TEST_API_KEY);

        HashMap<String, Object> params = new HashMap<>();
        params.put(ArticlesService.CITATIONS, Boolean.TRUE);

        Call<ArticleResponse> request = coreService.getArticlesService().getArticleById(42, params);
        ArticleResponse article = request.execute().body();

        assert article != null;
        assert article.getStatus().equals("OK");

    }

    @Test
    void getArticlesById() throws IOException {

        OACoreService coreService = new OACoreService(TEST_API_KEY);

        HashMap<String, Object> params = new HashMap<>();
        params.put(ArticlesService.CITATIONS, Boolean.TRUE);

        List<Integer> coreIds = Arrays.asList(42, 43);

        Call<List<ArticleResponse>> request = coreService.getArticlesService().getArticlesById(coreIds, params);
        List<ArticleResponse> articleResponseList = request.execute().body();

        assert articleResponseList != null;
        assert articleResponseList.stream().allMatch(a -> a.getStatus().equals("OK"));

    }

    @Test
    void getSimilarArticles() throws IOException {

        OACoreService coreService = new OACoreService(TEST_API_KEY);

        HashMap<String, Object> params = new HashMap<>();
        params.put(ArticlesService.CITATIONS, Boolean.TRUE);

        SimilarRequest similarRequest = new SimilarRequest();
        similarRequest.setText("semantic-web");

        Call<ArticleSimilarResponse> request = coreService.getArticlesService().getSimilarArticles(similarRequest, params);
        ArticleSimilarResponse articleSimilarResponse = request.execute().body();

        assert articleSimilarResponse != null;
        assert articleSimilarResponse.getStatus().equals("OK");

    }

    @Test
    void searchArticlesMultipleQueries() throws IOException {

        OACoreService coreService = new OACoreService(TEST_API_KEY);

        HashMap<String, Object> params = new HashMap<>();
        params.put(ArticlesService.CITATIONS, Boolean.TRUE);

        SearchRequest s1 = new SearchRequest();
        s1.setQuery("semantic-web");
        s1.setPage(0);
        s1.setPageSize(1);

        SearchRequest s2 = new SearchRequest();
        s2.setQuery("artificial intelligence");
        s2.setPage(0);
        s2.setPageSize(1);

        List<SearchRequest> searchRequestList = Arrays.asList(s1, s2);

        Call<List<ArticleSearchResponse>> request = coreService.getArticlesService().searchArticles(searchRequestList, params);
        List<ArticleSearchResponse> articleSearchResponseList = request.execute().body();

        assert articleSearchResponseList != null;
        assert articleSearchResponseList.stream().allMatch(a -> a.getStatus().equals("OK"));

    }

    @Test
    void searchArticlesSingleQuery() throws IOException {

        OACoreService coreService = new OACoreService(TEST_API_KEY);

        HashMap<String, Object> params = new HashMap<>();
        params.put(ArticlesService.CITATIONS, Boolean.TRUE);

        Call<ArticleSearchResponse> request = coreService.getArticlesService().searchArticles("semantic-web", params);
        ArticleSearchResponse articleSearchResponse = request.execute().body();

        assert articleSearchResponse != null;
        assert articleSearchResponse.getStatus().equals("OK");

    }

}
