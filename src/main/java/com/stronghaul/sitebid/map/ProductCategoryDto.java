package com.stronghaul.sitebid.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stronghaul.sitebid.models.ProductCategory;

public class ProductCategoryDto {
    private ArrayList<ProductCategory> categories;

    public ArrayList<ProductCategory> map(ResultSet resultSet) throws SQLException {
        this.categories = new ArrayList<ProductCategory>();
        while (resultSet.next()) {
            ProductCategory category = new ProductCategory();
            category.setId(resultSet.getLong("id"));
            category.setCategory(resultSet.getString("category"));
            categories.add(category);
        }
        return categories;
    }
}
