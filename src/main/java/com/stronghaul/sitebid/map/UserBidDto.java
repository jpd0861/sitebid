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
import com.stronghaul.sitebid.models.BidStatus;
import com.stronghaul.sitebid.models.LineItemCategory;
import com.stronghaul.sitebid.models.UserBid;
import com.stronghaul.sitebid.models.UserBidLineItem;
import com.stronghaul.sitebid.models.UserCustomer;

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

    private void mapUserCustomer(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "customer");
        if (node != null) {
            UserCustomer userCustomer = new UserCustomer();
            JsonNode customerNode = getJsonNode(node, "cust_id");
            if (customerNode != null) {
                userCustomer.setId(customerNode.asLong());
            }
            customerNode = getJsonNode(node, "cust_first_name");
            if (customerNode != null) {
                userCustomer.setFirstName(customerNode.asText());
            }
            customerNode = getJsonNode(node, "cust_last_name");
            if (customerNode != null) {
                userCustomer.setLastName(customerNode.asText());
            }
            customerNode = getJsonNode(node, "cust_email");
            if (customerNode != null) {
                userCustomer.setEmail(customerNode.asText());
            }
            customerNode = getJsonNode(node, "cust_phone");
            if (customerNode != null) {
                userCustomer.setPhone(customerNode.asText());
            }
            customerNode = getJsonNode(node, "cust_user_profile_id");
            if (customerNode != null) {
                userCustomer.setUserProfileId(customerNode.asLong());
            }

            JsonNode addrNode = getJsonNode(node, "cust_address");
            if (addrNode != null) {
                Address address = new Address();
                JsonNode custAddrNode = getJsonNode(addrNode, "cust_addr_id");
                if (custAddrNode != null) {
                    address.setId(custAddrNode.asLong());
                }
                custAddrNode = getJsonNode(addrNode, "cust_addr_street");
                if (custAddrNode != null) {
                    address.setStreet(custAddrNode.asText());
                }
                custAddrNode = getJsonNode(addrNode, "cust_addr_zip");
                if (custAddrNode != null) {
                    address.setZip(custAddrNode.asText());
                }
                userCustomer.setAddress(address);
            }
            bid.setUserCustomer(userCustomer);
        }
    }

    private void mapLineItems(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "lineItems");
        if (node != null && node.isArray()) {
            ArrayList<UserBidLineItem> userBidLineItems = new ArrayList<UserBidLineItem>();
            for (JsonNode lineItemNode : node) {
                UserBidLineItem lineItem = new UserBidLineItem();

                JsonNode itemNode = getJsonNode(lineItemNode, "li_id");
                if (itemNode != null) {
                    lineItem.setId(itemNode.asLong());
                }

                itemNode = getJsonNode(lineItemNode, "li_user_bid_id");
                if (itemNode != null) {
                    lineItem.setUserBidId(itemNode.asLong());
                }

                itemNode = getJsonNode(lineItemNode, "li_amount");
                if (itemNode != null) {
                    lineItem.setAmount(itemNode.asDouble());
                }

                itemNode = getJsonNode(lineItemNode, "li_quantity");
                if (itemNode != null) {
                    lineItem.setQuantity(itemNode.asDouble());
                }

                itemNode = getJsonNode(lineItemNode, "li_description");
                if (itemNode != null) {
                    lineItem.setDescription(itemNode.asText());
                }

                JsonNode categoryNode = getJsonNode(lineItemNode, "category");
                if (categoryNode != null) {
                    LineItemCategory category = new LineItemCategory();
                    JsonNode catNode = getJsonNode(categoryNode, "li_cat_id");
                    if (catNode != null) {
                        category.setId(catNode.asLong());
                    }
                    catNode = getJsonNode(categoryNode, "li_cat_description");
                    if (catNode != null) {
                        category.setDescription(catNode.asText());
                    }
                    lineItem.setLineItemCategory(category);
                }

                userBidLineItems.add(lineItem);
            }

            bid.setUserBidLineItems(userBidLineItems);
        }
    }

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
                mapLineItems(bid, root);
                mapUserCustomer(bid, root);

                this.userBids.add(bid);
            } catch (JsonProcessingException ex) {
                throw new SQLException("Unable to parse user_bid_get_json result", ex);
            }
        }
        return userBids;
    }
}
