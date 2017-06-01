
package uk.ac.core.oacore4j.repositories.response;

import com.fasterxml.jackson.annotation.*;
import uk.ac.core.oacore4j.repositories.response.json.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data"
})
public class RepositorySearchResponse {

    @JsonProperty("status")
    private String status;
    @JsonProperty("totalHits")
    private Integer totalHits;
    @JsonProperty("data")
    private List<Repository> data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("totalHits")
    public Integer getTotalHits() {
        return totalHits;
    }

    @JsonProperty("totalHits")
    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    @JsonProperty("data")
    public List<Repository> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Repository> data) {
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
