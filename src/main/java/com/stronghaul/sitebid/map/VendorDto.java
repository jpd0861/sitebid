package com.stronghaul.sitebid.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stronghaul.sitebid.models.Vendor;

public class VendorDto {
    private ArrayList<Vendor> vendors;

    public ArrayList<Vendor> map(ResultSet resultSet) throws SQLException {
        this.vendors = new ArrayList<Vendor>();
        while (resultSet.next()) {
            Vendor v = new Vendor();
            v.setId(resultSet.getLong("id"));
            v.setCompanyName(resultSet.getString("company_name"));
            v.setAddressId(resultSet.getLong("address_id"));
            v.setDiscountPercentage(resultSet.getDouble("discount_percentage"));
            v.setPhone(resultSet.getString("phone"));
            this.vendors.add(v);
        }
        return this.vendors;
    }

}
