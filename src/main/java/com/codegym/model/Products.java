package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "Name")
    private String nameProduct;
    @Column(name = "Config")
    private String configProduct;
    @Column(name = "Model")
    private  String model;
    @Column(name = "Price")
    private Long priceProduct;
    @Column(name = "Amount")
    private Long amount;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
