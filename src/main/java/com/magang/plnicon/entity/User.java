package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String posyandu;
    private String kelurahan;
    private String kecamatan;
    private String kabupaten;
    private String provinsi;
    private String dinkes_kabupaten;
    private String dinkes_provinsi;
    private boolean active;

//    private String approval_status;


    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}



/*    ini optional
            bisa approve langsung, atau approve nya via method PUT*/

/*    selain itu User juga bisa melakukan pengajuan setelah login,
        melalui form/page tersendiri untuk pengajuan, di page tersebut user bisa memantau sewaktu2*/




//    @Enumerated(EnumType.STRING)
//    private RequestStatus status;

//    @ManyToOne
//    @JoinColumn(name = "id_requests")
//    private Request request;

//    @ManyToOne
//    @JoinColumn(name = "status_requests")
//    private Request request;