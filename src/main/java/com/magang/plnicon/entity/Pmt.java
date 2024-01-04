package com.magang.plnicon.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Pmt")
@Data
@NoArgsConstructor
public class Pmt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String makanan_pmt;
    private String kalori_pmt;
    private String keterangan;
    private String status;
}
