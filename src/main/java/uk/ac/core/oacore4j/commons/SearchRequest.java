package uk.ac.core.oacore4j.commons;

/**
 * @author Giorgio Basile
 * @since 24/05/2017
 */
public class SearchRequest {

    private String query;
    private Integer page;
    private Integer pageSize;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
