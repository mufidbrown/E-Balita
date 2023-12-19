package com.magang.plnicon.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


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

   /* @ManyToOne
    @JoinColumn(name = "balitaId", referencedColumnName = "balitaId")
    private Balita balita;

    @ManyToOne
    @JoinColumn(name = "bidanId", referencedColumnName = "bidanId")
    private Bidan bidan;

    @CreationTimestamp
    private LocalDateTime tanggal;

    @Column(length = 1000)
    private String catatan;*/

//    ini yang asli
    @ManyToOne
    @JoinColumn(name = "balitaId")
    private Balita balita;

//    ini yang asli
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bidanId", referencedColumnName = "id")
    private Bidan bidan;


}

