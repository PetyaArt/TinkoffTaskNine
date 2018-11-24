package ru.tinkoff.ru.seminar.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Calendar;

import ru.tinkoff.ru.seminar.model.Weather;

public class WeatherDeserializer implements JsonDeserializer<Weather> {
    @Override
    public Weather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        return new Weather(
                jsonObject.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString(),
                DateFormat.getDateInstance(DateFormat.FULL).format(Calendar.getInstance().getTime()),
                jsonObject.get("main").getAsJsonObject().get("temp").getAsFloat(),
                jsonObject.get("wind").getAsJsonObject().get("speed").getAsFloat()
        );
    }
}
