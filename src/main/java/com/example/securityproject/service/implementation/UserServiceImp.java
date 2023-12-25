package com.example.securityproject.service.implementation;

import com.example.securityproject.entity.AppUser;
import com.example.securityproject.repository.UserRepo;
import com.example.securityproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

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
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepo.save(appUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = userRepo.findByUsername(username);
        appUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(appUser.get().getUsername(), appUser.get().getPassword(), getAuthorities(appUser.get()));
    }
    private static List<GrantedAuthority> getAuthorities(AppUser appUser) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (!appUser.getRoles().isEmpty()) {
            appUser.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
        }
        List<GrantedAuthority> authorities1 = authorities;
        return authorities;
    }
}
