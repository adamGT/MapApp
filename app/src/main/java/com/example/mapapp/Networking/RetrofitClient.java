package com.example.mapapp.Networking;

import android.content.Context;
import android.util.Log;

import com.example.mapapp.BuildConfig;
import com.example.mapapp.storage.SharedPreferenceManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Context context;

    public static final String BASE_URL = BuildConfig.BASE_URL; //"http:/10.5.192.51:3030";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    private static RetrofitClient clientinstance;
    private Retrofit retrofit;



    OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {

                    Request request = chain.request();

                    if(true)
                    {
                        Request.Builder newRequest = request.newBuilder().header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJ1c2VySWQiOiI1ZDYzZjcwY2VmMWNhZDAwMWJkMWNkMjUiLCJpYXQiOjE1Njc3Nzc4MDUsImV4cCI6MTU5OTMzNTQwNSwiYXVkIjoiaHR0cHM6Ly95b3VyZG9tYWluLmNvbSIsImlzcyI6ImZlYXRoZXJzIiwic3ViIjoiYW5vbnltb3VzIiwianRpIjoiOTMwNzlmNDEtNDY1Zi00NGY3LTg0MmYtMDZmMzk1MjM0ZGFiIn0.SooysG2t-EXirVDBTmwltiE9O2fduAiwI2y2p12zOjs");
                        //Headers headers = request.headers().newBuilder().add("Authorization", SharedPreferenceManager.getInstance(context).getUserAccessToken()).build();
                        //request = request.newBuilder().headers(headers).build();

                        Response response = chain.proceed(newRequest.build());


                        int tryCount = 0;
                        while (!response.isSuccessful() && tryCount < 3) {

                            Log.d("intercept", "Request is not successful - " + tryCount);

                            tryCount++;

                            // retry the request
                            response = chain.proceed(request);
                        }

                        return response;
                        //return null;
                    }

                    Response response = chain.proceed(request);

                    int tryCount = 0;
                    while (!response.isSuccessful() && tryCount < 3) {

                        Log.d("intercept", "Request is not successful - " + tryCount);

                        tryCount++;

                        // retry the request
                        response = chain.proceed(request);
                    }

                    return response;
                }
            });


    public RetrofitClient(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

  /*  private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    } */


    public static synchronized RetrofitClient getInstance(Context context){
        if( clientinstance == null)
        {
            clientinstance = new RetrofitClient(context);
        }

        return  clientinstance;
    }

    public API getApi(){
        return retrofit.create(API.class);
    }
}
