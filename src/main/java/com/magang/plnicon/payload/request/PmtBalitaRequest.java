package com.magang.plnicon.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmtBalitaRequest {

    @NotBlank
    private String nama_balita;

    @NotBlank
    private String tanggal_pmt;

    @NotBlank
    private String makanan_pmt;

    @NotBlank
    private String keterangan;

}
