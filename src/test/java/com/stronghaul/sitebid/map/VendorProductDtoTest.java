package com.stronghaul.sitebid.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stronghaul.sitebid.models.VendorProduct;

public class VendorProductDtoTest {
    private VendorProductDto vendorProductDto;

    @BeforeEach 
    public void setUp() {
        vendorProductDto = new VendorProductDto();
    }

    @Test 
    public void returnsCorrectVendorProductMappings() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getLong("id")).thenReturn(15L);
        when(resultSet.getLong("vendor_id")).thenReturn(20L);
        when(resultSet.getLong("product_id")).thenReturn(1L);
        when(resultSet.getDouble("retail")).thenReturn(100.0);
        when(resultSet.getDouble("discount_percentage")).thenReturn(10.0);

        ArrayList<VendorProduct> vendorProducts = this.vendorProductDto.map(resultSet);
        assertEquals(15L, vendorProducts.get(0).getId());
        assertEquals(20L, vendorProducts.get(0).getVendorId());
        assertEquals(1L, vendorProducts.get(0).getProductId());
        assertEquals(100.0, vendorProducts.get(0).getRetail());
        assertEquals(10.0, vendorProducts.get(0).getDiscountPercentage());
    }
}
