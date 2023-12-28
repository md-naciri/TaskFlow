package com.example.securityproject.service;

import com.example.securityproject.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
//    List<AppUser> getAllUsers();
//    AppUser getUserById(Long id);
//    AppUser saveUser(AppUser appUser);
    UserDetailsService userDetailsService();
}
