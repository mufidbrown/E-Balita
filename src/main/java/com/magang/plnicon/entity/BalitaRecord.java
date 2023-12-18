package com.magang.plnicon.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BalitaRecord")
public class BalitaRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recordId;
    private String notes;
    private LocalDate dateCreated;
    private LocalTime timeCreated;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "balitaId")
    private Balita balita;
//
//    @ManyToOne
//    @JoinColumn(name = "balitaId")
//    private Balita balita;
}
