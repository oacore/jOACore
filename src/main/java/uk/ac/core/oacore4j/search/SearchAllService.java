package uk.ac.core.oacore4j.search;

import retrofit2.Call;
import retrofit2.http.*;

import uk.ac.core.oacore4j.commons.SearchRequest;
import uk.ac.core.oacore4j.search.response.SearchAllResponse;

import java.util.List;
import java.util.Map;


/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */

public interface SearchAllService {

    String QUERY = "query";
    String PAGE = "page";
    String PAGE_SIZE = "pageSize";


    @POST("search")
    Call<List<SearchAllResponse>> search(@Body List<SearchRequest> searchRequests);

    @GET("search/{query}")
    Call<SearchAllResponse> search(@Path(QUERY) String query,
                                   @Query(PAGE) Integer page,
                                   @Query(PAGE_SIZE) Integer pageSize);

}
