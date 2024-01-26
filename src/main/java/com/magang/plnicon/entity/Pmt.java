package com.magang.plnicon.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pmts")
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

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @OneToMany(mappedBy = "pmt")
    private List<Balita> balitas;
}
