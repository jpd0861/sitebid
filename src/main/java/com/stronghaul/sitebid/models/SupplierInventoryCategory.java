package com.stronghaul.sitebid.models;

public class SupplierInventoryCategory {
    private Long id = 0L;
    private String categoryName = "";
    private String description = "";

    // Getters and Setters
    public Long getId() {
        return this.id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
    public void setCategoryName(String value) {
        this.categoryName = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }
}
