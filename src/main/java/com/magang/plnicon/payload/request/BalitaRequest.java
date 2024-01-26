package com.magang.plnicon.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalitaRequest {

    @NotBlank
    private String nama_balita;

    @NotBlank
    private String nik;

    @NotBlank
    private String tempat_lahir;

    @NotBlank
    private String tanggal_lahir;

    @NotBlank
    private String jenis_kelamin;

    @NotBlank
    private String anak_ke;

    @NotBlank
    private String nama_ayah;

    @NotBlank
    private String nama_ibu;

    @NotBlank
    private String no_handphone;

//    @NotBlank
//    private String posyandu;
//
//    @NotBlank
//    private String puskesmas;

    @NotBlank
    private String status;

}
