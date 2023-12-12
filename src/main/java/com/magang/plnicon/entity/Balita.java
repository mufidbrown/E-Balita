package com.magang.plnicon.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BALITAS")
public class Balita extends BaseEntity{

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


    @OneToMany(mappedBy = "balita")
    private List<BidanRecord> bidanRecords;

}
