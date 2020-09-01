
package beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "desc",
    "descData",
    "closed",
    "idOrganization",
    "idEnterprise",
    "limits",
    "pinned",
    "shortLink",
    "creationMethod",
    "ixUpdate",
    "enterpriseOwned",
    "idBoardSource",
    "id",
    "starred",
    "url",
    "prefs",
    "subscribed",
    "labelNames",
    "dateLastView",
    "shortUrl",
    "templateGallery"
})
public class Board {

    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("descData")
    private Object descData;
    @JsonProperty("closed")
    private Boolean closed;
    @JsonProperty("idOrganization")
    private String idOrganization;
    @JsonProperty("idEnterprise")
    private String idEnterprise;
    @JsonProperty("limits")
    private Limits limits;
    @JsonProperty("pinned")
    private String pinned;
    @JsonProperty("shortLink")
    private String shortLink;
    @JsonProperty("creationMethod")
    private String creationMethod;
    @JsonProperty("ixUpdate")
    private Object ixUpdate;
    @JsonProperty("enterpriseOwned")
    private Object enterpriseOwned;
    @JsonProperty("idBoardSource")
    private String idBoardSource;
    @JsonProperty("id")
    private String id;
    @JsonProperty("starred")
    private Boolean starred;
    @JsonProperty("url")
    private String url;
    @JsonProperty("prefs")
    private Prefs prefs;
    @JsonProperty("subscribed")
    private Object subscribed;
    @JsonProperty("labelNames")
    private LabelNames labelNames;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "PDT")
    @JsonProperty("dateLastView")
    private Date dateLastView;
    @JsonProperty("shortUrl")
    private String shortUrl;
    @JsonProperty("templateGallery")
    private Object templateGallery;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("descData")
    public Object getDescData() {
        return descData;
    }

    @JsonProperty("descData")
    public void setDescData(Object descData) {
        this.descData = descData;
    }

    @JsonProperty("closed")
    public Boolean getClosed() {
        return closed;
    }

    @JsonProperty("closed")
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    @JsonProperty("idOrganization")
    public String getIdOrganization() {
        return idOrganization;
    }

    @JsonProperty("idOrganization")
    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    @JsonProperty("idEnterprise")
    public String getIdEnterprise() {
        return idEnterprise;
    }

    @JsonProperty("idEnterprise")
    public void setIdEnterprise(String idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    @JsonProperty("limits")
    public Limits getLimits() {
        return limits;
    }

    @JsonProperty("limits")
    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    @JsonProperty("pinned")
    public String getPinned() {
        return pinned;
    }

    @JsonProperty("pinned")
    public void setPinned(String pinned) {
        this.pinned = pinned;
    }

    @JsonProperty("shortLink")
    public String getShortLink() {
        return shortLink;
    }

    @JsonProperty("shortLink")
    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    @JsonProperty("creationMethod")
    public String getCreationMethod() {
        return creationMethod;
    }

    @JsonProperty("creationMethod")
    public void setCreationMethod(String creationMethod) {
        this.creationMethod = creationMethod;
    }

    @JsonProperty("ixUpdate")
    public Object getIxUpdate() {
        return ixUpdate;
    }

    @JsonProperty("ixUpdate")
    public void setIxUpdate(Object ixUpdate) {
        this.ixUpdate = ixUpdate;
    }

    @JsonProperty("enterpriseOwned")
    public Object getEnterpriseOwned() {
        return enterpriseOwned;
    }

    @JsonProperty("enterpriseOwned")
    public void setEnterpriseOwned(Object enterpriseOwned) {
        this.enterpriseOwned = enterpriseOwned;
    }

    @JsonProperty("idBoardSource")
    public Object getIdBoardSource() {
        return idBoardSource;
    }

    @JsonProperty("idBoardSource")
    public void setIdBoardSource(String idBoardSource) {
        this.idBoardSource = idBoardSource;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("starred")
    public Boolean getStarred() {
        return starred;
    }

    @JsonProperty("starred")
    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("prefs")
    public Prefs getPrefs() {
        return prefs;
    }

    @JsonProperty("prefs")
    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    @JsonProperty("subscribed")
    public Object getSubscribed() {
        return subscribed;
    }

    @JsonProperty("subscribed")
    public void setSubscribed(Object subscribed) {
        this.subscribed = subscribed;
    }

    @JsonProperty("labelNames")
    public LabelNames getLabelNames() {
        return labelNames;
    }

    @JsonProperty("labelNames")
    public void setLabelNames(LabelNames labelNames) {
        this.labelNames = labelNames;
    }

    @JsonProperty("dateLastView")
    public Date getDateLastView() {
        return dateLastView;
    }

    @JsonProperty("dateLastView")
    public void setDateLastView(Date dateLastView) {
        this.dateLastView = dateLastView;
    }

    @JsonProperty("shortUrl")
    public String getShortUrl() {
        return shortUrl;
    }

    @JsonProperty("shortUrl")
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @JsonProperty("templateGallery")
    public Object getTemplateGallery() {
        return templateGallery;
    }

    @JsonProperty("templateGallery")
    public void setTemplateGallery(Object templateGallery) {
        this.templateGallery = templateGallery;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Board.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
        sb.append(',');
        sb.append("descData");
        sb.append('=');
        sb.append(((this.descData == null)?"<null>":this.descData));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null)?"<null>":this.closed));
        sb.append(',');
        sb.append("idOrganization");
        sb.append('=');
        sb.append(((this.idOrganization == null)?"<null>":this.idOrganization));
        sb.append(',');
        sb.append("idEnterprise");
        sb.append('=');
        sb.append(((this.idEnterprise == null)?"<null>":this.idEnterprise));
        sb.append(',');
        sb.append("limits");
        sb.append('=');
        sb.append(((this.limits == null)?"<null>":this.limits));
        sb.append(',');
        sb.append("pinned");
        sb.append('=');
        sb.append(((this.pinned == null)?"<null>":this.pinned));
        sb.append(',');
        sb.append("shortLink");
        sb.append('=');
        sb.append(((this.shortLink == null)?"<null>":this.shortLink));
        sb.append(',');
        sb.append("creationMethod");
        sb.append('=');
        sb.append(((this.creationMethod == null)?"<null>":this.creationMethod));
        sb.append(',');
        sb.append("ixUpdate");
        sb.append('=');
        sb.append(((this.ixUpdate == null)?"<null>":this.ixUpdate));
        sb.append(',');
        sb.append("enterpriseOwned");
        sb.append('=');
        sb.append(((this.enterpriseOwned == null)?"<null>":this.enterpriseOwned));
        sb.append(',');
        sb.append("idBoardSource");
        sb.append('=');
        sb.append(((this.idBoardSource == null)?"<null>":this.idBoardSource));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("starred");
        sb.append('=');
        sb.append(((this.starred == null)?"<null>":this.starred));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("prefs");
        sb.append('=');
        sb.append(((this.prefs == null)?"<null>":this.prefs));
        sb.append(',');
        sb.append("subscribed");
        sb.append('=');
        sb.append(((this.subscribed == null)?"<null>":this.subscribed));
        sb.append(',');
        sb.append("labelNames");
        sb.append('=');
        sb.append(((this.labelNames == null)?"<null>":this.labelNames));
        sb.append(',');
        sb.append("dateLastView");
        sb.append('=');
        sb.append(((this.dateLastView == null)?"<null>":this.dateLastView));
        sb.append(',');
        sb.append("shortUrl");
        sb.append('=');
        sb.append(((this.shortUrl == null)?"<null>":this.shortUrl));
        sb.append(',');
        sb.append("templateGallery");
        sb.append('=');
        sb.append(((this.templateGallery == null)?"<null>":this.templateGallery));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return new EqualsBuilder()
                .append(getName(), board.getName())
                .append(getDesc(), board.getDesc())
                .append(getDescData(), board.getDescData())
                .append(getClosed(), board.getClosed())
                .append(getIdOrganization(), board.getIdOrganization())
                .append(getIdEnterprise(), board.getIdEnterprise())
                .append(getLimits(), board.getLimits())
                .append(getPinned(), board.getPinned())
                .append(getShortLink(), board.getShortLink())
                .append(getCreationMethod(), board.getCreationMethod())
                .append(getIxUpdate(), board.getIxUpdate())
                .append(getEnterpriseOwned(), board.getEnterpriseOwned())
                .append(getIdBoardSource(), board.getIdBoardSource())
                .append(getId(), board.getId())
                .append(getStarred(), board.getStarred())
                .append(getUrl(), board.getUrl())
                .append(getPrefs(), board.getPrefs())
                .append(getSubscribed(), board.getSubscribed())
                .append(getLabelNames(), board.getLabelNames())
                .append(getDateLastView(), board.getDateLastView())
                .append(getShortUrl(), board.getShortUrl())
                .append(getTemplateGallery(), board.getTemplateGallery())
                .append(getAdditionalProperties(), board.getAdditionalProperties())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .append(getDesc())
                .append(getDescData())
                .append(getClosed())
                .append(getIdOrganization())
                .append(getIdEnterprise())
                .append(getLimits())
                .append(getPinned())
                .append(getShortLink())
                .append(getCreationMethod())
                .append(getIxUpdate())
                .append(getEnterpriseOwned())
                .append(getIdBoardSource())
                .append(getId())
                .append(getStarred())
                .append(getUrl())
                .append(getPrefs())
                .append(getSubscribed())
                .append(getLabelNames())
                .append(getDateLastView())
                .append(getShortUrl())
                .append(getTemplateGallery())
                .append(getAdditionalProperties())
                .toHashCode();
    }
}
