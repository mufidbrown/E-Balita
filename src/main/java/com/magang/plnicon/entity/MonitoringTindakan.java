package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Monitoring_tindakans")
@Data
@NoArgsConstructor
public class MonitoringTindakan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_balitas")
    private Balita balita;

    @ManyToOne
    @JoinColumn(name = "id_tindak_lanjuts")
    private TindakLanjutPuskesmas tindakLanjutPuskesmas;
}
