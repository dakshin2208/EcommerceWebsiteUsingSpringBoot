package com.ecommerce.Project.controller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Categories")
public class Category {
    @Id
    private Long id;
    private String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {}

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
}
