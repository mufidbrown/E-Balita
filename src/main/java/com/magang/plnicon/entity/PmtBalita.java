package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Pmt_balitas")
@Data
@NoArgsConstructor
public class PmtBalita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String tanggal_pmt;
    private String makanan_pmt;
    private String keterangan;

//    @ManyToOne
//    @JoinColumn(name = "laporan_balita_id")
//    private LaporanBalita laporanBalita;


//    @ManyToOne
//    @JoinColumn(name = "id_laporan")
//    private LaporanBalita laporanBalita;
}


//    @ManyToOne
//    @JoinColumn(name = "id_laporan_balitas")
//    private LaporanBalita laporanBalita;