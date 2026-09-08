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
import com.stronghaul.sitebid.models.BidStatus;

public class UserBidDto {
    private ArrayList<UserBid> userBids;

    private JsonNode getJsonNode(JsonNode root, String key) {
        JsonNode data = root.get(key);
        if (data != null && !data.isNull()) {
            return data;
        }
        return null;
    }

    private void mapBidRootValues(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "bid_id");
        if (node != null) {
            bid.setId(node.asLong());
        }

        node = getJsonNode(root, "bid_scope_of_work");
        if (node != null) {
            bid.setScopeOfWork(node.asText());
        }

        node = getJsonNode(root, "bid_profit_percentage_override");
        if (node != null) {
            bid.setProfitPercentageOverride(new BigDecimal(node.asText()));
        }

        node = getJsonNode(root, "bid_date");
        if (node != null) {
            bid.setDateOfBid(LocalDateTime.parse(node.asText()));
        }
    }

    private void mapBidAddress(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "bidAddress");
        if (node != null) {
            Address address = new Address();
            JsonNode addrNode = getJsonNode(node, "bid_addr_id");

            if (addrNode != null) {
                address.setId(addrNode.asLong());
            }
            addrNode = getJsonNode(node, "bid_addr_street");
            if (addrNode != null) {
                address.setStreet(addrNode.asText());
            }
            addrNode = getJsonNode(node, "bid_addr_zip");
            if (addrNode != null) {
                address.setZip(addrNode.asText());
            }
            bid.setAddress(address);
        }             
    }

    private void mapBidStatus(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "bidStatus");
        if (node != null) {
            BidStatus bidStatus = new BidStatus();
            JsonNode statusNode = getJsonNode(node, "bid_stat_id");
            if (statusNode != null) {
                bidStatus.setId(statusNode.asLong());
            }
            statusNode = getJsonNode(node, "bid_stat_status");
            if (statusNode != null) {
                bidStatus.setStatus(statusNode.asText());
            }
            bid.setBidStatus(bidStatus);
        }             
    }

    // private void mapLineItems(UserBid bid, JsonNode root) {
    //     JsonNode node = getJsonNode(root, "lineItems");
    //     if (node != null) {
    //         BidStatus bidStatus = new BidStatus();
    //         JsonNode statusNode = getJsonNode(node, "bid_stat_id");
    //         if (statusNode != null) {
    //             bidStatus.setId(statusNode.asLong());
    //         }
    //         statusNode = getJsonNode(node, "bid_stat_status");
    //         if (statusNode != null) {
    //             bidStatus.setStatus(statusNode.asText());
    //         }
    //         bid.setBidStatus(bidStatus);
    //     }             
    // }

    public ArrayList<UserBid> map(ResultSet resultSet) throws SQLException {
        this.userBids = new ArrayList<UserBid>();
        final ObjectMapper mapper = new ObjectMapper();
        
        if (resultSet.next()) {
            String json = resultSet.getString(1);
            try {
                JsonNode root = mapper.readTree(json);
                UserBid bid = new UserBid();

                mapBidRootValues(bid, root);
                mapBidAddress(bid, root);
                mapBidStatus(bid, root);

                this.userBids.add(bid);
            } catch (JsonProcessingException ex) {
                throw new SQLException("Unable to parse user_bid_get_json result", ex);
            }
        }
        return userBids;
    }
}
