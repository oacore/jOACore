package uk.ac.core.oacore4j.journals;


import org.junit.Test;
import retrofit2.Call;
import uk.ac.core.oacore4j.BaseTest;
import uk.ac.core.oacore4j.OACoreService;
import uk.ac.core.oacore4j.commons.SearchRequest;
import uk.ac.core.oacore4j.journals.response.JournalResponse;
import uk.ac.core.oacore4j.journals.response.JournalSearchResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Giorgio Basile
 * @since 07/06/2017
 */
public class JournalsServiceTests extends BaseTest{

    @Test
    public void getJournalByIssn() throws IOException {
        OACoreService coreService = new OACoreService(readApiKey());
        Call<JournalResponse> request = coreService.getJournalsService().getJournal("1544-9173");
        JournalResponse journalResponse = request.execute().body();

        assert journalResponse != null;
        assert journalResponse.getStatus().equals("OK");

    }

    @Test
    public void getJournalsByIssn() throws IOException {
        OACoreService coreService = new OACoreService(readApiKey());

        List<String> issnList = Arrays.asList("1544-9173", "1210-2512");

        Call<List<JournalResponse>> request = coreService.getJournalsService().getJournals(issnList);
        List<JournalResponse> journalResponse = request.execute().body();

        assert journalResponse != null;
        assert journalResponse.stream().allMatch(a -> a.getStatus().equals("OK"));
    }

    @Test
    public void searchJournalsSingleQuery() throws IOException {
        OACoreService coreService = new OACoreService(readApiKey());
        Call<JournalSearchResponse> request = coreService.getJournalsService().searchJournals("PLoS", 1, 10);

        JournalSearchResponse journalSearchResponse = request.execute().body();

        assert journalSearchResponse != null;
        assert journalSearchResponse.getStatus().equals("OK");
    }

    @Test
    public void searchJournalsMultipleQueries() throws IOException {
        OACoreService coreService = new OACoreService(readApiKey());

        SearchRequest s1 = new SearchRequest();
        s1.setQuery("PLoS");
        s1.setPage(1);
        s1.setPageSize(10);

        SearchRequest s2 = new SearchRequest();
        s2.setQuery("Radioengineering");
        s2.setPage(1);
        s2.setPageSize(10);

        List<SearchRequest> searchRequestList = Arrays.asList(s1, s2);

        Call<List<JournalSearchResponse>> request = coreService.getJournalsService().searchJournals(searchRequestList);
        List<JournalSearchResponse> journalSearchResponse = request.execute().body();

        assert journalSearchResponse != null;
        assert journalSearchResponse.stream().allMatch(a -> a.getStatus().equals("OK"));
    }

}
