package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Tumbuh_Kembangs")
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

//    @ManyToOne
//    @JoinColumn(name = "id_laporan_balitas")
//    private LaporanBalita laporanBalita;

}