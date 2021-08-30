package com.example.tez.di;

import android.net.TrafficStats;

import androidx.core.content.PermissionChecker;

import com.example.tez.BuildConfig;
import com.example.tez.api.ApiService;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.internal.JavaNetCookieJar;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Abhinav Singh on 17,June,2020
 */

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {

    @Singleton
    @Provides
     public OkHttpClient getOkHttpClient() {
        OkHttpClient client = new OkHttpClient();

        if (client == null) {
            if (BuildConfig.DEBUG) {
                // set your desired log level
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                CookieHandler cookieHandler = new CookieManager();

                client = new OkHttpClient().newBuilder()
                        .addInterceptor(logging)
                        .build();
            } else {
                client = new OkHttpClient().newBuilder()

                        .build();
                TrafficStats.setThreadStatsTag(0x1000);

            }
        }
        return client;
    }
    @Provides
    @Singleton
    public static ApiService providePokemonApiService(OkHttpClient okHttpClient){

        return  new Retrofit.Builder()
                .baseUrl("http://operation.tez-tour.com/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ApiService.class);
    }
}
