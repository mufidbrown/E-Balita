package com.magang.plnicon.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Tindak_lanjuts")
@Data
@NoArgsConstructor
public class TindakLanjutPuskesmas {

/*
    table ini digunakan untuk menindak lanjuti request
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tindakan;

    private String action_puskesmas;
    //action:Sudah ditangani


//    @ManyToOne
//    @JoinColumn(name = "id_balitas")
//    private Balita balita;

    @OneToOne
    @JoinColumn(name = "id_balitas")
    private Balita balita;

}
