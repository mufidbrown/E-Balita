package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "Approval")
@Data
@NoArgsConstructor
public class ApprovalUser  extends IdBasedEntity implements Serializable {

    private String pending;
    private String approved;
    private String rejected;
}
