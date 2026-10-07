package com.stronghaul.sitebid.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.UserBid;
import com.stronghaul.sitebid.models.UserBidRequest;
import com.stronghaul.sitebid.models.UserBidResponse;
import com.stronghaul.sitebid.models.UserProfile;

@Service 
public class UserBidService {

    @Autowired private PostgresDbService postgresDbService;
    @Autowired private ValidateUserBidRequest validateUserBidRequest;

    public ArrayList<UserBid> getUserBids(UserProfile userProfile, Long bidId) {
        return postgresDbService.getUserBids(userProfile, bidId);
    }

    private UserBid mapUserBidRequest(UserBidRequest request){
        UserBid userBid = new UserBid();
        userBid.setAddress(request.getSiteAddress());
        userBid.setBidStatus(request.getBidStatus());
        userBid.setDateOfBid(request.getDateOfBid());
        userBid.setProfitPercentageOverride(request.getProfitPercentage());
        userBid.setScopeOfWork(request.getScopeOfWork());
        userBid.setDateOfBid(request.getDateOfBid());
        userBid = this.postgresDbService.saveBid(userBid);
        return userBid;
    }

    public UserBidResponse createUserBid(UserBidRequest request){
        UserBidResponse response = new UserBidResponse();

        if(!this.validateUserBidRequest.isValid(request)){
            response.setError(validateUserBidRequest.getError());
            return response;
        }

        UserBid userBid = mapUserBidRequest(request);
        userBid = this.postgresDbService.saveBid(userBid);

        response.setUserBid(userBid);
        return response;
    }
}
