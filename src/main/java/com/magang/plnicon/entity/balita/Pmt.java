package com.magang.plnicon.entity.balita;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Pmt_balita")
@Data
@NoArgsConstructor
public class Pmt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String tanggal_pmt;
    private String makanan_pmt;
    private String keterangan;
}