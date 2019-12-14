package com.codegym.model;

import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "blog")
    private List<Blog> blog;

    private String nameCategory;

    public Category() {
    }

    public Category(List<Blog> blog, String nameCategory) {
        this.blog = blog;
        this.nameCategory = nameCategory;
    }

    public Long getId() {
        return id;
    }

    public List<Blog> getBlog() {
        return blog;
    }

    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
