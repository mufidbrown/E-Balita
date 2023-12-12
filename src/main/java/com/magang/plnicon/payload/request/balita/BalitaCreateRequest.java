package com.magang.plnicon.payload.request.balita;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a request object for creating a new book.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalitaCreateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

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
