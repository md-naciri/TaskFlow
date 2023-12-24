package com.example.securityproject.service.implementation;

import com.example.securityproject.entity.AppUser;
import com.example.securityproject.repository.UserRepo;
import com.example.securityproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;

    @Override
    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public AppUser getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        return userRepo.save(appUser);
    }
}
