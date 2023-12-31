package com.example.securityproject.controller;

import com.example.securityproject.dao.request.SignInRequest;
import com.example.securityproject.dao.request.SignUpRequest;
import com.example.securityproject.dao.response.JwtAuthenticationResponse;
import com.example.securityproject.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signing")
    public ResponseEntity<JwtAuthenticationResponse> signing(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }
}
