package com.magang.plnicon.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Posyandus")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Posyandu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_posyandu;
    private String nama_puskesmas;
    private String alamat;
    private String kelurahan;
    private String kecamatan;
    private String kabupaten;
    private String provinsi;
    private String status;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
