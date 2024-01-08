package com.magang.plnicon.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImunisasiRequest {

    @NotBlank
    private String nama_balita;

    @NotBlank
    private String usia_bulan;

    @NotBlank
    private String tanggal_imunisasi;

    @NotBlank
    private String jenis_imunisasi;

    @NotBlank
    private String keterangan;

}
