
package uk.ac.core.oacore4j.repositories.response.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "uri",
    "id",
    "OpenDoarId",
    "repositoryLocation"
})
public class Repository {

    @JsonProperty("name")
    private String name;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("OpenDoarId")
    private Integer openDoarId;
    @JsonProperty("repositoryLocation")
    private RepositoryLocation repositoryLocation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("OpenDoarId")
    public Integer getOpenDoarId() {
        return openDoarId;
    }

    @JsonProperty("OpenDoarId")
    public void setOpenDoarId(Integer openDoarId) {
        this.openDoarId = openDoarId;
    }

    @JsonProperty("repositoryLocation")
    public RepositoryLocation getRepositoryLocation() {
        return repositoryLocation;
    }

    @JsonProperty("repositoryLocation")
    public void setRepositoryLocation(RepositoryLocation repositoryLocation) {
        this.repositoryLocation = repositoryLocation;
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
