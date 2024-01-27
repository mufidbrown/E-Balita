package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Imunisasis")
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

//    imunisasi ambil nama sama tanggal lahir balita, berarti one to many

//    @ManyToOne
//    @JoinColumn(name = "id_laporan_balitas")
//    private LaporanBalita laporanBalita;

}


