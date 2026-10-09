package com.stronghaul.sitebid.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.Product;

@Service 
public class ProductService {
    @Autowired private PostgresDbService postgresDbService;

    public ArrayList<Product> get(Long id) {
        return postgresDbService.getProducts(id);
    }

    public Product create(Product product) {
        return postgresDbService.saveProduct(product);
    }

    public Product update(Product product) {
        return postgresDbService.updateProduct(product);
    }
}