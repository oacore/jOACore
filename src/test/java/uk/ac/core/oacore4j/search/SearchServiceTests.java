package uk.ac.core.oacore4j.search;

import org.junit.Test;
import retrofit2.Call;
import uk.ac.core.oacore4j.BaseTest;
import uk.ac.core.oacore4j.OACoreService;
import uk.ac.core.oacore4j.commons.SearchRequest;
import uk.ac.core.oacore4j.search.response.SearchAllResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Giorgio Basile
 * @since 07/06/2017
 */
public class SearchServiceTests extends BaseTest {

    @Test
    public void searchSingleQuery() throws IOException {
        OACoreService coreService = new OACoreService(readApiKey());
        Call<SearchAllResponse> request = coreService.getSearchAllService().search("Petr-Knoth", 1, 10);

        SearchAllResponse searchAllResponse = request.execute().body();

        assert searchAllResponse != null;
        assert searchAllResponse.getStatus().equals("OK");

    }


    @Test
    public void searchMultipleQueries() throws IOException {
        OACoreService coreService = new OACoreService(readApiKey());

        SearchRequest s1 = new SearchRequest();
        s1.setQuery("Petr-Knoth");
        s1.setPage(1);
        s1.setPageSize(10);

        SearchRequest s2 = new SearchRequest();
        s2.setQuery("artificial-intelligence");
        s2.setPage(1);
        s2.setPageSize(10);

        List<SearchRequest> searchRequestList = Arrays.asList(s1, s2);

        Call<List<SearchAllResponse>> request = coreService.getSearchAllService().search(searchRequestList);
        List<SearchAllResponse> searchAllResponseList = request.execute().body();

        assert searchAllResponseList != null;
        assert searchAllResponseList.stream().allMatch(a -> a.getStatus().equals("OK"));
    }

}
