package com.magang.plnicon.controller;

import com.magang.plnicon.entity.ERole;
import com.magang.plnicon.entity.RefreshToken;
import com.magang.plnicon.entity.Role;
import com.magang.plnicon.entity.User;
import com.magang.plnicon.exception.RefreshTokenException;
import com.magang.plnicon.exception.RoleException;
import com.magang.plnicon.jwt.JwtUtils;
import com.magang.plnicon.payload.request.LoginRequest;
import com.magang.plnicon.payload.request.RoleRequest;
import com.magang.plnicon.payload.request.SignupRequest;
import com.magang.plnicon.payload.request.TokenRefreshRequest;
import com.magang.plnicon.payload.response.JWTResponse;
import com.magang.plnicon.payload.response.MessageResponse;
import com.magang.plnicon.payload.response.TokenRefreshResponse;
import com.magang.plnicon.security.CustomUserDetails;
import com.magang.plnicon.service.impl.RefreshTokenService;
import com.magang.plnicon.service.impl.RoleService;
import com.magang.plnicon.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {



    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    UserService userService;

    RoleService roleService;

    RefreshTokenService refreshTokenService;

    AuthenticationManager authenticationManager;

    PasswordEncoder encoder;

    JwtUtils jwtUtils;

    @Autowired
    public AuthController(UserService userService, RoleService roleService, RefreshTokenService refreshTokenService,
                          AuthenticationManager authenticationManager, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.userService = userService;
        this.roleService = roleService;
        this.refreshTokenService = refreshTokenService;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/addrole")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addRole(@RequestBody RoleRequest roleRequest) {

        String roleName = roleRequest.getRoleName();
        Role role = null;

        switch (roleName) {
            case "ROLE_ADMIN":

                role = new Role(ERole.ROLE_ADMIN);

                break;


            case "ROLE_AHLI_GIZI":

                role = new Role(ERole.ROLE_AHLI_GIZI);

                break;


            case "ROLE_KABUPATEN":

                role = new Role(ERole.ROLE_KABUPATEN);

                break;


            case "ROLE_KADER":

                role = new Role(ERole.ROLE_KADER);

                break;


            case " ROLE_KECAMATAN":

                role = new Role(ERole.ROLE_KECAMATAN);

                break;


            case "ROLE_KELURAHAN":

                role = new Role(ERole.ROLE_KELURAHAN);

                break;


            case "ROLE_PROVINSI":

                role = new Role(ERole.ROLE_PROVINSI);

                break;


            default:

                role = new Role(ERole.ROLE_USER);
                ;
        }

        roleService.saveRole(role);

        return ResponseEntity.badRequest().body(new MessageResponse("Role: " + roleName + "saved "));
    }

/*
    String roleName = roleRequest.getRoleName();
    Role role = null;

        switch (roleName) {
        case "ROLE_ADMIN":

            role = new Role(ERole.ROLE_ADMIN);

            break;


        case "ROLE_AHLI_GIZI":

            role = new Role(ERole.ROLE_AHLI_GIZI);

            break;


        case "ROLE_KABUPATEN":

            role = new Role(ERole.ROLE_KABUPATEN);

            break;


        case "ROLE_KADER":

            role = new Role(ERole.ROLE_KADER);

            break;


        case " ROLE_KECAMATAN":

            role = new Role(ERole.ROLE_KECAMATAN);

            break;


        case "ROLE_KELURAHAN":

            role = new Role(ERole.ROLE_KELURAHAN);

            break;


        case "ROLE_PROVINSI":

            role = new Role(ERole.ROLE_PROVINSI);

            break;


        default:

            role = new Role(ERole.ROLE_USER);
            ;
    }

        roleService.saveRole(role);

        return ResponseEntity.badRequest().body(new MessageResponse("Role: " + roleName + "saved "));
}*/



    @PostMapping("/signup")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

        LOGGER.info("AuthController | registerUser is started");

        String username = signUpRequest.getUsername();
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();
        String posyandu = signUpRequest.getPosyandu();
        String kelurahan = signUpRequest.getKelurahan();
        String kecamatan = signUpRequest.getKecamatan();
        String kabupaten = signUpRequest.getKabupaten();
        String provinsi = signUpRequest.getProvinsi();
        String dinkes_kabupaten = signUpRequest.getDinkes_kabupaten();
        String dinkes_provinsi = signUpRequest.getDinkes_provinsi();
        Boolean active = signUpRequest.getActive();
//        String approval_status = signUpRequest.getApproval_status();


        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (userService.existsByUsername(username)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(email)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
        }

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setPosyandu(posyandu);
        user.setKelurahan(kelurahan);
        user.setKecamatan(kecamatan);
        user.setKabupaten(kabupaten);
        user.setProvinsi(provinsi);
        user.setDinkes_kabupaten(dinkes_kabupaten);
        user.setDinkes_provinsi(dinkes_provinsi);
        user.setActive(active);
//        user.setApproval_status(approval_status);


        if (strRoles != null) {
            strRoles.forEach(role -> {
                LOGGER.info("AuthController | registerUser | role : " + role);
                switch (role) {
                    case "ROLE_ADMIN":

                        Role adminRole = null;

                        if (roleService.findByName(ERole.ROLE_ADMIN).isEmpty()) {
                            adminRole = new Role(ERole.ROLE_ADMIN);
                        } else {
                            adminRole = roleService.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RoleException("Error: Admin Role is not found."));
                        }

                        roles.add(adminRole);
                        break;


                    case "ROLE_AHLI_GIZI":

                        Role ahliGiziRole = null;

                        if (roleService.findByName(ERole.ROLE_AHLI_GIZI).isEmpty()) {
                            ahliGiziRole = new Role(ERole.ROLE_AHLI_GIZI);
                        } else {
                            ahliGiziRole = roleService.findByName(ERole.ROLE_AHLI_GIZI)
                                    .orElseThrow(() -> new RoleException("Error: Ahli Gizi Role is not found."));
                        }

                        roles.add(ahliGiziRole);
                        break;


                    case "ROLE_KABUPATEN":

                        Role kabupatenRole = null;

                        if (roleService.findByName(ERole.ROLE_KABUPATEN).isEmpty()) {
                            kabupatenRole = new Role(ERole.ROLE_KABUPATEN);
                        } else {
                            kabupatenRole = roleService.findByName(ERole.ROLE_KABUPATEN)
                                    .orElseThrow(() -> new RoleException("Error: Kabupaten Role is not found."));
                        }

                        roles.add(kabupatenRole);

                        break;


                    case "ROLE_KADER":

                        Role kaderRole = null;

                        if (roleService.findByName(ERole.ROLE_KADER).isEmpty()) {
                            kaderRole = new Role(ERole.ROLE_KADER);
                        } else {
                            kaderRole = roleService.findByName(ERole.ROLE_KADER)
                                    .orElseThrow(() -> new RoleException("Error: Kader Role is not found."));
                        }

                        roles.add(kaderRole);

                        break;


                    case "ROLE_KECAMATAN":

                        Role kecamatanRole = null;

                        if (roleService.findByName(ERole.ROLE_KECAMATAN).isEmpty()) {
                            kecamatanRole = new Role(ERole.ROLE_KECAMATAN);
                        } else {
                            kecamatanRole = roleService.findByName(ERole.ROLE_KECAMATAN)
                                    .orElseThrow(() -> new RoleException("Error: Kecamatan Role is not found."));
                        }

                        roles.add(kecamatanRole);

                        break;


                    case "ROLE_KELURAHAN":

                        Role kelurahanRole = null;

                        if (roleService.findByName(ERole.ROLE_KELURAHAN).isEmpty()) {
                            kelurahanRole = new Role(ERole.ROLE_KELURAHAN);
                        } else {
                            kelurahanRole = roleService.findByName(ERole.ROLE_KELURAHAN)
                                    .orElseThrow(() -> new RoleException("Error: Kelurahan Role is not found."));
                        }

                        roles.add(kelurahanRole);

                        break;


                    case "ROLE_PROVINSI":

                        Role provinsiRole = null;

                        if (roleService.findByName(ERole.ROLE_PROVINSI).isEmpty()) {
                            provinsiRole = new Role(ERole.ROLE_PROVINSI);
                        } else {
                            provinsiRole = roleService.findByName(ERole.ROLE_PROVINSI)
                                    .orElseThrow(() -> new RoleException("Error: Provinsi Role is not found."));
                        }

                        roles.add(provinsiRole);

                        break;


                    default:

                        Role userRole = null;

                        if (roleService.findByName(ERole.ROLE_USER).isEmpty()) {
                            userRole = new Role(ERole.ROLE_USER);
                        } else {
                            userRole = roleService.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RoleException("Error: User Role is not found."));
                        }

                        roles.add(userRole);

                }

            });
        } else {

            roleService.findByName(ERole.ROLE_USER).ifPresentOrElse(roles::add, () -> roles.add(new Role(ERole.ROLE_USER)));
        }

        roleService.saveRoles(roles);
        user.setRoles(roles);
        userService.saveUser(user);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        LOGGER.info("AuthController | authenticateUser is started");

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        LOGGER.info("AuthController | authenticateUser | username : " + username);
        LOGGER.info("AuthController | authenticateUser | password : " + password);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        LOGGER.info("AuthController | authenticateUser | usernamePasswordAuthenticationToken : " + usernamePasswordAuthenticationToken.toString());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);

        LOGGER.info("AuthController | authenticateUser | jwt : " + jwt);

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        LOGGER.info("AuthController | authenticateUser | roles : " + roles.toString());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

        LOGGER.info("AuthController | authenticateUser | refreshToken : " + refreshToken.toString());

        JWTResponse jwtResponse = new JWTResponse();
        jwtResponse.setEmail(userDetails.getEmail());
        jwtResponse.setUsername(userDetails.getUsername());
        jwtResponse.setId(userDetails.getId());
        jwtResponse.setToken(jwt);
        jwtResponse.setRefreshToken(refreshToken.getToken());
        jwtResponse.setRoles(roles);

        LOGGER.info("AuthController | authenticateUser | jwtResponse : " + jwtResponse.toString());

        return ResponseEntity.ok(jwtResponse);
    }


    @PostMapping("/logout")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")//    @ApiIgnore
    public ResponseEntity<?> logoutUser( Principal principalUser) {

        LOGGER.info("AuthController | logoutUser is started");

        Object principal = ((UsernamePasswordAuthenticationToken) principalUser).getPrincipal();
        CustomUserDetails user = (CustomUserDetails) principal;

        int userId = user.getId();

        LOGGER.info("AuthController | logoutUser | userId : " + userId);

        int deletedValue = refreshTokenService.deleteByUserId(userId);

        if (deletedValue == 1) {
            return ResponseEntity.ok(new MessageResponse("Log out successful!"));
        } else {
            return ResponseEntity.ok(new MessageResponse("You're already logout"));
        }

    }

    @PostMapping("/refreshtoken")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> refreshtoken(@RequestBody TokenRefreshRequest request) {

        LOGGER.info("AuthController | refreshtoken is started");

        String requestRefreshToken = request.getRefreshToken();

        LOGGER.info("AuthController | refreshtoken | requestRefreshToken : " + requestRefreshToken);

        RefreshToken token = refreshTokenService.findByToken(requestRefreshToken)
                .orElseThrow(() -> new RefreshTokenException(requestRefreshToken + "Refresh token is not in database!"));

        LOGGER.info("AuthController | refreshtoken | token : " + token.toString());

        RefreshToken deletedToken = refreshTokenService.verifyExpiration(token);

        LOGGER.info("AuthController | refreshtoken | deletedToken : " + deletedToken.toString());

        User userRefreshToken = deletedToken.getUser();

        LOGGER.info("AuthController | refreshtoken | userRefreshToken : " + userRefreshToken.toString());

        String newToken = jwtUtils.generateTokenFromUsername(userRefreshToken.getUsername());

        LOGGER.info("AuthController | refreshtoken | newToken : " + newToken);

        return ResponseEntity.ok(new TokenRefreshResponse(newToken, requestRefreshToken));

    }

}




