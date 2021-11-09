package com.example.homeplate.api;
import java.util.List;
import com.example.homeplate.model.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/** used to get data from the server with the given path
 * @author Mark Gores
 */
public interface UserApi {
    @GET("user/1")
    Call<User> getFirstUser();
    @GET("user")
    Call<List<User>> getAllUser();
    @GET("user/email/{email}")
    Call<User> getUserByEmail(@Path("email") String email);

    @GET("user/{userNum}")
    Call<User> getUserByNum(@Path("userNum") String userNum);
    @POST("user/sign-in")
    Call<User> signin(@Body User user);
    @GET("user/everybody/{userEmail}")
    Call<List<User>> getAll(@Path("userEmail") String email);
    @GET("user/everybody/{email}")
    Call<List<User>> getEverbody (@Path("email") String email);

    @GET("user/register/preference/id/{userNum}")
    Call<Preferences> getUserPref(@Path("userNum") String userNum);
    @POST("user")
    Call<User> postuser(@Body User user );
    @PUT("user/home/match/{id},{id2}")
    Call<User> match(@Path("id") int userId, @Path("id2")int userId1);


}
