package com.stronghaul.sitebid.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stronghaul.sitebid.models.Product;
import com.stronghaul.sitebid.models.ProductCategory;
import com.stronghaul.sitebid.models.Vendor;
import com.stronghaul.sitebid.models.VendorProduct;
import com.stronghaul.sitebid.services.ProductCategoryService;
import com.stronghaul.sitebid.services.ProductService;
import com.stronghaul.sitebid.services.VendorProductService;
import com.stronghaul.sitebid.services.VendorService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired private ProductService productService;
    @Autowired private ProductCategoryService productCategoryService;
    @Autowired private VendorService vendorService;
    @Autowired private VendorProductService vendorProductService;

    //#region Product Category Endpoints
    @PostMapping ("/category-get")
    public ResponseEntity<ArrayList<ProductCategory>> getProductCategory(@RequestBody GetCategoryRequest request) {
        ArrayList<ProductCategory> categories = productCategoryService.get(request.id());
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/category-save")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody SaveCategoryRequest request) {
        ProductCategory category = productCategoryService.create(request.category());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponse.from(category));
    }

    @PostMapping("/category-update")
    public ResponseEntity<CategoryResponse> updateCategory(@RequestBody ProductCategory request) {
        ProductCategory category = productCategoryService.update(request);
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
        ArrayList<Product> products = productService.get(request.id());
        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/product-save")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody Product request) {
        Product product = productService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse.from(product));
    }

    @PostMapping("/product-update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.update(product);
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

    //#region Vendor Endpoints
    @PostMapping ("/vendor-get")
    public ResponseEntity<ArrayList<Vendor>> getVendor(@RequestBody GetVendorRequest request) {
        ArrayList<Vendor> vendors = vendorService.get(request.id());
        if (!vendors.isEmpty()) {
            return ResponseEntity.ok(vendors);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/vendor-save")
    public ResponseEntity<VendorResponse> createVendor(@RequestBody Vendor request) {
        Vendor vendor = vendorService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(VendorResponse.from(vendor));
    }

    @PostMapping("/vendor-update")
    public ResponseEntity<VendorResponse> updateVendor(@RequestBody Vendor vendor) {
        Vendor updatedVendor = vendorService.update(vendor);
        return ResponseEntity.ok(VendorResponse.from(updatedVendor));
    }

    public record GetVendorRequest(
            Long id) {
    }

    public record SaveVendorRequest(
            Long id,
            String companyName,
            Long addressId,
            Double discountPercentage,
            String phone) {
    }

    public record VendorResponse(
            Long id,
            String companyName,
            Long addressId,
            Double discountPercentage,
            String phone) {

        private static VendorResponse from(Vendor vendor) {
            return new VendorResponse(
                    vendor.getId(),
                    vendor.getCompanyName(),
                    vendor.getAddressId(),
                    vendor.getDiscountPercentage(),
                    vendor.getPhone());
        }
    }
    //#endregion


    //#region Vendor Product Endpoints
    @PostMapping ("/vendor-product-get")
    public ResponseEntity<ArrayList<VendorProduct>> getVendorProducts(@RequestBody GetVendorRequest request) {
        ArrayList<VendorProduct> vendorProducts = vendorProductService.get(request.id());
        if (!vendorProducts.isEmpty()) {
            return ResponseEntity.ok(vendorProducts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/vendor-product-save")
    public ResponseEntity<VendorProductResponse> createVendorProduct(@RequestBody VendorProduct request) {
        VendorProduct vendorProduct = vendorProductService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(VendorProductResponse.from(vendorProduct));
    }

    @PostMapping("/vendor-product-update")
    public ResponseEntity<VendorProductResponse> updateVendorProduct(@RequestBody VendorProduct vendorProduct) {
        VendorProduct updatedVendorProduct = vendorProductService.update(vendorProduct);
        return ResponseEntity.ok(VendorProductResponse.from(updatedVendorProduct));
    }

    public record GetVendorProductRequest(
            Long id) {
    }

    public record SaveVendorProductRequest(
            Long id,
            String companyName,
            Long addressId,
            Double discountPercentage,
            String phone) {
    }

    public record VendorProductResponse(
            Long id,
            Long vendorId,
            Long productId,
            Double discountPercentage,
            Double retail) {

        private static VendorProductResponse from(VendorProduct vendorProduct) {
            return new VendorProductResponse(
                    vendorProduct.getId(),
                    vendorProduct.getVendorId(),
                    vendorProduct.getProductId(),
                    vendorProduct.getDiscountPercentage(),
                    vendorProduct.getRetail());
        }
    }
    //#endregion
}
