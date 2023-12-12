package com.magang.plnicon.payload.response.balita;


import lombok.*;

/**
 * Represents a response object for updated book details.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BalitaUpdatedResponse {

    private String id;
    private String namaLengkap;
    private Integer umur;
    private String namaAyah;
    private String namaIbu;
    private String telepon  ;
    private String alamat;
}
