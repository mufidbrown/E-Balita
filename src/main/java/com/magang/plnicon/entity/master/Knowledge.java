package com.magang.plnicon.entity.master;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Knowledges")
@Data
@NoArgsConstructor
public class Knowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String topik;
    private String keterangan;
    private String deskripsi;
}
