package com.example.homeplate.api;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** Retrofit library that links front end to back end
 * @author Mark Gores
 */
public class ApiClientFacotry {
    static Retrofit apiClientSeed = null;


    static Retrofit GetApiClientSeed() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        if (apiClientSeed == null) {
            apiClientSeed = new Retrofit.Builder()
                    //for local host testing
                    //.baseUrl("http://10.0.2.2:8080/")
                    .baseUrl("http://coms-309-058.cs.iastate.edu:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return apiClientSeed;
    }

    /**
     * sends the server request to get the user information
     * @return user from the server data base
     */
    public static UserApi GetUserApi(){return GetApiClientSeed().create(UserApi.class);}
    //public static PhotoApi GetPhotoApi(){return GetApiClientSeed().create(PhotoApi.class);}
}
