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
import com.stronghaul.sitebid.models.StrongHaulSettings;
import com.stronghaul.sitebid.models.UserBid;
import com.stronghaul.sitebid.models.UserBidLineItem;
import com.stronghaul.sitebid.models.UserBidLineItemCrew;
import com.stronghaul.sitebid.models.UserCrew;
import com.stronghaul.sitebid.models.UserCustomer;
import com.stronghaul.sitebid.models.UserProfile;

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
        JsonNode node = getJsonNode(root, "id");
        if (node != null) {
            bid.setId(node.asLong());
        }

        node = getJsonNode(root, "scope_of_work");
        if (node != null) {
            bid.setScopeOfWork(node.asText());
        }

        node = getJsonNode(root, "profit_percentage_override");
        if (node != null) {
            bid.setProfitPercentageOverride(new BigDecimal(node.asText()));
        }

        node = getJsonNode(root, "date_of_bid");
        if (node != null) {
            bid.setDateOfBid(LocalDateTime.parse(node.asText()));
        }
    }

    private void mapBidAddress(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "bidAddress");
        if (node != null) {
            Address address = new Address();
            JsonNode addrNode = getJsonNode(node, "id");

            if (addrNode != null) {
                address.setId(addrNode.asLong());
            }
            addrNode = getJsonNode(node, "street");
            if (addrNode != null) {
                address.setStreet(addrNode.asText());
            }
            addrNode = getJsonNode(node, "zip");
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
            JsonNode statusNode = getJsonNode(node, "id");
            if (statusNode != null) {
                bidStatus.setId(statusNode.asLong());
            }
            statusNode = getJsonNode(node, "status");
            if (statusNode != null) {
                bidStatus.setStatus(statusNode.asText());
            }
            bid.setBidStatus(bidStatus);
        }             
    }

    private void mapStrongHaulSettings(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "strongHaulSettings");
        if (node != null) {
            StrongHaulSettings strongHaulSetting = new StrongHaulSettings();
            JsonNode strongHaulNode = getJsonNode(node, "id");
            if (strongHaulNode != null) {
                strongHaulSetting.setId(strongHaulNode.asLong());
            }
            strongHaulNode = getJsonNode(node, "rate_per_mile");
            if (strongHaulNode != null) {
                strongHaulSetting.setRatePerMile(strongHaulNode.asDouble());
            }
            strongHaulNode = getJsonNode(node, "base_hookup_fee");
            if (strongHaulNode != null) {
                strongHaulSetting.setBaseHookupFee(strongHaulNode.asDouble());
            }
            strongHaulNode = getJsonNode(node, "tech_platform_fee");
            if (strongHaulNode != null) {
                strongHaulSetting.setTechPlatformFee(strongHaulNode.asDouble());
            }
            strongHaulNode = getJsonNode(node, "online_transaction_fee");
            if (strongHaulNode != null) {
                strongHaulSetting.setOnlineTransactionFee(strongHaulNode.asDouble());
            }
            strongHaulNode = getJsonNode(node, "online_transaction_percentage");
            if (strongHaulNode != null) {
                strongHaulSetting.setOnlineTransactionPercentage(strongHaulNode.asDouble());
            }
            bid.setStrongHaulSettings(strongHaulSetting);
        }
    }


    private void mapUserCustomer(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "customer");
        JsonNode addrNode = null;
        if (node != null) {
            addrNode = getJsonNode(node, "address");
            UserCustomer userCustomer = new UserCustomer();
            JsonNode customerNode = getJsonNode(node, "id");
            if (customerNode != null) {
                userCustomer.setId(customerNode.asLong());
            }
            customerNode = getJsonNode(node, "first_name");
            if (customerNode != null) {
                userCustomer.setFirstName(customerNode.asText());
            }
            customerNode = getJsonNode(node, "last_name");
            if (customerNode != null) {
                userCustomer.setLastName(customerNode.asText());
            }
            customerNode = getJsonNode(node, "email");
            if (customerNode != null) {
                userCustomer.setEmail(customerNode.asText());
            }
            customerNode = getJsonNode(node, "phone");
            if (customerNode != null) {
                userCustomer.setPhone(customerNode.asText());
            }
            customerNode = getJsonNode(node, "user_profile_id");
            if (customerNode != null) {
                userCustomer.setUserProfileId(customerNode.asLong());
            }

            if (addrNode != null) {
                Address address = new Address();
                JsonNode custAddrNode = getJsonNode(addrNode, "id");
                if (custAddrNode != null) {
                    address.setId(custAddrNode.asLong());
                }
                custAddrNode = getJsonNode(addrNode, "street");
                if (custAddrNode != null) {
                    address.setStreet(custAddrNode.asText());
                }
                custAddrNode = getJsonNode(addrNode, "zip");
                if (custAddrNode != null) {
                    address.setZip(custAddrNode.asText());
                }
                userCustomer.setAddress(address);
            }
            bid.setUserCustomer(userCustomer);
        }
    }

    private void mapUserProfile(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "userProfile");
        // JsonNode addrNode = null;
        if (node != null) {
            // addrNode = getJsonNode(node, "address");
            UserProfile userProfile = new UserProfile();
            JsonNode userProfileNode = getJsonNode(node, "id");
            if (userProfileNode != null) {
                userProfile.setId(userProfileNode.asLong());
            }
            userProfileNode = getJsonNode(node, "first_name");
            if (userProfileNode != null) {
                userProfile.setFirstName(userProfileNode.asText());
            }
            userProfileNode = getJsonNode(node, "last_name");
            if (userProfile != null) {
                userProfile.setLastName(userProfileNode.asText());
            }
            userProfileNode = getJsonNode(node, "email");
            if (userProfileNode != null) {
                userProfile.setEmail(userProfileNode.asText());
            }
            userProfileNode = getJsonNode(node, "phone");
            if (userProfileNode != null) {
                userProfile.setPhone(userProfileNode.asText());
            }
            userProfileNode = getJsonNode(node, "company");
            if (userProfileNode != null) {
                userProfile.setCompany(userProfileNode.asText());
            }
            userProfileNode = getJsonNode(node, "profit_percentage");
            if (userProfileNode != null) {
                userProfile.setProfitPercentage(userProfileNode.asDouble());
            }
            // if (addrNode != null) {
            //     Address address = new Address();
            //     JsonNode custAddrNode = getJsonNode(addrNode, "id");
            //     if (custAddrNode != null) {
            //         address.setId(custAddrNode.asLong());
            //     }
            //     custAddrNode = getJsonNode(addrNode, "street");
            //     if (custAddrNode != null) {
            //         address.setStreet(custAddrNode.asText());
            //     }
            //     custAddrNode = getJsonNode(addrNode, "zip");
            //     if (custAddrNode != null) {
            //         address.setZip(custAddrNode.asText());
            //     }
            //     userProfile.setAddress(address);
            // }
            bid.setUserProfile(userProfile);
        }
    }

    private void mapLineItems(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "lineItems");
        if (node != null && node.isArray()) {
            ArrayList<UserBidLineItem> userBidLineItems = new ArrayList<UserBidLineItem>();
            for (JsonNode lineItemNode : node) {
                UserBidLineItem lineItem = new UserBidLineItem();

                JsonNode itemNode = getJsonNode(lineItemNode, "id");
                if (itemNode != null) {
                    lineItem.setId(itemNode.asLong());
                }

                itemNode = getJsonNode(lineItemNode, "user_bid_id");
                if (itemNode != null) {
                    lineItem.setUserBidId(itemNode.asLong());
                }

                itemNode = getJsonNode(lineItemNode, "amount");
                if (itemNode != null) {
                    lineItem.setAmount(itemNode.asDouble());
                }

                itemNode = getJsonNode(lineItemNode, "quantity");
                if (itemNode != null) {
                    lineItem.setQuantity(itemNode.asDouble());
                }

                itemNode = getJsonNode(lineItemNode, "description");
                if (itemNode != null) {
                    lineItem.setDescription(itemNode.asText());
                }

                JsonNode categoryNode = getJsonNode(lineItemNode, "category");
                if (categoryNode != null) {
                    LineItemCategory category = new LineItemCategory();
                    JsonNode catNode = getJsonNode(categoryNode, "id");
                    if (catNode != null) {
                        category.setId(catNode.asLong());
                    }
                    catNode = getJsonNode(categoryNode, "description");
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

    private void mapCrewLineItems(UserBid bid, JsonNode root) {
        JsonNode node = getJsonNode(root, "lineItemsCrew");
        if (node != null && node.isArray()) {
            ArrayList<UserBidLineItemCrew> userBidLineItems = new ArrayList<UserBidLineItemCrew>();
            for (JsonNode lineItemNode : node) {
                UserBidLineItemCrew lineItem = new UserBidLineItemCrew();

                JsonNode itemNode = getJsonNode(lineItemNode, "id");
                if (itemNode != null) {
                    lineItem.setId(itemNode.asLong());
                }
                itemNode = getJsonNode(lineItemNode, "user_bid_id");
                if (itemNode != null) {
                    lineItem.setUserBidId(itemNode.asLong());
                }
                itemNode = getJsonNode(lineItemNode, "hours");
                if (itemNode != null) {
                    lineItem.setHours(itemNode.asDouble());
                }
                itemNode = getJsonNode(lineItemNode, "description");
                if (itemNode != null) {
                    lineItem.setDescription(itemNode.asText());
                }

                JsonNode userCrewNode = getJsonNode(lineItemNode, "crew");
                if (userCrewNode != null) {
                    UserCrew userCrew = new UserCrew();
                    JsonNode crewNode = getJsonNode(userCrewNode, "id");
                    if (crewNode != null) {
                        userCrew.setId(crewNode.asLong());
                    }
                    crewNode = getJsonNode(userCrewNode, "is_active");
                    if (crewNode != null) {
                        userCrew.setActive(crewNode.asBoolean());
                    }
                    crewNode = getJsonNode(userCrewNode, "first_name");
                    if (crewNode != null) {
                        userCrew.setFirstName(crewNode.asText());
                    }
                    crewNode = getJsonNode(userCrewNode, "last_name");
                    if (crewNode != null) {
                        userCrew.setLastName(crewNode.asText());
                    }
                    crewNode = getJsonNode(userCrewNode, "hourly_rate");
                    if (crewNode != null) {
                        userCrew.setHourlyRate(crewNode.asDouble());
                    }
                    crewNode = getJsonNode(userCrewNode, "is_sub_contractor");
                    if (crewNode != null) {
                        userCrew.setSubContractor(crewNode.asBoolean());
                    }
                    crewNode = getJsonNode(userCrewNode, "overhead_percentage");
                    if (crewNode != null) {
                        userCrew.setOverheadPercentage(crewNode.asDouble());
                    }
                    crewNode = getJsonNode(userCrewNode, "user_profile_id");
                    if (crewNode != null) {
                        userCrew.setUserProfileId(crewNode.asLong());
                    }
                    lineItem.setUserCrew(userCrew);
                }

                userBidLineItems.add(lineItem);
            }

            bid.setUserBidLineItemCrews(userBidLineItems);
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
                mapCrewLineItems(bid, root);
                mapUserCustomer(bid, root);
                mapStrongHaulSettings(bid, root);
                mapUserProfile(bid, root);

                this.userBids.add(bid);
            } catch (JsonProcessingException ex) {
                throw new SQLException("Unable to parse user_bid_get_json result", ex);
            }
        }
        return userBids;
    }
}
