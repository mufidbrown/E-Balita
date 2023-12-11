package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.User;
import com.magang.plnicon.exception.orangtua.EmailAlreadyExistsException;
import com.magang.plnicon.exception.orangtua.UserNotFoundException;
import com.magang.plnicon.payload.request.auth.LoginRequest;
import com.magang.plnicon.payload.request.auth.SignupRequest;
import com.magang.plnicon.payload.request.auth.TokenRefreshRequest;
import com.magang.plnicon.payload.response.auth.JWTResponse;
import com.magang.plnicon.payload.response.auth.TokenRefreshResponse;
import com.magang.plnicon.repository.UserRepository;
import com.magang.plnicon.security.jwt.JwtUtils;
import com.magang.plnicon.service.AuthService;
import com.magang.plnicon.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final RefreshTokenService refreshTokenService;

    private final JwtUtils jwtUtils;


    /**
     * Registers a new user based on the provided signup request.
     *
     * @param request The signup request containing user registration information.
     * @return A string representing the result of the registration process.
     */
    @Override
    public String register(SignupRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        User user = User.builder()
                .email(request.getEmail())
                .fullName(request.getFullName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        return "success";
    }

    /**
     * Logs a user in using the provided login credentials.
     *
     * @param request The login request containing user login credentials.
     * @return A {@link JWTResponse} containing a JWT token and related information upon successful login.
     */
    @Override
    public JWTResponse login(LoginRequest request) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtUtils.generateJwtToken(auth);



        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(UserNotFoundException::new);

        return JWTResponse.builder()
                .email(request.getEmail())
                .token(jwtToken)
                .refreshToken(refreshTokenService.createRefreshToken(user))
                .build();

    }


}
