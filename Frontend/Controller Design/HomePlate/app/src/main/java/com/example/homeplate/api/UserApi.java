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
    /**
     * gets the first user in the data base
     * @return first User
     */
    @GET("user/1")
    Call<User> getFirstUser();

    /**
     * gets all the user from database including current user
     * @return
     */
    @GET("user")
    Call<List<User>> getAllUser();

    /**
     * gets a specific user by their email
     * @param email
     * @return User
     */
    @GET("user/email/{email}")
    Call<User> getUserByEmail(@Path("email") String email);

    /**
     * gets the user by their ID
     * @param userNum Id of user
     * @return User
     */
    @GET("user/{userNum}")
    Call<User> getUserByNum(@Path("userNum") String userNum);

    /**
     * attempts to login a user with email and password
     * @param user
     * @return successful or failure
     */
    @POST("user/sign-in")
    Call<User> signin(@Body User user);

    /*
    @GET("user/everybody/{userEmail}")
    Call<List<User>> getAll(@Path("userEmail") String email);*/
    /**
     * gets all users except the current user (used to find matches)
     * @param email
     * @return list of users
     */
    @GET("user/everybody/{email}")
    Call<List<User>> getEverbody (@Path("email") String email);

    /**
     * gets a users preferences
     * @param userNum
     * @return user preferences
     */
    @GET("user/register/preference/id/{userNum}")
    Call<Preferences> getUserPref(@Path("userNum") String userNum);

    /**
     * creates a new user on the server
     * @param user
     * @return successful
     */
    @POST("user")
    Call<User> postuser(@Body User user );
   // @POST("user")
   // Call<User> updateUser(@Body User user, @Path int id);
    /**
     * used for when a current user "likes" another user, liked user is moved to potential match
     * and if liked user also likes current user a match is created
     * @param userId current users id
     * @param userId1 liked users id
     * @return poential match
     */
    @PUT("user/home/match/{id},{id2}")
    Call<User> match(@Path("id") int userId, @Path("id2")int userId1);
    @PUT("moderator/home/delete/{email},{id}")
    Call<User> delete(@Path("email") String email, @Path("id") int id);
    @PUT("user/register/{id}")
    Call<User> update(@Body User user, @Path("id") int id);
    @GET("/dog{num}.jpg")
    Call<User> photo(@Path("num") int num);


}
