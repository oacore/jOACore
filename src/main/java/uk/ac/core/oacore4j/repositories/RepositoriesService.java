package uk.ac.core.oacore4j.repositories;

import retrofit2.Call;
import retrofit2.http.*;
import uk.ac.core.oacore4j.repositories.response.RepositoryResponse;

import java.util.List;


/**
 * @author Giorgio Basile
 * @since 01/06/2017
 */

public interface RepositoriesService {

    String REPOSITORY_ID = "repositoryId";

    @POST("repositories/get")
    Call<List<RepositoryResponse>> getRepositoriesById(@Body List<Integer> repositoryIds);

    @GET("repositories/get/{repositoryId}")
    Call<RepositoryResponse> getRepositoryById(@Path(REPOSITORY_ID) Integer repositoryId);


}
