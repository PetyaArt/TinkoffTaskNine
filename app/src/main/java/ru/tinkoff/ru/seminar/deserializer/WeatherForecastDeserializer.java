package ru.tinkoff.ru.seminar.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ru.tinkoff.ru.seminar.model.Weather;

public class WeatherForecastDeserializer implements JsonDeserializer<List<Weather>> {

    @Override
    public List<Weather> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        List<Weather> weathers = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);

        for (int i = 0; i < jsonObject.get("list").getAsJsonArray().size(); i++) {
            weathers.add(new Weather(
                    jsonObject.get("list").getAsJsonArray().get(i).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString(),
                    DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime()),
                    jsonObject.get("list").getAsJsonArray().get(i).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsFloat(),
                    jsonObject.get("list").getAsJsonArray().get(i).getAsJsonObject().get("wind").getAsJsonObject().get("speed").getAsFloat()));
        }

        return weathers;
    }
}
