package com.Matchurkorea.Match.domain;

import javax.annotation.Generated;
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
        "addr1",
        "addr2",
        "areacode",
        "booktour",
        "cat1",
        "cat2",
        "cat3",
        "contentid",
        "contenttypeid",
        "createdtime",
        "firstimage",
        "firstimage2",
        "homepage",
        "mapx",
        "mapy",
        "mlevel",
        "modifiedtime",
        "overview",
        "sigungucode",
        "title",
        "zipcode"
})
@Generated("jsonschema2pojo")
public class Detail {

    @JsonProperty("addr1")
    private String addr1;
    @JsonProperty("addr2")
    private String addr2;
    @JsonProperty("areacode")
    private Integer areacode;
    @JsonProperty("booktour")
    private Integer booktour;
    @JsonProperty("cat1")
    private String cat1;
    @JsonProperty("cat2")
    private String cat2;
    @JsonProperty("cat3")
    private String cat3;
    @JsonProperty("contentid")
    private Integer contentid;
    @JsonProperty("contenttypeid")
    private Integer contenttypeid;
    @JsonProperty("createdtime")
    private Long createdtime;
    @JsonProperty("firstimage")
    private String firstimage;
    @JsonProperty("firstimage2")
    private String firstimage2;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("mapx")
    private Double mapx;
    @JsonProperty("mapy")
    private Double mapy;
    @JsonProperty("mlevel")
    private Integer mlevel;
    @JsonProperty("modifiedtime")
    private Long modifiedtime;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("sigungucode")
    private Integer sigungucode;
    @JsonProperty("title")
    private String title;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("addr1")
    public String getAddr1() {
        return addr1;
    }

    @JsonProperty("addr1")
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    @JsonProperty("addr2")
    public String getAddr2() {
        return addr2;
    }

    @JsonProperty("addr2")
    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    @JsonProperty("areacode")
    public Integer getAreacode() {
        return areacode;
    }

