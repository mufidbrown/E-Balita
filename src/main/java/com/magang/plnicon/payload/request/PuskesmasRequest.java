package com.magang.plnicon.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuskesmasRequest {

    @NotBlank
    private String nama_puskesmas;

    @NotBlank
    private String jenis_puskesmas;

    @NotBlank
    private String alamat;

    @NotBlank
    private String kecamatan;

    @NotBlank
    private String kabupaten;

    @NotBlank
    private String provinsi;

    @NotBlank
    private String status;
}
