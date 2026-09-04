package com.stronghaul.sitebid.services;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.stronghaul.sitebid.models.UserCustomer;

@Service
public class UserCustomerService {

    private final PostgresDbService postgresDbService;

    public UserCustomerService(PostgresDbService postgresDbService) {
        this.postgresDbService = postgresDbService;
    }

    public ArrayList<UserCustomer> getUserCustomersByUserProfileId(Long userProfileId, Long userCustomerId) {
        ArrayList<UserCustomer> userCustomers = postgresDbService.getUserCustomerByUserProfileId(userProfileId, userCustomerId);
        return userCustomers;
    }

    public UserCustomer saveUserCustomer(Long userProfileId, UserCustomer userCustomer) {
        // Implement the logic to save a user customer
        UserCustomer savedUserCustomer = postgresDbService.saveUserCustomer(userProfileId, userCustomer);
        return savedUserCustomer;
    }

    public UserCustomer updateUserCustomer(Long userProfileId, UserCustomer userCustomer) {
        // Implement the logic to update a user customer
        UserCustomer updatedUserCustomer = postgresDbService.updateUserCustomer(userProfileId, userCustomer);
        return updatedUserCustomer;
    }
}
