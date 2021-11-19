package com.example.homeplate.api;

/**
 * lamda interface used to get specific information from the server
 * @param <T>
 */
public interface LambdaInterface<T> {
    /**
     * basic interface to be overridden to communicate with the server
     * @param result
     */
    public void doSomething(T result);
}
