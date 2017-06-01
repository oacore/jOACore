package uk.ac.core.oacore4j.repositories;

import org.junit.Test;
import retrofit2.Call;
import uk.ac.core.oacore4j.OACoreService;
import uk.ac.core.oacore4j.commons.SearchRequest;
import uk.ac.core.oacore4j.repositories.response.RepositoryResponse;
import uk.ac.core.oacore4j.repositories.response.RepositorySearchResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Giorgio Basile
 * @since 01/06/2017
 */
public class RepositoriesServiceTests {

    private String readApiKey(){
        return System.getProperty("apiKey");
    }

    @Test
    public void getRepositoriesById() throws IOException {

        OACoreService coreService = new OACoreService(readApiKey());

        List<Integer> repositoriesIds = Arrays.asList(86, 140);

        Call<List<RepositoryResponse>> request = coreService.getRepositoriesService().getRepositoriesById(repositoriesIds);
        List<RepositoryResponse> repositoryResponseList = request.execute().body();

        assert repositoryResponseList != null;
        assert repositoryResponseList.stream().allMatch(a -> a.getStatus().equals("OK"));

    }

    @Test
    public void getRepositoryById() throws IOException {

        OACoreService coreService = new OACoreService(readApiKey());

        Call<RepositoryResponse> request = coreService.getRepositoriesService().getRepositoryById(86);
        RepositoryResponse repositoryResponse = request.execute().body();

        assert repositoryResponse != null;
        assert repositoryResponse.getStatus().equals("OK");

    }

    @Test
    public void searchRepositoriesSingleQuery() throws IOException {

        OACoreService coreService = new OACoreService(readApiKey());

        Call<RepositorySearchResponse> request = coreService.getRepositoriesService().searchRepositories("pubMed", 1, 10);
        RepositorySearchResponse searchResponse = request.execute().body();

        assert searchResponse != null;
        assert searchResponse.getStatus().equals("OK");

    }

    @Test
    public void searchRepositoriesMultipleQueries() throws IOException {

        OACoreService coreService = new OACoreService(readApiKey());

        SearchRequest s1 = new SearchRequest();
        s1.setQuery("PubMed");
        s1.setPage(1);
        s1.setPageSize(10);

        SearchRequest s2 = new SearchRequest();
        s2.setQuery("Aberdeen");
        s2.setPage(1);
        s2.setPageSize(10);

        List<SearchRequest> searchRequestList = Arrays.asList(s1, s2);

        Call<List<RepositorySearchResponse>> request = coreService.getRepositoriesService().searchRepositories(searchRequestList);
        List<RepositorySearchResponse> searchResponses = request.execute().body();

        assert searchResponses != null;
        assert searchResponses.stream().allMatch(a -> a.getStatus().equals("OK"));

    }



}
