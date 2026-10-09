package com.stronghaul.sitebid.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stronghaul.sitebid.models.VendorProduct;

public class VendorProductDto {
    private ArrayList<VendorProduct> vendorProducts;

    public ArrayList<VendorProduct> map(ResultSet resultSet) throws SQLException {
        this.vendorProducts = new ArrayList<VendorProduct>();
        while (resultSet.next()) {
            VendorProduct vp = new VendorProduct();
            vp.setId(resultSet.getLong("id"));
            vp.setVendorId(resultSet.getLong("vendor_id"));
            vp.setProductId(resultSet.getLong("product_id"));
            vp.setRetail(resultSet.getDouble("retail"));
            vp.setDiscountPercentage(resultSet.getDouble("discount_percentage"));
            this.vendorProducts.add(vp);
        }
        return this.vendorProducts;
    }
}
