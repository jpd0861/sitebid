package com.stronghaul.sitebid.controllers;

import com.stronghaul.sitebid.models.Customer;
import com.stronghaul.sitebid.models.Address;
import com.stronghaul.sitebid.services.PostgresDbService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final PostgresDbService postgresDbService;

    public CustomerController(PostgresDbService postgresDbService) {
        this.postgresDbService = postgresDbService;
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody SaveCustomerRequest request) {
        Address address = new Address();
        address.setStreet(request.street());
        address.setZip(request.zip());

        Customer customer = new Customer();
        customer.setUserProfileId(request.userProfileId());
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setPhone(request.phone());
        customer.setEmail(request.email());

        Customer savedCustomer = postgresDbService.saveCustomer(request.userProfileId(), customer, address);

        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse.from(savedCustomer));
    }

    public record SaveCustomerRequest(
            Long userProfileId,
            String firstName,
            String lastName,
            String phone,
            String email,
            String street,
            String zip) {
    }

    public record CustomerResponse(
            Long id,
            Long userProfileId,
            String firstName,
            String lastName,
            String phone,
            String email,
            Long addressId) {

        private static CustomerResponse from(Customer customer) {
            return new CustomerResponse(
                    customer.getId(),
                    customer.getUserProfileId(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getPhone(),
                    customer.getEmail(),
                    customer.getAddressId());
        }
    }
}
