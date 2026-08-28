package com.stronghaul.sitebid.services;

import com.stronghaul.sitebid.models.UserProfile;
import com.stronghaul.sitebid.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class AuthService {

    private final PostgresDbService postgresDbService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    public AuthService(PostgresDbService postgresDbService, PasswordEncoder passwordEncoder,
            JwtTokenProvider tokenProvider) {
        this.postgresDbService = postgresDbService;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    public UserProfile register(UserProfile user, String rawPassword) {
        String email = normalizeEmail(user.getEmail());
        if (postgresDbService.findUserByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(rawPassword));
        user.setActive(true);
        return postgresDbService.saveUser(user);
    }

    public String login(String email, String rawPassword) {
        UserProfile user = postgresDbService.findUserByEmail(normalizeEmail(email)).orElse(null);
        if (user == null || !passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        if (!user.isActive()) {
            throw new IllegalArgumentException("Account is inactive");
        }

        user.setLastLogin(LocalDateTime.now());
        postgresDbService.updateLastLogin(user.getId(), user.getLastLogin());
        return tokenProvider.generateToken(user.getId(), user.getEmail());
    }

    private String normalizeEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        return email.trim().toLowerCase(Locale.ROOT);
    }
}
