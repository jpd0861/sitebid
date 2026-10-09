package com.stronghaul.sitebid.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stronghaul.sitebid.models.Vendor;

public class VendorDtoTest {
    private VendorDto vendorDto;

    @BeforeEach 
    public void setUp() {
        vendorDto = new VendorDto();
    }

    @Test 
    public void returnsCorrectProductMappings() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getLong("id")).thenReturn(1L);
        when(resultSet.getString("company_name")).thenReturn("Sample Company");
        when(resultSet.getLong("address_id")).thenReturn(1L);
        when(resultSet.getDouble("discount_percentage")).thenReturn(10.0);
        when(resultSet.getString("phone")).thenReturn("123-456-7890");

        ArrayList<Vendor> vendors = this.vendorDto.map(resultSet);
        assertEquals(1L, vendors.get(0).getId());
        assertEquals("Sample Company", vendors.get(0).getCompanyName());
        assertEquals(1L, vendors.get(0).getAddressId());
        assertEquals(10.0, vendors.get(0).getDiscountPercentage());
    }
}
