package com.magang.plnicon.config;

import com.magang.plnicon.security.CustomUserDetailsService;
import com.magang.plnicon.security.jwt.AuthEntryPointJwt;
import com.magang.plnicon.security.jwt.AuthTokenFilter;
import com.magang.plnicon.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Configuration class for Spring Security.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;

    private final AuthEntryPointJwt authEntryPointJwt;

    private final JwtUtils jwtUtils;

    /**
     * Bean for password encoding.
     *
     * @return The password encoder bean.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean for JWT authentication filter.
     *
     * @return The JWT authentication filter bean.
     */
    @Bean
    public AuthTokenFilter jwtAuthenticationFilter() {
        return new AuthTokenFilter(jwtUtils, customUserDetailsService);
    }

    /**
     * Bean for creating an authentication manager.
     *
     * @param authenticationConfiguration The authentication configuration.
     * @return The authentication manager bean.
     * @throws Exception If an exception occurs during configuration.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Configure CORS (Cross-Origin Resource Sharing) settings.
     *
     * @return The CORS configuration source.
     */
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * Configure security filters and policies for HTTP requests.
     *
     * @param httpSecurity The HTTP security configuration.
     * @return The security filter chain.
     * @throws Exception If an exception occurs during configuration.
     */
}
