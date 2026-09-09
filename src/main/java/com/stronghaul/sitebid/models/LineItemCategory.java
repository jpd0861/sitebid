package com.stronghaul.sitebid.models;

public class LineItemCategory {
    private Long id;
    private String description;
    private String category;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String value) {
        this.description = value;
    }

    public String getCategory() {
        return this.category;
    }
    public void setCategory(String value) {
        this.category = value;
    }
}
