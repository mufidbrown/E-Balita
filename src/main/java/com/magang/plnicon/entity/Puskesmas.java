package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Puskesmas")
@Data
@NoArgsConstructor
public class Puskesmas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_puskesmas;
    private String jenis_puskesmas;
    private String alamat;
    private String kecamatan;
    private String kabupaten;
    private String provinsi;
    private String status;
}
