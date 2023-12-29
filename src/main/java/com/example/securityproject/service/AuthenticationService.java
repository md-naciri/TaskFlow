package com.example.securityproject.service;

import com.example.securityproject.dao.request.SignInRequest;
import com.example.securityproject.dao.request.SignUpRequest;
import com.example.securityproject.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
}
