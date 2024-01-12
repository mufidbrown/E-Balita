package com.magang.plnicon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "line_chart")
public class Data {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String category;
    @Column
    private Double series;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Double getSeries() {
        return series;
    }
    public void setSeries(Double series) {
        this.series = series;
    }
    @Override
    public String toString() {
        return "Data [id=" + id + ", category=" + category + ", series="
                + series + "]";
    }

}
