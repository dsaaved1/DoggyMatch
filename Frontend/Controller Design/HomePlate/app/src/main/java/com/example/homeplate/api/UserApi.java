package com.example.homeplate.api;
import java.util.List;
import com.example.homeplate.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {
    @GET("user/1")
    Call<User> getFirstUser();
    @GET("user")
    Call<List<User>> getAllUser();
    @GET("user/email/{email}")
    Call<User> getUserByEmail(@Path("email") String email);

    @GET("user/{userNum}")
    Call<User> getUserByNum(@Path("userNum") String userNum);
}