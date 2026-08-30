package com.stronghaul.sitebid.controllers;

import com.stronghaul.sitebid.models.UserProfile;
import com.stronghaul.sitebid.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        UserProfile user = new UserProfile();
        user.setCompany(request.company());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPhone(request.phone());
        user.setEmail(request.email());
        user.setProfitPercentage(request.profitPercentage());
        user.setHourlyRate(request.hourlyRate());

        UserProfile registeredUser = authService.register(user, request.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(registeredUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(new AuthResponse(authService.login(request.email(), request.password())));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse(exception.getMessage()));
        }
    }

    public record RegisterRequest(
            String company,
            String firstName,
            String lastName,
            String phone,
            String email,
            String password,
            double profitPercentage,
            double hourlyRate) {
    }

    public record LoginRequest(String email, String password) {
    }

    public record AuthResponse(String token) {
    }

    public record ErrorResponse(String error) {
    }

    public record UserResponse(
            Long id,
            boolean active,
            String company,
            String firstName,
            String lastName,
            String phone,
            String email,
            double profitPercentage,
            java.time.LocalDateTime lastLogin) {

        private static UserResponse from(UserProfile user) {
            return new UserResponse(
                    user.getId(),
                    user.isActive(),
                    user.getCompany(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getProfitPercentage(),
                    user.getLastLogin());
        }
    }
}
