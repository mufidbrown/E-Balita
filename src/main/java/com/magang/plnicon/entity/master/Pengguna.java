package com.magang.plnicon.entity.master;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PenggunaRequest")
@Data
@NoArgsConstructor
public class Pengguna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_lengkap;
    private String email;
    private String password;
    private String roles;
    private String puskesmas;
    private String kelurahan;
    private String kecamatan;
    private String kabupaten;
    private String provinsi;
    private String keterangan;
    private String status;
}
