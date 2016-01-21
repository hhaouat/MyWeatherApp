package com.myweatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Toshiba on 20/01/2016.
 */
@JsonIgnoreProperties({ "distance","pressure","speed" })
public class Units {

    @JsonProperty("temperature")
    private String temperature;

    @JsonProperty("temperature")
    public String getTemperature() {
        return temperature;
    }

    @JsonProperty("temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

}
