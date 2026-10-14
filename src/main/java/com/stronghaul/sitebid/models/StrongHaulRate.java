package com.stronghaul.sitebid.models;

public class StrongHaulRate {

    private String error;
    private Double additionalCharges;
    private Product product;
    private Double retail;
    private Integer quantity;
    private Double discoutPercentage;
    private Double subTotal;
    private Double salesTax;
    private Double total;

    public String getError(){
        return this.error;
    }
    public void setError(String value){
        this.error = value;
    }

    public Double getAdditionalCharges(){
        return this.additionalCharges;
    }
    public void setAdditionalCharges(Double value){
        this.additionalCharges = value;
    }

    public Product getProduct(){
        return this.product;
    }
    public void setProduct(Product value){
        this.product = value;
    }

    public Double getRetail(){
        return this.retail;
    }
    public void setRetail(Double value){
        this.retail = value;
    }

    public Integer getQuantity(){
        return this.quantity;
    }
    public void setQuantity(Integer value){
        this.quantity = value;
    }

    public Double getDiscountPercentage(){
        return this.discoutPercentage;
    }
    public void setDiscountPercentage(Double value){
        this.discoutPercentage = value;
    }

    public Double getSubTotal(){
        return this.subTotal;
    }
    public void setSubTotal(Double value){
        this.subTotal = value;
    }

    public Double getSalesTax(){
        return this.salesTax;
    }
    public void setSalesTax(Double value){
        this.salesTax = value;
    }

    public Double getTotal(){
        return this.total;
    }
    public void setTotal(Double value){
        this.total = value;
    }
}
