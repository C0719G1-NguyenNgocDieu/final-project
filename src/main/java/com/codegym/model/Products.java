package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "Name")
    private String nameProduct;
    @Column(name = "Config")
    private String configProduct;
    @Column(name = "Price")
    private Long priceProduct;
    @Column(name = "Amount")
    private Long amountProduct;
    @Column(name = "Description")
    private String descriptionProduct;
    @Column(name = "Image")
    private String imageProduct;

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getConfigProduct() {
        return configProduct;
    }

    public void setConfigProduct(String configProduct) {
        this.configProduct = configProduct;
    }

    public Long getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Long priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Long getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(Long amountProduct) {
        this.amountProduct = amountProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }
}
