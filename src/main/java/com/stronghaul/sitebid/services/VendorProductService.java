package com.stronghaul.sitebid.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.VendorProduct;

@Service 
public class VendorProductService {
    @Autowired private PostgresDbService postgresDbService;

    public VendorProduct create(VendorProduct vendorProduct) {
        return postgresDbService.saveVendorProduct(vendorProduct);
    }

    public VendorProduct update(VendorProduct vendorProduct) {
        return postgresDbService.updateVendorProduct(vendorProduct);
    }

    public ArrayList<VendorProduct> get(Long id) {
        return postgresDbService.getVendorProducts(id);
    }

}
