package com.stronghaul.sitebid.models;

public class ProductCategory {
    private Long id = 0L;
    private String category = "";

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String value) {
        this.category = value;
    }

}
