package com.myweatherapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Hawazine on 18/01/2016.
 */

public class Weather {

    @JsonProperty("query")
    private Query query;

    @JsonProperty("query")
    public Query getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(Query query) {
        this.query = query;
    }

    public Channel getChannel() {
        return query.getResults().getChannel();
    }

    public Condition getCondition() {
        return query.getResults().getChannel().getItem().getCondition();
    }

    public Image getImage() {
        return query.getResults().getChannel().getImage();
    }

    public Units getUnits() {
        return query.getResults().getChannel().getUnits();
    }
    /*public Item getItem() {
        return query.getResults().getItem();
    }*/

}