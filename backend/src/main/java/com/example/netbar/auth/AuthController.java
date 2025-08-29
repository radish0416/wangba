package com.example.netbar.auth;

import com.example.netbar.common.api.ApiResponse;
import com.example.netbar.security.JwtService;
import com.example.netbar.user.User;
import com.example.netbar.user.UserRepository;
import com.example.netbar.user.UserRole;
import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/public/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthController(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @PostConstruct
    public void seedAdmin() {
        userRepository.findByUsername("admin").orElseGet(() -> {
            User u = new User();
            u.setUsername("admin");
            u.setPassword("admin123");
            u.setRole(UserRole.ADMIN);
            return userRepository.save(u);
        });
    }

    @PostMapping("/login")
    public ApiResponse<Map<String, Object>> login(@RequestParam @NotBlank String username,
                                                  @RequestParam @NotBlank String password) {
        User user = userRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new IllegalArgumentException("invalid credentials"));
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().name());
        String token = jwtService.generate(user.getUsername(), claims);
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("role", user.getRole());
        return ApiResponse.success(data);
    }
}

