package com.magang.plnicon.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Topik_forums")
@Data
@NoArgsConstructor
public class TopikForum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String judul;
    private String keterangan;

    @ManyToOne
    @JoinColumn(name = "knowledges_id")
    private Knowledge knowledge;
    

//    @ManyToMany
//    private Set<Knowledge> knowledgeList;



}
