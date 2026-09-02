package com.stronghaul.sitebid.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stronghaul.sitebid.controllers.JobBidController.JobBidResponse;
import com.stronghaul.sitebid.controllers.JobBidController.SaveBidRequest;
import com.stronghaul.sitebid.models.Address;
import com.stronghaul.sitebid.models.JobBid;
import com.stronghaul.sitebid.models.SupplierInventoryCategory;
import com.stronghaul.sitebid.services.PostgresDbService;

@RestController
@RequestMapping("/api/supplierinventory")
public class SupplierInventoryController {
    private final PostgresDbService postgresDbService;

    public SupplierInventoryController(PostgresDbService postgresDbService) {
        this.postgresDbService = postgresDbService;
    }

    public record SaveCategoryRequest(
        String categoryName,
        String categoryDescription) {
    }

    public record SaveCategoryResponse(
        Long id,
        String cat,
        String description) {
        private static SaveCategoryResponse from(SupplierInventoryCategory supplierCategory) {
            return new SaveCategoryResponse(
                    supplierCategory.getId(),
                    supplierCategory.getCategoryName(),
                    supplierCategory.getDescription()
            );
        }
    }

    @PostMapping("/category/save")
    public ResponseEntity<SaveCategoryResponse> saveCategory(@RequestBody SaveCategoryRequest request) {
        SupplierInventoryCategory supplierCategory = new SupplierInventoryCategory();
        supplierCategory.setCategoryName(request.categoryName());
        supplierCategory.setDescription(request.categoryDescription());

        SupplierInventoryCategory savedCategory = postgresDbService.saveSupplierInventoryCategory(supplierCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(SaveCategoryResponse.from(savedCategory));
    }
}
