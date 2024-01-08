package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "TumbuhKembang")
@Data
@NoArgsConstructor
public class TumbuhKembang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String usia_bulan;
    private String tanggal_sampel;
    private String jumlah_indikator;
    private String hasil;

}