package com.magang.plnicon.service;

import com.magang.plnicon.entity.User;

/**
 * This interface defines a service for managing refresh tokens.
 */
public interface RefreshTokenService {
    /**
     * Creates a new refresh token for the specified user.
     *
     * @param user The user for whom the refresh token is created.
     * @return A string representing the newly created refresh token.
     */
    String createRefreshToken(User user);
}
