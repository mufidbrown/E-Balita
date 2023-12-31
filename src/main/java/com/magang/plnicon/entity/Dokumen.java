package com.magang.plnicon.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Dokumens")
@Data
@NoArgsConstructor
public class Dokumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String nama_dokumen;
    private String dokumen;
    private String tanggal_dokumen;
    private String keterangan;
    private String upload_by;

//    @ManyToOne
//    @JoinColumn(name = "id_laporan_balitas")
//    private LaporanBalita laporanBalita;

}
