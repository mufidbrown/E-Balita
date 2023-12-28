package com.magang.plnicon.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 30)
    private String kelurahan;

    @NotBlank
    @Size(min = 3, max = 20)
    private String kecamatan;

    @NotBlank
    @Size(min = 3, max = 30)
    private String kabupaten;

    @NotBlank
    @Size(min = 3, max = 30)
    private String provinsi;

    @NotBlank
    @Size(min = 3, max = 30)
    private String dinkes_kabupaten;

    @NotBlank
    @Size(min = 3, max = 30)
    private String dinkes_provinsi;

//    @NotBlank
//    @Size(min = 3, max = 30)
//    private String approval_status;


    private Set<String> roles;

}
