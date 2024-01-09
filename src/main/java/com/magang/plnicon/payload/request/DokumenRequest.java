package com.magang.plnicon.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DokumenRequest {

    @NotBlank
    private Integer id;

    @NotBlank
    private String nama_balita;

    @NotBlank
    private String nama_dokumen;

    @NotBlank
    private String dokumen;

    @NotBlank
    private String tanggal_dokumen;

    @NotBlank
    private String keterangan;

    @NotBlank
    private String upload_by;
}
