package com.magang.plnicon.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmtRequest {

    @NotBlank
    private String makanan_pmt;

    @NotBlank
    private String kalori_pmt;

    @NotBlank
    private String keterangan;

    @NotBlank
    private String status;
}
