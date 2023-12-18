package com.magang.plnicon.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BIDANS")
public class Bidan extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "bidan", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BidanRecord> bidanRecords;


    public void setBidanRecords(List<BidanRecord> bidanRecords) {
        this.bidanRecords = bidanRecords;
        bidanRecords.forEach(bidanRecord -> bidanRecord.setBidan(this));
    }

}
