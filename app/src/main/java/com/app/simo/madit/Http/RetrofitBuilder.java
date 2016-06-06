package com.app.simo.madit.Http;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static Retrofit ourInstance = null;

    public static Retrofit build() {
        if (ourInstance == null) {
            ourInstance = new Retrofit
                    .Builder()//192.168.43.218:8080 http://madt.patrickoryono.co/"
                    .baseUrl("http://madt.patrickoryono.co/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return ourInstance;
    }

}
