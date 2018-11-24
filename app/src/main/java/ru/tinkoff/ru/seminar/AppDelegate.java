package ru.tinkoff.ru.seminar;

import android.app.Application;
import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static ru.tinkoff.ru.seminar.until.Constant.BASE_URL;

public class AppDelegate extends Application {

    private Api apiService;

    public static AppDelegate from(Context context) {
        return (AppDelegate) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initRetrofit();
    }

    public Api getApiService() {
        return apiService;
    }

    private void initRetrofit() {
        apiService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(Api.class);
    }
}
