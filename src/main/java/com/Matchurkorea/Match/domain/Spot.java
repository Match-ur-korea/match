package com.Matchurkorea.Match.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
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
        "cat1",
        "cat2",
        "cat3",
        "contentid",
        "contenttypeid",
        "createdtime",
        "firstimage",
        "firstimage2",
        "mapx",
        "mapy",
        "mlevel",
        "modifiedtime",
        "readcount",
        "sigungucode",
        "title",
        "zipcode"
})
@Generated("jsonschema2pojo")
public class Spot {

    @JsonProperty("addr1")
    private String addr1;
    @JsonProperty("addr2")
    private String addr2;
    @JsonProperty("areacode")
    private Integer areacode;
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
    @JsonProperty("mapx")
    private String mapx;
    @JsonProperty("mapy")
    private Double mapy;
    @JsonProperty("mlevel")
    private Integer mlevel;
    @JsonProperty("modifiedtime")
    private Long modifiedtime;
    @JsonProperty("readcount")
    private Integer readcount;
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

    @JsonProperty("mapx")
    public String getMapx() {
        return mapx;
    }

    @JsonProperty("mapx")
    public void setMapx(String mapx) {
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

    @JsonProperty("readcount")
    public Integer getReadcount() {
        return readcount;
    }

    @JsonProperty("readcount")
    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
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

}