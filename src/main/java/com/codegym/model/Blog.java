package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "category")

    private String nameCategory;

    public Blog() {
    }

    public Blog(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Long getId() {
        return id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}