package com.stronghaul.sitebid.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stronghaul.sitebid.models.ProductCategory;

public class ProductCategoryDtoTest {
    private ProductCategoryDto productCategoryDto;

    @BeforeEach 
    public void setUp() {
        productCategoryDto = new ProductCategoryDto();
    }

    @Test 
    public void returnsCorrectProductCategoryMappings() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getLong("id")).thenReturn(1L);
        when(resultSet.getString("category")).thenReturn("Sample Category");

        ArrayList<ProductCategory> productCategories = productCategoryDto.map(resultSet);
        assertEquals(1, productCategories.size());
        assertEquals(1L, productCategories.get(0).getId());
        assertEquals("Sample Category", productCategories.get(0).getCategory());
    }
}

//         ArrayList<Product> products = productDto.map(resultSet);

//         assertEquals(1L, products.get(0).getId());
//         assertEquals(2L, products.get(0).getProductCategoryId());
//         assertEquals(3.5, products.get(0).getAverageWeight());
//         assertEquals("Sample Product", products.get(0).getDescription());
//     }
// }