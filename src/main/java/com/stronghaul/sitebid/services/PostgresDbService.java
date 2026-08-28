package com.stronghaul.sitebid.services;

import com.stronghaul.sitebid.models.UserProfile;
import com.stronghaul.sitebid.configuration.PostgresConfig;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "SELECT id, is_active, company, first_name, last_name, phone, email, "
                + "password_hash, profit_percentage, last_login FROM " + postgresConfig.getUserProfileTable()
                + " WHERE lower(email) = lower(?)";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, this::mapUserProfile, email));
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    public UserProfile saveUser(UserProfile user) {
        String sql = "INSERT INTO " + postgresConfig.getUserProfileTable()
                + " (is_active, company, first_name, last_name, phone, email, password_hash, "
                + "profit_percentage, last_login) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        Long id = jdbcTemplate.queryForObject(sql, Long.class,
                user.isActive(), user.getCompany(), user.getFirstName(), user.getLastName(),
                user.getPhone(), user.getEmail(), user.getPasswordHash(), user.getProfitPercentage(),
                user.getLastLogin());
        user.setId(id);
        return user;
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
}