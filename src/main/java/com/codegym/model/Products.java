package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private String manufacturer;

    private String configProduct;
    private Long priceProduct;
    private Long amountProduct;
    private String descriptionProduct;
    private String imageProduct;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
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
