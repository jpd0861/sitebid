package com.stronghaul.map;

import com.stronghaul.sitebid.models.UserCrew;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserCrewDto {
    private ArrayList<UserCrew> userCrews;

    public UserCrewDto() {
        this.userCrews = new ArrayList<UserCrew>();
    }

    public ArrayList<UserCrew> map(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            UserCrew userCrew = new UserCrew();
            userCrew.setId(resultSet.getLong("id"));
            userCrew.setUserProfileId(resultSet.getLong("user_profile_id"));
            userCrew.setFirstName(resultSet.getString("first_name"));
            userCrew.setLastName(resultSet.getString("last_name"));
            userCrew.setHourlyRate(resultSet.getDouble("hourly_rate"));
            userCrew.setSubContractor(resultSet.getBoolean("is_sub_contractor"));
            userCrew.setOverheadPercentage(resultSet.getDouble("overhead_percentage"));
            userCrew.setActive(resultSet.getBoolean("is_active"));
            userCrews.add(userCrew);
        }
        return userCrews;
    }
}