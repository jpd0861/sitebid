package com.stronghaul.sitebid.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stronghaul.sitebid.controllers.AdminController.CategoryResponse;
import com.stronghaul.sitebid.models.Product;
import com.stronghaul.sitebid.models.ProductCategory;
import com.stronghaul.sitebid.services.PostgresDbService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final PostgresDbService postgresDbService;

    public AdminController(PostgresDbService postgresDbService) {
        this.postgresDbService = postgresDbService;
    }

    //#region Product Category Endpoints
    @PostMapping ("/category-get")
    public ResponseEntity<ArrayList<ProductCategory>> getProductCategory(@RequestBody GetCategoryRequest request) {
        ArrayList<ProductCategory> categories = postgresDbService.getProductCategory(request.id());
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/category-save")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody SaveCategoryRequest request) {
        ProductCategory category = postgresDbService.saveProductCategory(request.category());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponse.from(category));
    }

    @PostMapping("/category-update")
    public ResponseEntity<CategoryResponse> updateCategory(@RequestBody ProductCategory request) {
        ProductCategory category = postgresDbService.updateProductCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponse.from(category));
    }

    public record GetCategoryRequest(
            Long id) {
    }

    public record SaveCategoryRequest(
            Long Id,
            String category) {
    }

    public record CategoryResponse(
            Long id,
            String category) {

        private static CategoryResponse from(ProductCategory category) {
            return new CategoryResponse(
                    category.getId(),
                    category.getCategory());
        }
    }
    //#endregion

    //#region Product Endpoints
    @PostMapping ("/product-get")
    public ResponseEntity<ArrayList<Product>> getProduct(@RequestBody GetProductRequest request) {
        ArrayList<Product> products = postgresDbService.getProduct(request.id());
        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/product-save")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody Product request) {
        Product product = postgresDbService.saveProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse.from(product));
    }

    @PostMapping("/product-update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody Product product) {
        Product updatedProduct = postgresDbService.updateProduct(product);
        return ResponseEntity.ok(ProductResponse.from(updatedProduct));
    }

    public record GetProductRequest(
            Long id) {
    }

    public record SaveProductRequest(
            Long id,
            String description,
            Double averageWeight,
            Long productCategoryId) {
    }

    public record ProductResponse(
            Long id,
            String description,
            Double averageWeight,
            Long productCategoryId) {

        private static ProductResponse from(Product product) {
            return new ProductResponse(
                    product.getId(),
                    product.getDescription(),
                    product.getAverageWeight(),
                    product.getProductCategoryId());
        }
    }
    //#endregion
}
