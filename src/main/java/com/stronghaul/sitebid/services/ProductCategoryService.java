package com.stronghaul.sitebid.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.ProductCategory;

@Service 
public class ProductCategoryService {
    @Autowired private PostgresDbService postgresDbService;

    public ProductCategory create(String category) {
        return postgresDbService.saveProductCategory(category);
    }

    public ProductCategory update(ProductCategory category) {
        return postgresDbService.updateProductCategory(category);
    }

    public ArrayList<ProductCategory> get(Long id) {
        return postgresDbService.getProductCategory(id);
    }
}