    @JsonProperty("areacode")
    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
    }

    @JsonProperty("booktour")
    public Integer getBooktour() {
        return booktour;
    }

    @JsonProperty("booktour")
    public void setBooktour(Integer booktour) {
        this.booktour = booktour;
    }

    @JsonProperty("cat1")
    public String getCat1() {
        return cat1;
    }

    @JsonProperty("cat1")
    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    @JsonProperty("cat2")
    public String getCat2() {
        return cat2;
    }

    @JsonProperty("cat2")
    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    @JsonProperty("cat3")
    public String getCat3() {
        return cat3;
    }

    @JsonProperty("cat3")
    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    @JsonProperty("contentid")
    public Integer getContentid() {
        return contentid;
    }

    @JsonProperty("contentid")
    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    @JsonProperty("contenttypeid")
    public Integer getContenttypeid() {
        return contenttypeid;
    }

    @JsonProperty("contenttypeid")
    public void setContenttypeid(Integer contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    @JsonProperty("createdtime")
    public Long getCreatedtime() {
        return createdtime;
    }

    @JsonProperty("createdtime")
    public void setCreatedtime(Long createdtime) {
        this.createdtime = createdtime;
    }

    @JsonProperty("firstimage")
    public String getFirstimage() {
        return firstimage;
    }

    @JsonProperty("firstimage")
    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    @JsonProperty("firstimage2")
    public String getFirstimage2() {
        return firstimage2;
    }

    @JsonProperty("firstimage2")
    public void setFirstimage2(String firstimage2) {
        this.firstimage2 = firstimage2;
    }

    @JsonProperty("homepage")
    public String getHomepage() {
        return homepage;
    }

    @JsonProperty("homepage")
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @JsonProperty("mapx")
    public Double getMapx() {
        return mapx;
    }

    @JsonProperty("mapx")
    public void setMapx(Double mapx) {
        this.mapx = mapx;
    }

    @JsonProperty("mapy")
    public Double getMapy() {
        return mapy;
    }

    @JsonProperty("mapy")
    public void setMapy(Double mapy) {
        this.mapy = mapy;
    }

    @JsonProperty("mlevel")
    public Integer getMlevel() {
        return mlevel;
    }

    @JsonProperty("mlevel")
    public void setMlevel(Integer mlevel) {
        this.mlevel = mlevel;
    }

    @JsonProperty("modifiedtime")
    public Long getModifiedtime() {
        return modifiedtime;
    }

    @JsonProperty("modifiedtime")
    public void setModifiedtime(Long modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("sigungucode")
    public Integer getSigungucode() {
        return sigungucode;
    }

    @JsonProperty("sigungucode")
    public void setSigungucode(Integer sigungucode) {
        this.sigungucode = sigungucode;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("zipcode")
    public String getZipcode() {
        return zipcode;
    }

    @JsonProperty("zipcode")
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
        sb.append(com.Matchurkorea.Match.domain.Detail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("addr1");
        sb.append('=');
        sb.append(((this.addr1 == null)?"<null>":this.addr1));
        sb.append(',');
        sb.append("addr2");
        sb.append('=');
        sb.append(((this.addr2 == null)?"<null>":this.addr2));
        sb.append(',');
        sb.append("areacode");
        sb.append('=');
        sb.append(((this.areacode == null)?"<null>":this.areacode));
        sb.append(',');
        sb.append("booktour");
        sb.append('=');
        sb.append(((this.booktour == null)?"<null>":this.booktour));
        sb.append(',');
        sb.append("cat1");
        sb.append('=');
        sb.append(((this.cat1 == null)?"<null>":this.cat1));
        sb.append(',');
        sb.append("cat2");
        sb.append('=');
        sb.append(((this.cat2 == null)?"<null>":this.cat2));
        sb.append(',');
        sb.append("cat3");
        sb.append('=');
        sb.append(((this.cat3 == null)?"<null>":this.cat3));
        sb.append(',');
        sb.append("contentid");
        sb.append('=');
        sb.append(((this.contentid == null)?"<null>":this.contentid));
        sb.append(',');
        sb.append("contenttypeid");
        sb.append('=');
        sb.append(((this.contenttypeid == null)?"<null>":this.contenttypeid));
        sb.append(',');
        sb.append("createdtime");
        sb.append('=');
        sb.append(((this.createdtime == null)?"<null>":this.createdtime));
        sb.append(',');
        sb.append("firstimage");
        sb.append('=');
        sb.append(((this.firstimage == null)?"<null>":this.firstimage));
        sb.append(',');
        sb.append("firstimage2");
        sb.append('=');
        sb.append(((this.firstimage2 == null)?"<null>":this.firstimage2));
        sb.append(',');
        sb.append("homepage");
        sb.append('=');
        sb.append(((this.homepage == null)?"<null>":this.homepage));
        sb.append(',');
        sb.append("mapx");
        sb.append('=');
        sb.append(((this.mapx == null)?"<null>":this.mapx));
        sb.append(',');
        sb.append("mapy");
        sb.append('=');
        sb.append(((this.mapy == null)?"<null>":this.mapy));
        sb.append(',');
        sb.append("mlevel");
        sb.append('=');
        sb.append(((this.mlevel == null)?"<null>":this.mlevel));
        sb.append(',');
        sb.append("modifiedtime");
        sb.append('=');
        sb.append(((this.modifiedtime == null)?"<null>":this.modifiedtime));
        sb.append(',');
        sb.append("overview");
        sb.append('=');
        sb.append(((this.overview == null)?"<null>":this.overview));
        sb.append(',');
        sb.append("sigungucode");
        sb.append('=');
        sb.append(((this.sigungucode == null)?"<null>":this.sigungucode));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("zipcode");
        sb.append('=');
        sb.append(((this.zipcode == null)?"<null>":this.zipcode));
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

}
