package com.example.homeplate.api;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClientFacotry {
    static Retrofit apiClientSeed = null;


    static Retrofit GetApiClientSeed() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        if (apiClientSeed == null) {
            apiClientSeed = new Retrofit.Builder()
                    .baseUrl("http://coms-309-058.cs.iastate.edu:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return apiClientSeed;
    }
    public static UserApi GetUserApi(){return GetApiClientSeed().create(UserApi.class);}
    //public static PhotoApi GetPhotoApi(){return GetApiClientSeed().create(PhotoApi.class);}
}
