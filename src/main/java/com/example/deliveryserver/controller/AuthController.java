package com.example.deliveryserver.controller;

import com.example.deliveryserver.DTO.AuthDTO;
import com.example.deliveryserver.DTO.JwtResponse;
import com.example.deliveryserver.service.Jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthDTO authRequest) {
        JwtResponse jwtResponse = null;
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String accessToken = jwtService.generateToken(authRequest.getUsername());
            jwtResponse = JwtResponse.builder().message("Đăng nhập thành công.").accessToken(accessToken).build();
        }
        return ResponseEntity.status(200).body(jwtResponse);
    }

//    @PostMapping("/logout")
//    public ResponseEntity<ApiResponse> handleLogout(@RequestBody RefreshTokenRequest  refreshTokenRequest){
//        String token = refreshTokenRequest.getToken();
//        if(token != null){
//            refreshTokenService.deleteRefreshToken(token);
//        }
//        ApiResponse apiResponse = ApiResponse.builder().message("Đăng xuất thành công.").status(200).build();
//        return ResponseEntity.status(200).body(apiResponse);
//    }
}
