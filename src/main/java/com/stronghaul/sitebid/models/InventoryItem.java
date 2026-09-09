package com.stronghaul.sitebid.models;


public class InventoryItem extends Supplier{
    private Long id;
    private String product;
    private String productDescription;
    private String productDeliveryType;
    private double averageWeightPerUnit;
    private LineItemCategory category = new LineItemCategory();

    public Long getId(){
        return this.id;
    }
    public void setId(Long value){
        this.id = value;
    }

    public String getProduct(){
        return this.product;
    }
    public void setProduct(String value){
        this.product = value;
    }

    public String getProductDescription(){
        return this.productDescription;
    }
    public void setProductDescription(String value){
        this.productDescription = value;
    }

    public String getProductDeliveryType(){
        return this.productDeliveryType;
    }
    public void setProductDeliveryType(String value){
        this.productDeliveryType = value;
    }

    public double getAverageWeightPerUnit(){
        return this.averageWeightPerUnit;
    }
    public void setAverageWeightPerUnit(double value){
        this.averageWeightPerUnit = value;
    }

    public LineItemCategory getCategory(){
        return this.category;
    }
    public void setCategory (LineItemCategory value){
        this.category = value;
    }
}
