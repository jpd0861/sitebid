package com.stronghaul.sitebid.validate;

import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.Address;
import com.stronghaul.sitebid.models.Product;
import com.stronghaul.sitebid.models.Vendor;
import com.stronghaul.sitebid.models.VendorProduct;

@Service 
public class StrongHaulFeeValidate {
    private String error;
    public String getError() {
        return this.error;
    }

    private boolean isValidSiteAddress(String siteAddress, String siteZip){
        if(siteAddress == null || siteAddress.trim().isBlank()){
            this.error = "The site address is null";
            return false;
        }

        if(siteZip == null || siteZip.trim().isBlank()){
            this.error = "The site zip code is null";
            return false;
        }
        return true;
    }

    private boolean isValidVendor(Vendor vendor, Address vendorAddress){
        if(vendor == null){
            this.error = "The vendor is null";
            return false;
        }

        if(vendorAddress == null 
            || vendorAddress.getStreet() == null || vendorAddress.getStreet().trim().isBlank()
            || vendorAddress.getZip() == null || vendorAddress.getZip().trim().isBlank()){
            this.error = "The vendor's address is null";
            return false;
        }
        if(vendorAddress.getZip() == null || vendorAddress.getZip().trim().isBlank()){
            this.error = "The vendor's zip code is null";
            return false;
        }
        return true;
    }

    private boolean isValidVendorProduct(Product product, VendorProduct vendorProduct){
        if(product == null){
            this.error = "The product is null";
            return false;
        }

        if(vendorProduct == null){
            this.error = "The vendor's product is null";
            return false;
        }

        Double value = product.getAverageWeight();
        if(value == null || value <=100){
            this.error = "The product's average weight is null or less than 100.";
            return false;
        }
        value = vendorProduct.getRetail();
        if(value == null || value <=0){
            this.error = "The vendor product's retail amount is less than 1.";
            return false;
        }
        return true;
    }

    public boolean isValid(String siteAddress,
        String siteZip,
        Vendor vendor, 
        Address vendorAddress,
        Product product,
        VendorProduct vendorProduct){

        this.error = "";
        if(!isValidSiteAddress(siteAddress, siteZip)){
            return false;
        }
        if(!isValidVendor(vendor, vendorAddress)){
            return false;
        }
        if(!isValidVendorProduct(product, vendorProduct)){
            return false;
        }
        return true;
    }
}
