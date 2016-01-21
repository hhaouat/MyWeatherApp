package com.myweatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Hawazine on 19/01/2016.
 */
class Results
{
    public Results() {
    }
    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }
    @JsonProperty("channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @JsonProperty("channel")
    private Channel channel;
}