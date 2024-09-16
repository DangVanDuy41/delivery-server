package com.example.deliveryserver.controller;
import com.example.deliveryserver.DTO.ApiResponse;
import com.example.deliveryserver.DTO.AuthDTO;
import com.example.deliveryserver.DTO.JwtResponse;
import com.example.deliveryserver.DTO.UserDTO;
import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.enums.Role;
import com.example.deliveryserver.service.Jwt.JwtService;
import com.example.deliveryserver.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthDTO authRequest) {
        JwtResponse jwtResponse = null;
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String accessToken = jwtService.generateToken(authRequest.getUsername());

            Optional<User> user = userService.findByEmail(authRequest.getUsername());
            if (user.isPresent()) {
                jwtResponse = JwtResponse.builder()
                        .message("Đăng nhập thành công.")
                        .accessToken(accessToken)
                        .role(user.get().getRole())
                        .userID(user.get().getId())
                        .build();
            }

        }
        return ResponseEntity.status(200).body(jwtResponse);
    }

    @PostMapping("/register")
    public ApiResponse<Boolean> register(@RequestBody UserDTO userRequest) {
        User userRegister = User.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .createdAt(new Date())
                .fullName(userRequest.getFullName())
                .role(Role.ROLE_USER)
                .build();
        User user = userService.saveOrUpdate(userRegister);
        Boolean result = user !=null;
        return ApiResponse.<Boolean>builder().data(result).time(new Date()).build();
    }
}
