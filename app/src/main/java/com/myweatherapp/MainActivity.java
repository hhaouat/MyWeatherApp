package com.myweatherapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.myweatherapp.map.MapsFragment;
import com.myweatherapp.model.Condition;
import com.myweatherapp.model.Units;
import com.myweatherapp.model.Weather;
import com.myweatherapp.service.YahooService;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hawazine on 18/01/2016.
 */

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, MapsFragment.OnMapReadyListener
{
    private Weather mWeatherQuery;

    @Bind(R.id.picWeather)
    public ImageView picWeather;


    @Bind(R.id.temperature)
    public TextView txtTemperature;


    @Bind(R.id.container)
    public LinearLayout mainLayout;

    @Bind(R.id.condition)
    public TextView txtCondition;

    MapsFragment mapsFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null)
        {
            mapsFrag = MapsFragment.newInstance();
            getFragmentManager().beginTransaction()
                    .add(R.id.container, mapsFrag, "fragment_maps")
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void onMapReadyListener(String city)
    {
        String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")", city);
        Call<Weather> weatherQuery = YahooService.weatherService.getWeather(YQL, "json");

        weatherQuery.enqueue(new Callback<Weather>() {

            @Override
            public void onResponse(Response<Weather> response) {
                mWeatherQuery = response.body();

                Condition condition = mWeatherQuery.getCondition();
                Units units = mWeatherQuery.getUnits();

                int tempCelcius;

                displayPictureWeather(condition);

                tempCelcius = displayTempAndCondition(condition, units);

                changeBackgroundColor(tempCelcius);

            }

            private void displayPictureWeather(Condition condition)
            {
                int resourceId = getResources().getIdentifier("drawable/icon_" + condition.getCode(), null, getPackageName());
                picWeather.setImageDrawable(getResources().getDrawable(resourceId));
            }

            private int displayTempAndCondition(Condition condition, Units units)
            {
                int tempCelcius;
                tempCelcius = getTempCelcius(condition, units);

                txtTemperature.setText(tempCelcius + "°");
                txtCondition.setText(condition.getText());
                return tempCelcius;
            }

            private int getTempCelcius(Condition condition, Units units)
            {
                int tempCelcius;

                if (units.getTemperature().equalsIgnoreCase("f"))
                    tempCelcius = convertFahrenheitToCelcius(Float.parseFloat(condition.getTemp()));
                else
                    tempCelcius = Integer.parseInt(condition.getTemp());

                return tempCelcius;
            }

            //change color background
            private void changeBackgroundColor(int tempCelcius) {

                if (tempCelcius > 20)
                {
                    mainLayout.setBackgroundColor(Color.parseColor("#F5DA81"));
                }
                if (tempCelcius <= 20)
                {
                    mainLayout.setBackgroundColor(Color.parseColor("#A9BCF5"));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Failed", t.getMessage());
            }
        });
    }

    // Converts to celcius
    private int convertFahrenheitToCelcius(float fahrenheit) {

        Float celcius = (fahrenheit - 32) * 5 / 9;

        return (Math.round(celcius));
    }
}