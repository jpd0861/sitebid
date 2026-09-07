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

    public void setId(Long id) {
        this.id = id;
    }

    public SupplierInventoryCategory getSupplierInventoryCategory() {
        return supplierInventoryCategory;
    }

    public void setSupplierInventoryCategory(SupplierInventoryCategory supplierInventoryCategory) {
        this.supplierInventoryCategory = supplierInventoryCategory;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductDeliveryType() {
        return productDeliveryType;
    }

    public void setProductDeliveryType(String productDeliveryType) {
        this.productDeliveryType = productDeliveryType;
    }

    public double getAverageWeightPerUnit() {
        return averageWeightPerUnit;
    }

    public void setAverageWeightPerUnit(double averageWeightPerUnit) {
        this.averageWeightPerUnit = averageWeightPerUnit;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
