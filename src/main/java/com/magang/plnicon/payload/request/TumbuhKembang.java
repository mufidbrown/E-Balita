package com.magang.plnicon.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TumbuhKembang {

    @NotBlank
    private String usia_bulan;

    @NotBlank
    private String tanggal_sampel;

    @NotBlank
    private String jumlah_indikator;

    @NotBlank
    private String hasil;
}
