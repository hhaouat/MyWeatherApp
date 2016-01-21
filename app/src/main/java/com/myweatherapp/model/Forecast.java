package com.myweatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Toshiba on 18/01/2016.
 */
public class Forecast {

    @JsonProperty("code")
    private String code;

    @JsonProperty("date")
    private String date;

    @JsonProperty("day")
    private String day;

    @JsonProperty("high")
    private String high;

    @JsonProperty("low")
    private String low;

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

    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    @JsonProperty("high")
    public String getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(String high) {
        this.high = high;
    }

    @JsonProperty("low")
    public String getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(String low) {
        this.low = low;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }
}
