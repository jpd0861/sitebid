package com.stronghaul.sitebid.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stronghaul.sitebid.models.UserBid;
import com.stronghaul.sitebid.models.UserBidLineItem;

public class UserBidDtoTest {

    private UserBidDto userBidDto;

    @BeforeEach
    public void setUp() {
        userBidDto = new UserBidDto();
    }

    @Test
    public void returnsCorrectUserBidLineItemsMappings() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getString(1)).thenReturn("{\"id\": 1, \"customer\": {\"id\": 1, \"email\": \"cust_email\", \"phone\": \"cust_phone\", \"address\": {\"id\": 9, \"zip\": \"81506\", \"street\": \"111 customer address\"}, \"last_name\": \"customer_last_name\", \"first_name\": \"customer_first_name\", \"user_profile_id\": 1}, \"bidStatus\": {\"id\": 1, \"status\": \"Started\"}, \"lineItems\": [{\"id\": 1, \"amount\": 300.00, \"category\": {\"id\": 3, \"description\": \"Material Removal\"}, \"quantity\": 1, \"description\": \"Remove existing driveway and tree - 3 hours\", \"user_bid_id\": 1}, {\"id\": 2, \"amount\": 5.68, \"category\": {\"id\": 2, \"description\": \"Equipment Fuel\"}, \"quantity\": 2, \"description\": \"Diesel fuel to run bobcat\", \"user_bid_id\": 1}, {\"id\": 3, \"amount\": 150.00, \"category\": {\"id\": 1, \"description\": \"Disposal Fee\"}, \"quantity\": 2, \"description\": \"Dump fees for existing driveway - 2 trips\", \"user_bid_id\": 1}, {\"id\": 4, \"amount\": 5.65, \"category\": {\"id\": 2, \"description\": \"Equipment Fuel\"}, \"quantity\": 1, \"description\": \"Diesel fuel to haul tree away.\", \"user_bid_id\": 1}], \"bidAddress\": {\"id\": 10, \"zip\": \"81503\", \"street\": \"111 job site address\"}, \"date_of_bid\": \"2026-09-07T07:05:35.749812\", \"userProfile\": {\"id\": 1, \"email\": \"email@eamil.com\", \"phone\": \"phone\", \"company\": \"some company\", \"last_name\": \"last_name\", \"first_name\": \"first_name\", \"profit_percentage\": 25}, \"lineItemsCrew\": [{\"id\": 1, \"crew\": {\"id\": 1, \"is_active\": true, \"last_name\": \"last_name\", \"first_name\": \"first_name\", \"hourly_rate\": 100, \"user_profile_id\": 1, \"is_sub_contractor\": false, \"overhead_percentage\": 15}, \"hours\": 2.5, \"description\": \"Manual labor to chop and load tree\", \"user_bid_id\": 1}], \"scope_of_work\": \"Need to pave a new driveway and get rid of the old concrete. Also need to remove a tree.\", \"lineItemsSupplier\": [{\"id\": 1, \"amount\": 37.00, \"quantity\": 2, \"supplier\": {\"id\": 7, \"phone\": \"970-523-4216\", \"address\": {\"id\": 7, \"zip\": \"81501\", \"street\": \"800 S 15th St\"}, \"company_name\": \"The Rock Shop\", \"inventoryItem\": {\"id\": 85, \"product\": \"Road Base\", \"category\": {\"id\": 2, \"category\": \"Gravel\", \"description\": null}, \"product_description\": \"3/4 inch\", \"product_delivery_type\": \"Bulk\", \"average_weight_per_unit\": 2700}}, \"description\": \"Purchase 3/4\\\" road base\", \"user_bid_id\": 1, \"site_delivery\": true, \"contractor_discount_percent\": 10}], \"strongHaulSettings\": {\"id\": 1, \"rate_per_mile\": 3.50, \"base_hookup_fee\": 75.00, \"tech_platform_fee\": 1.50, \"online_transaction_fee\": 0.30, \"online_transaction_percentage\": 0.029}, \"profit_percentage_override\": 35.0}" );
        ArrayList<UserBid> userBids = userBidDto.map(resultSet);

        assertEquals(1, userBids.size());
        UserBid userBid = userBids.get(0);
        assertEquals(userBid.getId(), 1);
        assertEquals(userBid.getProfitPercentageOverride(), 35.0);
        assertEquals(userBid.getScopeOfWork(), "Need to pave a new driveway and get rid of the old concrete. Also need to remove a tree.");
        assertEquals(4, userBid.getUserBidLineItems().size(), "Expected two line items to be mapped.");

        UserBidLineItem firstItem = userBid.getUserBidLineItems().get(0);
        assertEquals(1L, firstItem.getId());
        assertEquals(300.0, firstItem.getAmount(), 0.0001);
        assertEquals(1.0, firstItem.getQuantity(), 0.0001);
        assertEquals("Remove existing driveway and tree - 3 hours", firstItem.getDescription());
        assertEquals(3L, firstItem.getLineItemCategory().getId());
        assertEquals("Material Removal", firstItem.getLineItemCategory().getDescription());
    }
}
