package uk.ac.core.oacore4j.articles;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import uk.ac.core.oacore4j.CoreService;
import uk.ac.core.oacore4j.articles.response.Article;

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

        CoreService coreService = new CoreService(TEST_API_KEY);

        HashMap<String, Object> params = new HashMap<>();
        params.put(ArticlesService.CITATIONS, Boolean.TRUE);

        Call<Article> request = coreService.getArticlesApi().getArticleById(42, params);
        Article article = request.execute().body();

        assert article != null;
        assert article.getStatus().equals("OK");

    }

    @Test
    void getArticlesById() throws IOException {

        CoreService coreService = new CoreService(TEST_API_KEY);

        HashMap<String, Object> params = new HashMap<>();
        params.put(ArticlesService.CITATIONS, Boolean.TRUE);

        List<Integer> coreIds = Arrays.asList(42, 43);

        Call<List<Article>> request = coreService.getArticlesApi().getArticlesById(coreIds, params);
        List<Article> articles = request.execute().body();

        assert articles != null;
        assert articles.stream().allMatch(a -> a.getStatus().equals("OK"));

    }

}
