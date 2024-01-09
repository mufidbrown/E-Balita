package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Obat_Cacing")
@Data
@NoArgsConstructor
public class ObatCacing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String usia_bulan;
    private String tanggal_pemberian_obat;
    private String nama_obat;
    private String keterangan;

    @ManyToOne
    @JoinColumn(name = "laporan_balita_id")
    private LaporanBalita laporanBalita;

}