package com.stronghaul.sitebid.controllers;

import com.stronghaul.sitebid.models.JobBid;
import com.stronghaul.sitebid.models.Address;
import com.stronghaul.sitebid.services.PostgresDbService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bid")
public class JobBidController {

    private final PostgresDbService postgresDbService;

    public JobBidController(PostgresDbService postgresDbService) {
        this.postgresDbService = postgresDbService;
    }

    @PostMapping("/save")
    public ResponseEntity<JobBidResponse> saveBidWithDifferentLocation(@RequestBody SaveBidRequest request) {
        Address address = new Address();
        address.setStreet(request.street());
        address.setZip(request.zip());

        Long addressId = postgresDbService.insertAddress(address);

        JobBid bid = new JobBid();
        bid.setUserProfileId(request.userProfileId());
        bid.setUserCustomerId(request.userCustomerId());
        bid.setAddressId(addressId);
        bid.setScopeOfWork(request.scopeOfWork());

        JobBid savedBid = postgresDbService.saveBid(bid);

        return ResponseEntity.status(HttpStatus.CREATED).body(JobBidResponse.from(savedBid));
    }

    public record SaveBidRequest(
            Long userProfileId,
            Long userCustomerId,
            String street,
            String zip,
            String scopeOfWork) {
    }

    public record JobBidResponse(
            Long id,
            Long userProfileId,
            Long userCustomerId,
            Long addressId,
            String scopeOfWork,
            java.time.LocalDateTime dateOfBid) {

        private static JobBidResponse from(JobBid bid) {
            return new JobBidResponse(
                    bid.getId(),
                    bid.getUserProfileId(),
                    bid.getUserCustomerId(),
                    bid.getAddressId(),
                    bid.getScopeOfWork(),
                    bid.getDateOfBid());
        }
    }
}
