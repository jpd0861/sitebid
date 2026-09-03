package com.stronghaul.sitebid.services;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.stronghaul.sitebid.models.UserCrew;

@Service
public class UserCrewService {

    private final PostgresDbService postgresDbService;

    public UserCrewService(PostgresDbService postgresDbService) {
        this.postgresDbService = postgresDbService;
    }
    
    public ArrayList<UserCrew> getUserCrewsByUserProfileId(Long userProfileId, Long crewId) {
        ArrayList<UserCrew> userCrews = postgresDbService.getUserCrewsByUserProfileId(userProfileId, crewId);
        return userCrews;
    }

    public UserCrew saveUserCrew(Long userProfileId, UserCrew userCrew) {
        // Implement the logic to save a user crew
        UserCrew savedUserCrew = postgresDbService.saveUserCrew(userProfileId, userCrew);
        return savedUserCrew;
    }

    public UserCrew updateUserCrew(Long userProfileId, UserCrew userCrew) {
        // Implement the logic to update a user crew
        UserCrew updatedUserCrew = postgresDbService.updateUserCrew(userProfileId, userCrew);
        return updatedUserCrew;
    }

}
