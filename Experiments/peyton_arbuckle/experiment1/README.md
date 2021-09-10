# Experiment 2 - simple web api

## Description

This is a simple web server with spring boot that can create new users and stores them in a hash map. A new user can be created by making a GET request to `http://localhost:8080/users/new?id={id}&name={name}`. To get a user by id, make a GET request to `http://localhost:8080/users/{id}`
