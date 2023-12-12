package com.magang.plnicon.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BALITAS")
public class Balita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
