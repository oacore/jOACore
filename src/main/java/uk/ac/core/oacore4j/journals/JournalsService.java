package uk.ac.core.oacore4j.journals;

import retrofit2.Call;
import retrofit2.http.*;
import uk.ac.core.oacore4j.commons.SearchRequest;
import uk.ac.core.oacore4j.journals.response.JournalResponse;
import uk.ac.core.oacore4j.journals.response.JournalSearchResponse;

import java.util.List;


/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */

public interface JournalsService {

    String QUERY = "query";
    String PAGE = "page";
    String PAGE_SIZE = "pageSize";
    String ISSN = "issn";


    @POST("journals/get")
    Call<List<JournalResponse>> getJournals(@Body List<String> issnList);

    @GET("journals/get/{issn}")
    Call<JournalResponse> getJournal(@Path(ISSN) String issn);

    @POST("journals/search")
    Call<List<JournalSearchResponse>> searchJournals(@Body List<SearchRequest> searchRequests);

    @GET("journals/search/{query}")
    Call<JournalSearchResponse> searchJournals(@Path(QUERY) String query,
                                               @Query(PAGE) Integer page,
                                               @Query(PAGE_SIZE) Integer pageSize);

}
