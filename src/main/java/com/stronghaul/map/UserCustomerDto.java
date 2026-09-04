package com.stronghaul.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stronghaul.sitebid.models.UserCustomer;

public class UserCustomerDto {
    private ArrayList<UserCustomer> userCustomers;

    public UserCustomerDto() {
        this.userCustomers = new ArrayList<UserCustomer>();
    }

    public ArrayList<UserCustomer> map(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            UserCustomer userCustomer = new UserCustomer();
            userCustomer.setId(resultSet.getLong("id"));
            userCustomer.setUserProfileId(resultSet.getLong("user_profile_id"));
            userCustomer.setFirstName(resultSet.getString("first_name"));
            userCustomer.setLastName(resultSet.getString("last_name"));
            userCustomer.setPhone(resultSet.getString("phone"));
            userCustomer.setEmail(resultSet.getString("email"));
            userCustomer.setAddressId(resultSet.getLong("address_id"));
            userCustomers.add(userCustomer);
        }
        return userCustomers;
    }
}
