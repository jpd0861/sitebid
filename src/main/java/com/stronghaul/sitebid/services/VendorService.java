package com.stronghaul.sitebid.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.Vendor;

@Service 
public class VendorService {
    @Autowired private PostgresDbService postgresDbService;

    public Vendor create(Vendor vendor) {
        return postgresDbService.saveVendor(vendor);
    }

    public Vendor update(Vendor vendor) {
        return postgresDbService.updateVendor(vendor);
    }

    public ArrayList<Vendor> get(Long id) {
        return postgresDbService.getVendors(id);
    }
}
