//package com.magang.plnicon.entity;
//
//
//import com.magang.plnicon.service.CatatanBalitaService;
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "Balita_Records")
//public class CatatanBalita {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "balitaId", referencedColumnName = "balitaId")
//    private Balita balita;
//
//    @ManyToOne
//    @JoinColumn(name = "bidanId", referencedColumnName = "bidanId")
//    private Bidan bidan;
//
//    @CreationTimestamp
//    private LocalDateTime tanggal;
//
//    @Column(length = 1000)
//    private String catatan;
//
//}
