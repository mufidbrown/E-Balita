package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Requests")
@Data
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @OneToOne
    @JoinColumn(name = "users_id")
    private User user;

/*    jadi user mengajukan request tanpa "Status": ;
    kemudian si Admin melanjutkan pengajuan dari user tersebut dengan menggunakan controller put reject, accepted, & pending*/


    //@OneToMany
    //@JoinColumn(name = "users_id")
    //private User user;

/*
    Jadi nanti dibuatkan sebuah tampilan Front end khusus halaman request ini
*/

    /*  jadi alurnya seperti ini:  selain itu User juga bisa melakukan pengajuan setelah login,
        melalui form/page tersendiri untuk pengajuan, di page tersebut user bisa memantau sewaktu2*/

}
