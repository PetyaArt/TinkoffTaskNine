package ru.tinkoff.ru.seminar.model;

import java.util.List;

public class WeatherObject {
    private Weather mWeather;
    private List<Weather> mWeatherList;

    public WeatherObject(Weather weather, List<Weather> weatherList) {
        mWeather = weather;
        mWeatherList = weatherList;
    }

    public Weather getWeather() {
        return mWeather;
    }

    public void setWeather(Weather weather) {
        mWeather = weather;
    }

    public List<Weather> getWeatherList() {
        return mWeatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        mWeatherList = weatherList;
    }
}
