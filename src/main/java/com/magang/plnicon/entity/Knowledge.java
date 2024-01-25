package com.magang.plnicon.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Knowledges")
@Data
@NoArgsConstructor
public class Knowledge {

/*
    knowledge musti ada upload file
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String topik;
    private String keterangan;
    private String deskripsi;
    private String name;
    private String type;
    private String imagePath;

//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getImagePath() {
//        return imagePath;
//    }
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }

//    @ManyToMany(mappedBy = "knowledgeList")
//    private Set<TopikForum> topikForums;

}
