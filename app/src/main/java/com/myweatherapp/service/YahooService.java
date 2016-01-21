package com.myweatherapp.service;

import retrofit2.JacksonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Hawazine on 18/01/2016.
 */
public class YahooService {

    private YahooService() { }

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://query.yahooapis.com")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    static public WeatherService weatherService = retrofit.create(WeatherService.class);
}
