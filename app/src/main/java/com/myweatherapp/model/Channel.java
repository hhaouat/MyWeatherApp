package com.myweatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Toshiba on 19/01/2016.
 */
@JsonIgnoreProperties({ "title", "link", "description","language",
        "lastBuildDate","ttl", "location", "wind","atmosphere", "astronomy" })
public class Channel
{
    @JsonProperty("item")
    private Item item;

    @JsonProperty("units")
    private Units units;

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonProperty("image")
    private Image image;

    @JsonProperty("item")
    public Item getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(Item item) {
        this.item = item;
    }

    @JsonProperty("units")
    public Units getUnits() {
        return units;
    }
    @JsonProperty("units")
    public void setUnits(Units units) {
        this.units = units;
    }
}
