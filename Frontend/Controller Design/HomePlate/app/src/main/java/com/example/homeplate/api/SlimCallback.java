package com.example.homeplate.api;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/** part of the retrofit library used so we dont have to constantly write code for the callback every time a server request is made
 * @author Mark Gores
 * @param <T> Is the user
 */
public class SlimCallback<T> implements Callback<T> {

    LambdaInterface<T> lambdaInterface;

    String logTag;


    /**
     * makes the call to the server
     * @param lambdaInterface telling the server what is needed
     */
    public SlimCallback(LambdaInterface<T> lambdaInterface){
        this.lambdaInterface = lambdaInterface;
    }

    /**
     * makes server call
     * @param lambdaInterface tells server what is needed
     * @param customTag custom error message for debugging
     */
    public SlimCallback(LambdaInterface<T> lambdaInterface, String customTag){
        this.lambdaInterface = lambdaInterface;
        this.logTag = customTag;
    }


    /**
     * gets the reponse from the server and determines if it was successfull or a failure
     * @param call call to server
     * @param response reponse from server
     */
    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()){
            lambdaInterface.doSomething(response.body());
        }
        else{
            Log.d(logTag, "Code:  "+response.code() + "    Msg:  "+response.message());
        }

    }

    /**
     * tells what to do if the response was a failure
     * @param call call to server
     * @param t throwable error
     */
    @Override
    public void onFailure(Call<T> call, Throwable t) {

        Log.d(logTag, "Thrown:  "+t.getMessage());

    }
}
