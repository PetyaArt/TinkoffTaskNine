package ru.tinkoff.ru.seminar.model;


import android.support.annotation.NonNull;

@SuppressWarnings("unused")
public class Weather {
    public String description;
    public String time;
    public float temp;
    public float speedWind;

    public Weather(@NonNull String description, String time, float temp, float speedWind) {
        this.description = description;
        this.time = time;
        this.temp = temp - 273.15f;
        this.speedWind = speedWind;
    }

    public Weather() {
        //stub
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                ", time='" + time + '\'' +
                ", temp=" + temp +
                ", speedWind=" + speedWind +
                '}';
    }
}
