package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Antropometris")
@Data
@NoArgsConstructor
public class Antropometri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String tanggal_ambil_sampel;
    private String usia_balita;
    private String berat_badan;
    private String tinggi_badan;
    private String lingkar_kepala;
    private String lingkar_lengan;
    private String lingkar_dada;
    private String suhu_badan;
    private String hasil;
    private String foto;
    private String keterangan;


    /*@ManyToOne
    @JoinColumn(name = "balitas_id")
    private Balita balita;*/


}


/*
    @ManyToOne
    @JoinColumn(name = "id_laporan_balitas")
    private LaporanBalita laporanBalita;
*/

