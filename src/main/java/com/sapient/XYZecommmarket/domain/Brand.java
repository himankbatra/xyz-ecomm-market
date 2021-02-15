package com.sapient.XYZecommmarket.domain;

import javax.persistence.*;

@Entity
@Table(name = "BRANDS")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
