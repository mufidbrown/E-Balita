package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Vitamins")
@Data
@NoArgsConstructor
public class Vitamin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String tanggal_vitamin;
    private String usia_bulan;
    private String jenis_vitamin;
    private String jumlah_vitamin;
    private String keterangan;

    @ManyToOne
    @JoinColumn(name = "laporan_balita_id")
    private LaporanBalita laporanBalita;


}


