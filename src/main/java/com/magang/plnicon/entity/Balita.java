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

    @Column(name = "NAMA_LENGKAP")
    private String namaLengkap;

    @Column(name = "UMUR")
    private Integer umur;

    @Column(name = "NAMA_AYAH")
    private String namaAyah;

    @Column(name = "NAMA_IBU")
    private String namaIbu;

    @Column(name = "TELEPON")
    private String telepon;

    @Column(name = "ALAMAT")
    private String alamat;


    @OneToMany(mappedBy = "balita")
    private List<BidanRecord> bidanRecords;

}
