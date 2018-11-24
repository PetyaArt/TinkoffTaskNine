package ru.tinkoff.ru.seminar;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    @GET("data/2.5/weather")
    Observable<String> getCurrentWeather(
            @Query("q") String cityNameAndCountryCode,
            @Query("APPID") String key);

    @GET("data/2.5/forecast")
    Observable<String> getForecastWeather(
            @Query("q") String cityNameAndCountryCode,
            @Query("APPID") String key);
}
