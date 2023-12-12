package com.magang.plnicon.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


/**
 * Data Transfer Object (DTO) representing user information.
 */
@Getter
@Builder
@EqualsAndHashCode
public class BalitaDTO {

    private String id;
    private String namaLengkap;
    private Integer umur;
    private String namaAyah;
    private String namaIbu;
    private String telepon;
    private String alamat;

}