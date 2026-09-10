package com.stronghaul.sitebid.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.BidStatus;
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

    public UserBidResponse createUserBid(UserBidRequest request){
        UserBidResponse response = new UserBidResponse();

        if(!this.validateUserBidRequest.isValid(request)){
            response.setError(validateUserBidRequest.getError());
            return response;
        }
        
        UserBid userBid = new UserBid();
        userBid.setAddress(request.getSiteAddress());
        userBid.setBidStatus(new BidStatus());
        userBid.setDateOfBid(request.getDateOfBid());
        userBid.setProfitPercentageOverride(request.getProfitPercentage());
        userBid.setScopeOfWork(request.getScopeOfWork());
        userBid.setDateOfBid(request.getDateOfBid());
        userBid = this.postgresDbService.saveBid(userBid);
        response.setUserBid(userBid);
        return response;
    }
}
