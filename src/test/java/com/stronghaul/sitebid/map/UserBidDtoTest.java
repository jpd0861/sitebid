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
        when(resultSet.getString(1)).thenReturn("{\"bid_id\":1,\"lineItems\":[{\"li_id\":1,\"category\":{\"li_cat_id\":3,\"li_cat_description\":\"Material Removal\"},\"li_amount\":300.00,\"li_quantity\":1,\"li_description\":\"Remove existing driveway and tree - 3 hours\"},{\"li_id\":2,\"category\":{\"li_cat_id\":2,\"li_cat_description\":\"Equipment Fuel\"},\"li_amount\":5.68,\"li_quantity\":2,\"li_description\":\"Diesel fuel to run bobcat\"}]}" );

        ArrayList<UserBid> userBids = userBidDto.map(resultSet);

        assertEquals(1, userBids.size());
        UserBid userBid = userBids.get(0);
        assertEquals(2, userBid.getUserBidLineItems().size(), "Expected two line items to be mapped.");

        UserBidLineItem firstItem = userBid.getUserBidLineItems().get(0);
        assertEquals(1L, firstItem.getId());
        assertEquals(300.0, firstItem.getAmount(), 0.0001);
        assertEquals(1.0, firstItem.getQuantity(), 0.0001);
        assertEquals("Remove existing driveway and tree - 3 hours", firstItem.getDescription());
        assertEquals(3L, firstItem.getLineItemCategory().getId());
        assertEquals("Material Removal", firstItem.getLineItemCategory().getDescription());

        UserBidLineItem secondItem = userBid.getUserBidLineItems().get(1);
        assertEquals(2L, secondItem.getId());
        assertEquals(5.68, secondItem.getAmount(), 0.0001);
        assertEquals(2.0, secondItem.getQuantity(), 0.0001);
        assertEquals("Diesel fuel to run bobcat", secondItem.getDescription());
        assertEquals(2L, secondItem.getLineItemCategory().getId());
        assertEquals("Equipment Fuel", secondItem.getLineItemCategory().getDescription());
    }
}
