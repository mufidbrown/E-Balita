package com.magang.plnicon.service;


import com.magang.plnicon.payload.request.auth.SignupRequest;

/**
 * This interface defines authentication and authorization services.
 */
public interface AuthService {
    /**
     * Registers a new user based on the provided signup request.
     *
     * @param request The signup request containing user registration information.
     * @return A string representing the result of the registration process.
     */
    String register(SignupRequest request);

    /**
     * Logs a user in using the provided login credentials.
     *
     * @param request The login request containing user login credentials.
     * @return A {@link JWTResponse} containing a JWT token and related information upon successful login.
     */
}
