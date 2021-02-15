package com.sapient.XYZecommmarket.domain;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="type")
    private ProductType type;

    @ManyToOne
    @JoinColumn(name="supplier")
    private Supplier supplier;

    @Column(name="AVAILABLE_COUNT")
    private Integer availableCount;

    @Column
    private Double price;

    @Column
    private Integer size;

    @Column
    private String color;

    public Product(Long id, String name, Brand brand, ProductType type, Supplier supplier, Integer availableCount, Double price, Integer size, String color) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.supplier = supplier;
        this.availableCount = availableCount;
        this.price = price;
        this.size = size;
        this.color = color;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Product [id=%s, name=%s]", id, name);
    }

}
