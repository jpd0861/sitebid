package com.stronghaul.sitebid.map;

import org.junit.jupiter.api.BeforeEach;

import com.stronghaul.map.UserCrewDto;
import com.stronghaul.sitebid.models.UserCrew;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserCrewDtoTest {

    private UserCrewDto userCrewDto;

    @BeforeEach
    public void setUp() {
        userCrewDto = new UserCrewDto();
    }

    @Test
    public void returnsCorrectUserCrewMappings() throws SQLException {
        // Mock the ResultSet
        ResultSet resultSet = mock(ResultSet.class);

        // Define the behavior of the mocked ResultSet
        when(resultSet.next()).thenReturn(true, true, false); // Simulate two rows
        when(resultSet.getLong("id")).thenReturn(1L, 2L);
        when(resultSet.getLong("user_profile_id")).thenReturn(100L, 200L);
        when(resultSet.getString("first_name")).thenReturn("John", "Jane");
        when(resultSet.getString("last_name")).thenReturn("Doe", "Smith");
        when(resultSet.getDouble("hourly_rate")).thenReturn(25.0, 30.0);
        when(resultSet.getBoolean("is_sub_contractor")).thenReturn(true, false);
        when(resultSet.getDouble("overhead_percentage")).thenReturn(10.0, 15.0);
        when(resultSet.getBoolean("is_active")).thenReturn(true, false);

        // Call the map method
        ArrayList<UserCrew> userCrews = userCrewDto.map(resultSet);

        // Verify the results
        assertEquals(2, userCrews.size());

        UserCrew firstUserCrew = userCrews.get(0);
        assertEquals(1L, firstUserCrew.getId());
        assertEquals(100L, firstUserCrew.getUserProfileId());
        assertEquals("John", firstUserCrew.getFirstName());
        assertEquals("Doe", firstUserCrew.getLastName());
        assertEquals(25.0, firstUserCrew.getHourlyRate());
        assertTrue(firstUserCrew.isSubContractor());
        assertEquals(10.0, firstUserCrew.getOverheadPercentage());
        assertTrue(firstUserCrew.isActive());

        UserCrew secondUserCrew = userCrews.get(1);
        assertEquals(2L, secondUserCrew.getId());
        assertEquals(200L, secondUserCrew.getUserProfileId());
        assertEquals("Jane", secondUserCrew.getFirstName());
        assertEquals("Smith", secondUserCrew.getLastName());
        assertEquals(30.0, secondUserCrew.getHourlyRate());
        assertFalse(secondUserCrew.isSubContractor());
        assertEquals(15.0, secondUserCrew.getOverheadPercentage());
        assertFalse(secondUserCrew.isActive());
    }
}
