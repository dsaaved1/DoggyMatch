package com.example.homeplate.api;

/**
 * lamda interface used to get specific information from the server
 * @param <T>
 */
public interface LambdaInterface<T> {
    public void doSomething(T result);
}
