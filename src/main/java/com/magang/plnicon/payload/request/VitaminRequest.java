package com.magang.plnicon.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitaminRequest {

    @NotBlank
    private String nama_balita;

    @NotBlank
    private String tanggal_vitamin;

    @NotBlank
    private String usia_bulan;

    @NotBlank
    private String jenis_vitamin;

    @NotBlank
    private String jumlah_vitamin;

    @NotBlank
    private String keterangan;
}
