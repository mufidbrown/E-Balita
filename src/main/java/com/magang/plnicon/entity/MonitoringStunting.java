package com.magang.plnicon.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "monitoring_stunting")
public class MonitoringStunting {

    /*ini adalah
            table transaksi*/

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String hasilPantau;
        private String tindakan;

        @ManyToOne
        @JoinColumn(name = "balitas_id")
        private Balita balita;
//
//        @ManyToOne
//        @JoinColumn(name = "id_puskesmas", nullable = false)
//        private Puskesmas puskesmas;
//
//        @ManyToOne
//        @JoinColumn(name = "id_posyandu", nullable = false)
//        private Posyandu posyandu;
//
//        @ManyToOne
//        @JoinColumn(name = "id_pmt", nullable = false)
//        private Pmt pmt;
//
//        @ManyToOne
//        @JoinColumn(name = "id_pengguna", nullable = false)
//        private Pengguna pengguna;

}
