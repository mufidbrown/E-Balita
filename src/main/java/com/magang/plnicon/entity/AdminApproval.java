package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Admin_approvals")
@Data
@NoArgsConstructor
public class AdminApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private boolean approved;

}
