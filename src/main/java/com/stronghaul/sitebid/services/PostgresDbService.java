package com.stronghaul.sitebid.services;

import com.stronghaul.sitebid.models.UserProfile;
import com.stronghaul.sitebid.models.Address;
import com.stronghaul.sitebid.models.Customer;
import com.stronghaul.sitebid.models.JobBid;
import com.stronghaul.sitebid.models.SupplierInventoryCategory;
import com.stronghaul.sitebid.configuration.PostgresConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostgresDbService {

    private final JdbcTemplate jdbcTemplate;
    private final PostgresConfig postgresConfig;

    public PostgresDbService(JdbcTemplate jdbcTemplate, PostgresConfig postgresConfig) {
        this.jdbcTemplate = jdbcTemplate;
        this.postgresConfig = postgresConfig;
    }

    public Optional<UserProfile> findUserByEmail(String email) {
        final UserProfile[] result = new UserProfile[1];

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall("{ CALL strong_haul_bid.userProfile_getByEmail(?) }")) {
                callableStatement.setString(1, email);
                ResultSet resultSet = callableStatement.executeQuery();
                if (resultSet.next()) {
                    result[0] = mapUserProfile(resultSet, 1);
                }
                return null;
            }
        });

        return Optional.ofNullable(result[0]);
    }

    public UserProfile saveUser(UserProfile user) {
        Long userProfileId = insertUserProfile(user);
        user.setId(userProfileId);
        insertUserCrew(userProfileId, user);
        return user;
    }

    private Long insertUserProfile(UserProfile user) {
        final String procedureCall = "CALL strong_haul_bid.user_profile_insert(?, ?, ?, ?, ?, ?, ?, ?)";
        final Long[] generatedId = new Long[1];

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
                callableStatement.setString(1, user.getCompany());
                callableStatement.setString(2, user.getFirstName());
                callableStatement.setString(3, user.getLastName());
                callableStatement.setString(4, user.getPhone());
                callableStatement.setString(5, user.getEmail());
                callableStatement.setString(6, user.getPasswordHash());
                callableStatement.setBigDecimal(7, BigDecimal.valueOf(user.getProfitPercentage()));
                callableStatement.setInt(8, 0);
                callableStatement.registerOutParameter(8, Types.INTEGER);
                callableStatement.execute();
                generatedId[0] = (long) callableStatement.getInt(8);
                return null;
            }
        });

        return generatedId[0];
    }

    private Long insertUserCrew(Long userProfileId, UserProfile user) {
        final String procedureCall = "CALL strong_haul_bid.usercrew_insert(?, ?, ?, ?, ?, ?, ?)";
        final Long[] generatedId = new Long[1];

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
                callableStatement.setInt(1, userProfileId.intValue());
                callableStatement.setString(2, user.getFirstName());
                callableStatement.setString(3, user.getLastName());
                callableStatement.setBigDecimal(4, BigDecimal.valueOf(user.getHourlyRate()));
                callableStatement.setBoolean(5, user.isSubContractor());
                callableStatement.setBigDecimal(6, BigDecimal.valueOf(user.getProfitPercentage()));
                callableStatement.setInt(7, 0);
                callableStatement.registerOutParameter(7, Types.INTEGER);
                callableStatement.execute();
                generatedId[0] = (long) callableStatement.getInt(7);
                return null;
            }
        });
        return generatedId[0];
    }

    public void updateLastLogin(Long userId, LocalDateTime lastLogin) {
        jdbcTemplate.update("UPDATE " + postgresConfig.getUserProfileTable() + " SET last_login = ? WHERE id = ?",
                lastLogin, userId);
    }

    private UserProfile mapUserProfile(ResultSet resultSet, int rowNumber) throws SQLException {
        UserProfile user = new UserProfile();
        user.setId(resultSet.getLong("id"));
        user.setActive(resultSet.getBoolean("is_active"));
        user.setCompany(resultSet.getString("company"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setPhone(resultSet.getString("phone"));
        user.setEmail(resultSet.getString("email"));
        user.setPasswordHash(resultSet.getString("password_hash"));
        user.setProfitPercentage(resultSet.getDouble("profit_percentage"));
        user.setLastLogin(resultSet.getObject("last_login", LocalDateTime.class));
        return user;
    }

    public Long insertAddress(Address address) {
        final String procedureCall = "CALL strong_haul_bid.address_insert(?, ?, ?)";
        final Long[] generatedId = new Long[1];

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
                callableStatement.setString(1, address.getStreet());
                callableStatement.setString(2, address.getZip());
                callableStatement.setInt(3, 0);
                callableStatement.registerOutParameter(3, Types.INTEGER);
                callableStatement.execute();
                generatedId[0] = (long) callableStatement.getInt(3);
                return null;
            }
        });

        return generatedId[0];
    }

    private Long insertCustomer(Long userProfileId, Customer customer, Long addressId) {
        final String procedureCall = "CALL strong_haul_bid.user_customer_insert(?, ?, ?, ?, ?, ?, ?)";
        final Long[] generatedId = new Long[1];

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
                callableStatement.setInt(1, userProfileId.intValue());
                callableStatement.setString(2, customer.getFirstName());
                callableStatement.setString(3, customer.getLastName());
                callableStatement.setString(4, customer.getPhone());
                callableStatement.setString(5, customer.getEmail());
                callableStatement.setInt(6, addressId.intValue());
                callableStatement.setInt(7, 0);
                callableStatement.registerOutParameter(7, Types.INTEGER);
                callableStatement.execute();
                generatedId[0] = (long) callableStatement.getInt(7);
                return null;
            }
        });

        return generatedId[0];
    }

    public Customer saveCustomer(Long userProfileId, Customer customer, Address address) {
        Long addressId = insertAddress(address);
        address.setId(addressId);
        Long customerId = insertCustomer(userProfileId, customer, addressId);
        customer.setId(customerId);
        customer.setAddressId(addressId);
        return customer;
    }

    private Long insertBid(JobBid bid) {
        final String procedureCall = "CALL strong_haul_bid.user_bid_insert(?, ?, ?, ?, ?, ?, ?, ?)";
        final Long[] generatedId = new Long[1];

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
                callableStatement.setInt(1, bid.getUserProfileId().intValue());
                callableStatement.setInt(2, bid.getUserCustomerId().intValue());
                callableStatement.setInt(3, bid.getBidStatusId().intValue());
                callableStatement.setInt(4, bid.getAddressId().intValue());
                callableStatement.setString(5, bid.getScopeOfWork());
                callableStatement.setBigDecimal(6, bid.getProfitPercentageOverride());
                callableStatement.setTimestamp(7, Timestamp.valueOf(bid.getDateOfBid()));
                callableStatement.setInt(8, 0);
                callableStatement.registerOutParameter(8, Types.INTEGER);
                callableStatement.execute();
                generatedId[0] = (long) callableStatement.getInt(8);
                return null;
            }
        });

        return generatedId[0];
    }

    public JobBid saveBid(JobBid bid) {
        Long bidId = insertBid(bid);
        bid.setId(bidId);
        return bid;
    }

    private Long insertSupplierInventoryCategory(SupplierInventoryCategory supplierCategory) {
        final String procedureCall = "CALL strong_haul_bid.supplier_inventory_category_insert(?, ?)";
        final Long[] generatedId = new Long[1];

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
                callableStatement.setString(1, supplierCategory.getCategoryName());
                callableStatement.setString(2, supplierCategory.getDescription());
                callableStatement.setInt(3, 0);
                callableStatement.registerOutParameter(3, Types.INTEGER);
                callableStatement.execute();
                generatedId[0] = (long) callableStatement.getInt(3);
                return null;
            }
        });

        return generatedId[0];
    }

    public SupplierInventoryCategory saveSupplierInventoryCategory(SupplierInventoryCategory supplierInventoryCategory) {
        Long supplierCategoryId = insertSupplierInventoryCategory(supplierInventoryCategory);
        supplierInventoryCategory.setId(supplierCategoryId);
        return supplierInventoryCategory;
    }
}