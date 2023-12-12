package com.magang.plnicon.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BIDAN_RECORDS")
public class BidanRecord extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "balitaId")
    private Balita balita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bidanId", referencedColumnName = "id")
    private Bidan bidan;
}


