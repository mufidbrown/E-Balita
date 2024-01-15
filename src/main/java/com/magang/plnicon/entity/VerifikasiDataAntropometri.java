package com.magang.plnicon.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Verifikasi_data_antropometris")
@Data
@NoArgsConstructor
public class VerifikasiDataAntropometri {

/*
    Si VerifikasiDataAntropometri mengambil data dari Antropometri & Balita
*/

/*
    untuk nama Column di VerifikasiDataAntropometri dari table Antropometri adalah: hasil
*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "antropometri_id")
    private Antropometri antropometri;

    private Boolean isValid;
    private String status;

/*

    private Integer antropometriId; // ID dari data antropometri yang diverifikasi
    private Boolean isValid;
*/




}
