package com.magang.plnicon.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PenggunaRequest {

    @NotBlank
    private String nama_lengkap;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String roles;

    @NotBlank
    private String puskesmas;

    @NotBlank
    private String kelurahan;

    @NotBlank
    private String kecamatan;

    @NotBlank
    private String kabupaten;

    @NotBlank
    private String provinsi;

    @NotBlank
    private String keterangan;

    @NotBlank
    private String status;
}
