package uk.ac.core.oacore4j.articles;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import uk.ac.core.oacore4j.articles.response.Article;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */

class ArticlesServiceTest {

    /** this is just a testing API key, please register your own API key at: https://core.ac.uk/services#api */
    public static final String TEST_API_KEY = "btYj73TKGQahoUzL41yHANnJVeClvPIX";
    public static final Integer TEST_CORE_ID = 42;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getArticleById() throws IOException {

        ArticlesApi articlesService = ArticlesApi.serviceFactory("");

        HashMap<String, Object> params = new HashMap<>();
        params.put(ArticlesApi.CITATIONS, Boolean.TRUE);
;
        Call<Article> request = articlesService.getArticleById(TEST_CORE_ID, params);
        Article article = request.execute().body();

        assert article.getStatus().equals("OK");

    }

}
