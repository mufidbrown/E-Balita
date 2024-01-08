package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Balita")
@Data
@NoArgsConstructor
public class Balita {

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

}