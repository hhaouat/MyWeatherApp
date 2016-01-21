package com.myweatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Toshiba on 19/01/2016.
 */

public class Condition {

    @JsonProperty("code")
    private String code;

    @JsonProperty("date")
    private String date;

    @JsonProperty("temp")
    private String temp;

    @JsonProperty("text")
    private String text;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("temp")
    public String getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(String temp) {
        this.temp = temp;
    }
}
