package com.stronghaul.sitebid.models;

public class SupplierInventory {
    private Long id = 0L;
    private SupplierInventoryCategory supplierInventoryCategory = new SupplierInventoryCategory();
    private String product = "";
    private String productDeliveryType = "";
    private double averageWeightPerUnit = 0.0;
    private String productDescription = "";
    private Supplier supplier = new Supplier();

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public SupplierInventoryCategory getSupplierInventoryCategory() {
        return supplierInventoryCategory;
    }
    public void setSupplierInventoryCategory(SupplierInventoryCategory value) {
        this.supplierInventoryCategory = value;
    }

    public String getProduct() {
        return product;
    }
    public void setProduct(String value) {
        this.product = value;
    }

    public String getProductDeliveryType() {
        return productDeliveryType;
    }
    public void setProductDeliveryType(String value) {
        this.productDeliveryType = value;
    }

    public double getAverageWeightPerUnit() {
        return averageWeightPerUnit;
    }
    public void setAverageWeightPerUnit(double value) {
        this.averageWeightPerUnit = value;
    }

    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String value) {
        this.productDescription = value;
    }

    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier value) {
        this.supplier = value;
    }
}
