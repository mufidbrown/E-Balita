package com.magang.plnicon.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AntropometriRequest {

    @NotBlank
    private String nama_balita;

    @NotBlank
    private String tanggal_ambil_sampel;

    @NotBlank
    private String usia_balita;

    @NotBlank
    private String berat_badan;

    @NotBlank
    private String tinggi_badan;

    @NotBlank
    private String lingkar_kepala;

    @NotBlank
    private String lingkar_lengan;

    @NotBlank
    private String lingkar_dada;

    @NotBlank
    private String suhu_badan;

    @NotBlank
    private String hasil;

    @NotBlank
    private String foto;

    @NotBlank
    private String keterangan;

}
