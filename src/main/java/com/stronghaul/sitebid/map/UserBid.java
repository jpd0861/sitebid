package com.stronghaul.sitebid.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBid {
    private ArrayList<UserBid> userBids;


    public ArrayList<UserBid> map(ResultSet resultSet) throws SQLException {
        this.userBids = new ArrayList<UserBid>();
        while (resultSet.next()) {
            // UserBid userBid = new UserBid();
            // userBid.setId(resultSet.getLong("id"));
            // userBid.setUserProfileId(resultSet.getLong("user_profile_id"));
            // userBid.setUserCustomerId(resultSet.getLong("customer_id"));
            // userBid.setBidStatusId(resultSet.getLong("bid_status_id"));
            // userBid.setAddressId(resultSet.getLong("address_id"));
            // userBid.setDateOfBid(resultSet.getDate("date_of_bid"));
            // userBid.setScopeOfWork(resultSet.getString("scope_of_work"));
            // userBid.setProfitPercentageOverride(resultSet.getBigDecimal("profit_percentage_override"));
            // userBids.add(userBid);
        }
        return userBids;
    }
}
