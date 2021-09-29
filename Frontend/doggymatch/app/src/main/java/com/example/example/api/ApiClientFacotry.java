package com.example.example.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClientFacotry {
    static Retrofit apiClientSeed = null;

    static Retrofit GetApiClientSeed() {

        if (apiClientSeed == null) {
            apiClientSeed = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return apiClientSeed;
    }
    public static UserApi GetUserApi(){return GetApiClientSeed().create(UserApi.class);}
    public static PhotoApi GetPhotoApi(){return GetApiClientSeed().create(PhotoApi.class);}
}
