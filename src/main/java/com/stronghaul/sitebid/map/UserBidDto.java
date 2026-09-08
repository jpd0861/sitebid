package com.stronghaul.sitebid.map;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stronghaul.sitebid.models.Address;
import com.stronghaul.sitebid.models.UserBid;

public class UserBidDto {
    private ArrayList<UserBid> userBids;

    public ArrayList<UserBid> map(ResultSet resultSet) throws SQLException {
        this.userBids = new ArrayList<UserBid>();
        final ObjectMapper mapper = new ObjectMapper();
        
        if (resultSet.next()) {
            String json = resultSet.getString(1);
            try {
                JsonNode root = mapper.readTree(json);

                UserBid bid = new UserBid();
                JsonNode rootBidId = root.get("bid_id");
                if (rootBidId != null && !rootBidId.isNull()) {
                    bid.setId(rootBidId.asLong());
                }

                JsonNode addressNode = root.get("bidAddress");
                if (addressNode != null && !addressNode.isNull()) {
                    Address bidAddress = new Address();
                    JsonNode addrId = addressNode.get("bid_addr_id");
                    if (addrId != null && !addrId.isNull()) {
                        bidAddress.setId(addrId.asLong());
                    }
                    JsonNode addrStreet = addressNode.get("bid_addr_street");
                    if (addrStreet != null && !addrStreet.isNull()) {
                        bidAddress.setStreet(addrStreet.asText());
                    }
                    JsonNode addrZip = addressNode.get("bid_addr_zip");
                    if (addrZip != null && !addrZip.isNull()) {
                        bidAddress.setZip(addrZip.asText());
                    }
                    bid.setAddress(bidAddress);
                }

                JsonNode bidStatusNode = root.get("bidStatus");
                if (bidStatusNode != null && !bidStatusNode.isNull()) {
                    com.stronghaul.sitebid.models.BidStatus bidStatus = new com.stronghaul.sitebid.models.BidStatus();
                    JsonNode statusId = bidStatusNode.get("bid_stat_id");
                    if (statusId != null && !statusId.isNull()) {
                        bidStatus.setId(statusId.asLong());
                    }
                    JsonNode statusText = bidStatusNode.get("bid_stat_status");
                    if (statusText != null && !statusText.isNull()) {
                        bidStatus.setStatus(statusText.asText());
                    }
                    bid.setBidStatus(bidStatus);
                }

                JsonNode scope = root.get("bid_scope_of_work");
                if (scope != null && !scope.isNull()) {
                    bid.setScopeOfWork(scope.asText());
                }

                JsonNode profit = root.get("bid_profit_percentage_override");
                if (profit != null && !profit.isNull()) {
                    bid.setProfitPercentageOverride(new BigDecimal(profit.asText()));
                }

                JsonNode bidDate = root.get("bid_date");
                if (bidDate != null && !bidDate.isNull()) {
                    bid.setDateOfBid(LocalDateTime.parse(bidDate.asText()));
                }

                this.userBids.add(bid);
            } catch (JsonProcessingException ex) {
                throw new SQLException("Unable to parse user_bid_get_json result", ex);
            }
        }
        return userBids;
    }
}
