package com.magang.plnicon.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Approval")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Approval implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pending;
    private String approved;
    private String rejected;



//    @ManyToMany
//    @JoinTable(
//            name = "User_Approval",
//            joinColumns = @JoinColumn(name = "approval_status"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> approvedUsers;
//iki ws bener


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Collection<Role> roles;

}

