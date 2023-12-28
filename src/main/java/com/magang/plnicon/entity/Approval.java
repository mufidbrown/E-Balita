package com.magang.plnicon.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "Approval")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Approval extends IdBasedEntity implements Serializable {

    private String pending;
    private String approved;
    private String rejected;
}
