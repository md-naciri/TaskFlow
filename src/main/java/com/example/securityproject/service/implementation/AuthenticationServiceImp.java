package com.example.securityproject.service.implementation;

import com.example.securityproject.dao.request.SignInRequest;
import com.example.securityproject.dao.request.SignUpRequest;
import com.example.securityproject.dao.response.JwtAuthenticationResponse;
import com.example.securityproject.entity.AppUser;
import com.example.securityproject.entity.Role;
import com.example.securityproject.repository.UserRepo;
import com.example.securityproject.service.AuthenticationService;
import com.example.securityproject.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest signUpRequest) {
        var user = AppUser.builder()
                .name(signUpRequest.getName())
                .username(signUpRequest.getUsername())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        var token = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(token).build();
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
//        authenticationManager.authenticate()
        return null;
    }
}
