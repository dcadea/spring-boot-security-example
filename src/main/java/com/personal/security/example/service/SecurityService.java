package com.personal.security.example.service;

public interface SecurityService {

    void authenticate(String username, String password);

    String authenticatedUsername();

}
