package com.magang.plnicon.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Roles")
@NoArgsConstructor
@Getter
@Setter
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    private ERole level_user;
    private ERole level_administrasi;

    public Role(ERole name){
        this.name = name;
    }

    public ERole getName() {
        return name;
    }


//    public Role(ERole level_user){
//        this.level_user = level_user;
//    }
    public ERole getLevel_user() {
        return level_user;
    }

//    public Role(ERole level_administrasi){
//        this.level_administrasi = level_administrasi;
//    }
    public ERole getLevel_administrasi() {
        return level_administrasi;
    }

}