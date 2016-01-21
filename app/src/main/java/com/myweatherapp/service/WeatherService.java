package com.myweatherapp.service;


import com.myweatherapp.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hawazine on 18/01/2016.
 */
public interface WeatherService {

    @GET("/v1/public/yql")
    Call<Weather> getWeather(
            @retrofit2.http.Query("q") String q,
            @retrofit2.http.Query("format") String format
    );
}
