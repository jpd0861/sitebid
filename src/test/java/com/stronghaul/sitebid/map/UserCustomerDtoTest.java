package com.stronghaul.sitebid.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stronghaul.sitebid.models.UserCustomer;

public class UserCustomerDtoTest {

    private UserCustomerDto userCustomerDto;

    @BeforeEach
    public void setUp() {
        userCustomerDto = new UserCustomerDto();
    }

    @Test
    public void returnsCorrectUserCustomerMappings() throws SQLException {
        // Mock the ResultSet
        ResultSet resultSet = mock(ResultSet.class);

        // Define the behavior of the mocked ResultSet
        when(resultSet.next()).thenReturn(true, true, false); // Simulate two rows
        when(resultSet.getLong("id")).thenReturn(1L, 2L);
        when(resultSet.getLong("user_profile_id")).thenReturn(100L, 200L);
        when(resultSet.getString("first_name")).thenReturn("John", "Jane");
        when(resultSet.getString("last_name")).thenReturn("Doe", "Smith");
        when(resultSet.getString("phone")).thenReturn("123-456-7890", "098-765-4321");
        when(resultSet.getString("email")).thenReturn("john.doe@example.com", "jane.smith@example.com");
        //when(resultSet.getLong("address_id")).thenReturn(1L, 2L);
        when(resultSet.getLong("address_id")).thenReturn(1L, 2L);
        when(resultSet.getString("street")).thenReturn("123 Main St", "456 Elm St");
        when(resultSet.getString("zip")).thenReturn("12345", "67890");

        // Call the map method
        ArrayList<UserCustomer> userCustomers = userCustomerDto.map(resultSet);

        // Verify the results
        assertEquals(2, userCustomers.size(), "Expected two UserCustomer objects in the list");

        UserCustomer firstUserCustomer = userCustomers.get(0);
        assertEquals(1L, firstUserCustomer.getId(), "First UserCustomer ID should be 1");
        assertEquals(100L, firstUserCustomer.getUserProfileId(), "First UserCustomer UserProfileId should be 100");
        assertEquals("John", firstUserCustomer.getFirstName(), "First UserCustomer FirstName should be John");
        assertEquals("Doe", firstUserCustomer.getLastName(), "First UserCustomer LastName should be Doe");
        assertEquals("123-456-7890", firstUserCustomer.getPhone(), "First UserCustomer Phone should be 123-456-7890");
        assertEquals("john.doe@example.com", firstUserCustomer.getEmail(), "First UserCustomer Email should be john.doe@example.com");
        assertEquals(1L, firstUserCustomer.getAddress().getId(), "First UserCustomer AddressId should be 1");
        assertEquals("123 Main St", firstUserCustomer.getAddress().getStreet(), "First UserCustomer Street should be 123 Main St");
        assertEquals("12345", firstUserCustomer.getAddress().getZip(), "First UserCustomer Zip should be 12345");

        UserCustomer secondUserCustomer = userCustomers.get(1);
        assertEquals(2L, secondUserCustomer.getId(), "Second UserCustomer ID should be 2");
        assertEquals(200L, secondUserCustomer.getUserProfileId(), "Second UserCustomer UserProfileId should be 200");
        assertEquals("Jane", secondUserCustomer.getFirstName(), "Second UserCustomer FirstName should be Jane");
        assertEquals("Smith", secondUserCustomer.getLastName(), "Second UserCustomer LastName should be Smith");
        assertEquals("098-765-4321", secondUserCustomer.getPhone(), "Second UserCustomer Phone should be 098-765-4321");
        assertEquals("jane.smith@example.com", secondUserCustomer.getEmail(), "Second UserCustomer Email should be jane.smith@example.com");
        assertEquals(2L, secondUserCustomer.getAddress().getId(), "Second UserCustomer AddressId should be 2");
        assertEquals("456 Elm St", secondUserCustomer.getAddress().getStreet(), "Second UserCustomer Street should be 456 Elm St");
        assertEquals("67890", secondUserCustomer.getAddress().getZip(), "Second UserCustomer Zip should be 67890");
    }
}
