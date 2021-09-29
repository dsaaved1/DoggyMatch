package com.example.example.api;
import java.util.List;
import com.example.example.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {
    @GET("users/1")
    Call<User> getFirstUser();
    @GET("users")
    Call<List<User>> getAllUser();


    @GET("users/{userNum}")
    Call<User> getUserByNum(@Path("userNum") String userNum);
}
