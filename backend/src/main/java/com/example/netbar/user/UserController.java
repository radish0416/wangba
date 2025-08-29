package com.example.netbar.user;

import com.example.netbar.common.api.ApiResponse;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/public/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ApiResponse<Map<String, Object>> register(@RequestParam @NotBlank String username,
                                                     @RequestParam @NotBlank String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // TODO: hash in real impl
        user.setRole(UserRole.USER);
        userRepository.save(user);
        Map<String, Object> data = new HashMap<>();
        data.put("userId", user.getId());
        return ApiResponse.success(data);
    }
}

