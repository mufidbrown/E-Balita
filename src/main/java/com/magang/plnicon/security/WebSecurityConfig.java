package com.magang.plnicon.security;

import com.magang.plnicon.jwt.AuthEntryPointJwt;
import com.magang.plnicon.jwt.AuthTokenFilter;
import com.magang.plnicon.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    CustomUserDetailsService customUserDetailsService;;

    private AuthEntryPointJwt unauthorizedHandler;

    JwtUtils jwtUtils;

    @Autowired
    public WebSecurityConfig(CustomUserDetailsService customUserDetailsService, AuthEntryPointJwt unauthorizedHandler,JwtUtils jwtUtils) {
        this.customUserDetailsService = customUserDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
        this.jwtUtils = jwtUtils;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests().antMatchers(
                        "/api/v1/auth/**",
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/swagger-resources/configuration/ui",
                        "/swagger-ui.html",
                        "/swagger-resources/configuration/security",

                        "/api/pages/**",
                        "/api/v1/antropometri/**",
                        "/api/v1/balita/**",
                        "/api/v1/dokumen/**",
                        "/api/v1/imunisasi/**",
                        "/api/v1/knowledge/**",
                        "/api/v1/laporan/**",
                        "/api/v1/monitoringtindakan/**",
                        "/api/v1/pengguna/**",
                        "/api/v1/pmtbalita/**",
                        "/api/v1/pmt/**",
                        "/api/v1/posyandu/**",
                        "/api/v1/puskesmas/**",
                        "/api/v1/admin/requests/**",
                        "/api/v1/tindaklanjut/**",
                        "/api/v1/tumbuhkembang/**",
                        "/api/v1/verifikasidataantropometri/**",
                        "/api/v1/vitamin/**"


//                        "/docs.html",
//                        "/my-api/**",
//                        "/auth/**",
//                        "/swagger-ui/**"
                ).permitAll()
                .antMatchers("/api/pages/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(jwtUtils,customUserDetailsService), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter(JwtUtils jwtUtils, CustomUserDetailsService customUserDetailsService) {
        return new AuthTokenFilter(jwtUtils, customUserDetailsService);
    }
}

