package uk.ac.core.oacore4j.repositories;

import org.junit.Test;
import retrofit2.Call;
import uk.ac.core.oacore4j.OACoreService;
import uk.ac.core.oacore4j.repositories.response.RepositoryResponse;

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

}
