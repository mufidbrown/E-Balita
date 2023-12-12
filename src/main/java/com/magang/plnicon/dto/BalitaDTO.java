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

    @NotBlank
    private String namaLengkap;

    @NotNull
    @Min(value = 0, message = "Usia tidak boleh kurang dari 0")
    private Integer umur;

    @NotBlank
    private String namaAyah;

    @NotBlank
    private String namaIbu;

    @NotBlank
    private String telepon;

    @NotBlank
    private String alamat;

}