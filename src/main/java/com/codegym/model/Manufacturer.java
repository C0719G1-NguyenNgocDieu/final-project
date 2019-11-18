package com.codegym.model;

import javax.persistence.*;

@Entity(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "model")
    private String model;

    private String nameManufacturer;
}
