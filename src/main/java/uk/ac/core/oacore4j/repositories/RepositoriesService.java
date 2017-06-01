package uk.ac.core.oacore4j.repositories;

import retrofit2.Call;
import retrofit2.http.*;
import uk.ac.core.oacore4j.repositories.response.RepositoryResponse;
import uk.ac.core.oacore4j.repositories.response.RepositorySearchResponse;
import uk.ac.core.oacore4j.commons.SearchRequest;

import java.util.List;


/**
 * @author Giorgio Basile
 * @since 01/06/2017
 */

public interface RepositoriesService {

    String REPOSITORY_ID = "repositoryId";
    String QUERY = "query";
    String PAGE = "page";
    String PAGE_SIZE = "pageSize";

    @POST("repositories/get")
    Call<List<RepositoryResponse>> getRepositoriesById(@Body List<Integer> repositoryIds);

    @GET("repositories/get/{repositoryId}")
    Call<RepositoryResponse> getRepositoryById(@Path(REPOSITORY_ID) Integer repositoryId);

    @POST("repositories/search")
    Call<List<RepositorySearchResponse>> searchRepositories(@Body List<SearchRequest> searchRequests);

    @GET("repositories/search/{query}")
    Call<RepositorySearchResponse> searchRepositories(@Path(QUERY) String query,
                                                      @Query(PAGE) Integer page,
                                                      @Query(PAGE_SIZE) Integer pageSize);


}
