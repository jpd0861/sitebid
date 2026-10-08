package com.stronghaul.sitebid.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stronghaul.sitebid.models.ProductCategory;
import com.stronghaul.sitebid.services.PostgresDbService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final PostgresDbService postgresDbService;

    public AdminController(PostgresDbService postgresDbService) {
        this.postgresDbService = postgresDbService;
    }

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
}
