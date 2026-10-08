package com.stronghaul.sitebid.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stronghaul.sitebid.models.Product;

public class ProductDto {
    private ArrayList<Product> products;

    public ArrayList<Product> map(ResultSet resultSet) throws SQLException {
        this.products = new ArrayList<Product>();
        while (resultSet.next()) {
            Product p = new Product();
            p.setId(resultSet.getLong("id"));
            p.setProductCategoryId(resultSet.getLong("product_category_id"));
            p.setAverageWeight(resultSet.getDouble("average_weight"));
            p.setDescription(resultSet.getString("description"));
            this.products.add(p);
        }
        return this.products;
    }
}
