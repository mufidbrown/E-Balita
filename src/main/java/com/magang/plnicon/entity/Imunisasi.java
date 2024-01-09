package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Imunisasi")
@Data
@NoArgsConstructor
public class Imunisasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String usia_bulan;
    private String tanggal_imunisasi;
    private String jenis_imunisasi;
    private String keterangan;

    @ManyToOne
    @JoinColumn(name = "laporan_balita_id")
    private LaporanBalita laporanBalita;

}


