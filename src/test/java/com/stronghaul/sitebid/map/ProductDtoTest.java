package com.stronghaul.sitebid.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stronghaul.sitebid.models.Product;

public class ProductDtoTest {
    private ProductDto productDto;

    @BeforeEach 
    public void setUp() {
        productDto = new ProductDto();
    }

    @Test
    public void returnsCorrectProductMappings() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getLong("id")).thenReturn(1L);
        when(resultSet.getLong("product_category_id")).thenReturn(2L);
        when(resultSet.getDouble("average_weight")).thenReturn(3.5);
        when(resultSet.getString("description")).thenReturn("Sample Product");

        ArrayList<Product> products = productDto.map(resultSet);

        assertEquals(1L, products.get(0).getId());
        assertEquals(2L, products.get(0).getProductCategoryId());
        assertEquals(3.5, products.get(0).getAverageWeight());
        assertEquals("Sample Product", products.get(0).getDescription());
    }
}