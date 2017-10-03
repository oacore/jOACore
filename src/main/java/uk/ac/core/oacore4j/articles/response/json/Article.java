
package uk.ac.core.oacore4j.articles.response.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "authors",
    "citations",
    "contributors",
    "datePublished",
    "description",
    "fullText",
    "identifiers",
    "journals",
    "language",
    "relations",
    "repositories",
    "similarities",
    "subjects",
    "title",
    "topics",
    "types",
    "year",
    "duplicates",
    "fulltextUrls",
    "rawRecordXml",
    "fulltextIdentifier",
    "oai"
})
public class Article {

    @JsonProperty("id")
    private String id;
    @JsonProperty("authors")
    private List<String> authors = null;
    @JsonProperty("citations")
    private List<Citation> citations = null;
    @JsonProperty("contributors")
    private List<String> contributors = null;
    @JsonProperty("datePublished")
    private String datePublished;
    @JsonProperty("description")
    private String description;
    @JsonProperty("fullText")
    private String fullText;
    @JsonProperty("identifiers")
    private List<String> identifiers = null;
    @JsonProperty("journalss")
    private List<ArticleJournal> journals = null;
    @JsonProperty("language")
    private Language language;
    @JsonProperty("relations")
    private List<String> relations = null;
    @JsonProperty("repositories")
    private List<Repository> repositories = null;
    @JsonProperty("similarities")
    private List<Similar> similarities = null;
    @JsonProperty("subjects")
    private List<String> subjects = null;
    @JsonProperty("title")
    private String title;
    @JsonProperty("topics")
    private List<String> topics = null;
    @JsonProperty("types")
    private List<String> types = null;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("duplicates")
    private List<Object> duplicates = null;
    @JsonProperty("fulltextUrls")
    private List<String> fulltextUrls = null;
    @JsonProperty("rawRecordXml")
    private RawRecordXml rawRecordXml;
    @JsonProperty("fulltextIdentifier")
    private String fulltextIdentifier;
    @JsonProperty("oai")
    private String oai;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("doi")
    private String doi;
    @JsonProperty("downloadUrl")
    private String downloadUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("authors")
    public List<String> getAuthors() {
        return authors;
    }

    @JsonProperty("authors")
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @JsonProperty("citations")
    public List<Citation> getCitations() {
        return citations;
    }

    @JsonProperty("citations")
    public void setCitations(List<Citation> citations) {
        this.citations = citations;
    }

    @JsonProperty("contributors")
    public List<String> getContributors() {
        return contributors;
    }

    @JsonProperty("contributors")
    public void setContributors(List<String> contributors) {
        this.contributors = contributors;
    }

    @JsonProperty("datePublished")
    public String getDatePublished() {
        return datePublished;
    }

    @JsonProperty("datePublished")
    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("fullText")
    public String getFullText() {
        return fullText;
    }

    @JsonProperty("fullText")
    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    @JsonProperty("identifiers")
    public List<String> getIdentifiers() {
        return identifiers;
    }

    @JsonProperty("identifiers")
    public void setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
    }

    @JsonProperty("journals")
    public List<ArticleJournal> getJournals() {
        return journals;
    }

    @JsonProperty("journals")
    public void setJournals(List<ArticleJournal> journals) {
        this.journals = journals;
    }

    @JsonProperty("language")
    public Language getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language language) {
        this.language = language;
    }

    @JsonProperty("relations")
    public List<String> getRelations() {
        return relations;
    }

    @JsonProperty("relations")
    public void setRelations(List<String> relations) {
        this.relations = relations;
    }

    @JsonProperty("repositories")
    public List<Repository> getRepositories() {
        return repositories;
    }

    @JsonProperty("repositories")
    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @JsonProperty("similarities")
    public List<Similar> getSimilarities() {
        return similarities;
    }

    @JsonProperty("similarities")
    public void setSimilarities(List<Similar> similarities) {
        this.similarities = similarities;
    }

    @JsonProperty("subjects")
    public List<String> getSubjects() {
        return subjects;
    }

    @JsonProperty("subjects")
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("topics")
    public List<String> getTopics() {
        return topics;
    }

    @JsonProperty("topics")
    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    @JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("duplicates")
    public List<Object> getDuplicates() {
        return duplicates;
    }

    @JsonProperty("duplicates")
    public void setDuplicates(List<Object> duplicates) {
        this.duplicates = duplicates;
    }

    @JsonProperty("fulltextUrls")
    public List<String> getFulltextUrls() {
        return fulltextUrls;
    }

    @JsonProperty("fulltextUrls")
    public void setFulltextUrls(List<String> fulltextUrls) {
        this.fulltextUrls = fulltextUrls;
    }

    @JsonProperty("rawRecordXml")
    public RawRecordXml getRawRecordXml() {
        return rawRecordXml;
    }

    @JsonProperty("rawRecordXml")
    public void setRawRecordXml(RawRecordXml rawRecordXml) {
        this.rawRecordXml = rawRecordXml;
    }

    @JsonProperty("fulltextIdentifier")
    public String getFulltextIdentifier() {
        return fulltextIdentifier;
    }

    @JsonProperty("fulltextIdentifier")
    public void setFulltextIdentifier(String fulltextIdentifier) {
        this.fulltextIdentifier = fulltextIdentifier;
    }

    @JsonProperty("oai")
    public String getOai() {
        return oai;
    }

    @JsonProperty("oai")
    public void setOai(String oai) {
        this.oai = oai;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("doi")
    public String getDoi() {
        return doi;
    }

    @JsonProperty("doi")
    public void setDoi(String doi) {
        this.doi = doi;
    }

    @JsonProperty("downloadUrl")
    public String getDownloadUrl() {
        return downloadUrl;
    }

    @JsonProperty("downloadUrl")
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
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
