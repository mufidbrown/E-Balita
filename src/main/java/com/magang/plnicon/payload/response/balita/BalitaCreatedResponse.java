package com.magang.plnicon.payload.response.balita;

import lombok.*;

import java.math.BigDecimal;


/**
 * Represents a response object for book creation, containing book details.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BalitaCreatedResponse {

    private String id;
    private String namaLengkap;
    private Integer umur;
    private String namaAyah;
    private String namaIbu;
    private String telepon  ;
    private String alamat;
}
