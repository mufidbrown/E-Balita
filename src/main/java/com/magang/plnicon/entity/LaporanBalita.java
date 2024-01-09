package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "LaporanBalita")
@Data
@NoArgsConstructor
public class LaporanBalita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String nik;
    private String tempat_lahir;
    private String tanggal_lahir;
    private String jenis_kelamin;
    private String anak_ke;
    private String nama_ayah;
    private String nama_ibu;
    private String no_handphone;
    private String posyandu;
    private String puskesmas;
    private String status;

    @OneToMany(mappedBy = "laporanBalita")
    private List<Antropometri> antropometriList;

    @OneToMany(mappedBy = "laporanBalita")
    private List<Imunisasi> imunisasiList;

}