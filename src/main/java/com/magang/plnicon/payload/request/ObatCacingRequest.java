package com.magang.plnicon.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObatCacingRequest {

    @NotBlank
    private String nama_balita;

    @NotBlank
    private String usia_bulan;

    @NotBlank
    private String tanggal_pemberian_obat;

    @NotBlank
    private String nama_obat;

    @NotBlank
    private String keterangan;

}
