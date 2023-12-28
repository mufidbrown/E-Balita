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
public class User extends IdBasedEntity implements Serializable {

    private String username;
    private String email;
    private String password;
    private String kelurahan;
    private String kecamatan;
    private String kabupaten;
    private String provinsi;
    private String dinkes_kabupaten;
    private String dinkes_provinsi;
//    private String approval_status;


    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
//    private Set<Role> level_user = new HashSet<>();
//    private Set<Role> level_administrasi = new HashSet<>();


}
