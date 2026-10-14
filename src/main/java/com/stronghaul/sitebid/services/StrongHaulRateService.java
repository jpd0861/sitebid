package com.stronghaul.sitebid.services;

import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.StrongHaulRate;

@Service 
public class StrongHaulRateService {

    public StrongHaulRate calculate(StrongHaulRate strongHaulRate, Double additionalCharges){
        strongHaulRate.setError("");
        strongHaulRate.setAdditionalCharges(additionalCharges);

        Double subTotal = strongHaulRate.getRetail() * strongHaulRate.getQuantity();
        Double discount = Math.ceil(subTotal * strongHaulRate.getDiscountPercentage());

        strongHaulRate.setSubTotal(subTotal - discount);
        strongHaulRate.setSalesTax(Math.ceil(strongHaulRate.getSubTotal()*.0866));
        strongHaulRate.setTotal(strongHaulRate.getSubTotal() + strongHaulRate.getSalesTax());
        return strongHaulRate;
    }
}
