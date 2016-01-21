package com.myweatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Toshiba on 18/01/2016.
 */
public class Image {

    @JsonProperty("width")
    private String width;

    @JsonProperty("height")
    private String height;

    @JsonProperty("link")
    private String link;

    @JsonProperty("url")
    private String url;


    @JsonProperty("title")
    private String title;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("width")
    public String getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(String width) {
        this.width = width;
    }

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }


}
