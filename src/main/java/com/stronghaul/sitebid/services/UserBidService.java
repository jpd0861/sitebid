package com.stronghaul.sitebid.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.UserBid;
import com.stronghaul.sitebid.models.UserBidRequest;
import com.stronghaul.sitebid.models.UserBidResponse;
import com.stronghaul.sitebid.models.UserProfile;

@Service 
public class UserBidService {

    private final PostgresDbService postgresDbService;

    public UserBidService(PostgresDbService postgresDbService) {
        this.postgresDbService = postgresDbService;
    }

    public ArrayList<UserBid> getUserBids(UserProfile userProfile, Long bidId) {
        return postgresDbService.getUserBids(userProfile, bidId);
    }

    public UserBidResponse createUserBid(UserBidRequest request){
        UserBidResponse response = new UserBidResponse();
        return response;
    }
}
