package com.example.example.api;


import com.example.example.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface PostApi{

    @GET("posts/1")
    Call<Post> getFirstPost();
    @GET("posts")
    Call<List<Post>> getAllPost();


    @GET("posts/{postsNum}")
    Call<Post> getPostByNum(@Path("postNum") String postNum);
}

