package com.example.securityproject.config;

import com.example.securityproject.entity.AppUser;
import com.example.securityproject.entity.Role;
import com.example.securityproject.service.RoleService;
import com.example.securityproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;
    @Override
    public void run(String... args) throws Exception {
        if (roleService.getAllRoles().isEmpty()) {
            roleService.saveRole(new Role(null, "ROLE_ADMIN"));
            roleService.saveRole(new Role(null, "ROLE_MANAGER"));
            roleService.saveRole(new Role(null, "ROLE_USER"));
        }

        if (userService.getAllUsers().isEmpty()) {
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(roleService.getRoleByName("ROLE_ADMIN"));

            Set<Role> managerRoles = new HashSet<>();
            managerRoles.add(roleService.getRoleByName("ROLE_MANAGER"));

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(roleService.getRoleByName("ROLE_USER"));

            userService.saveUser(new AppUser(null, "Med", "username1", "123", adminRoles));
            userService.saveUser(new AppUser(null, "Abdellah", "username2", "123", managerRoles));
            userService.saveUser(new AppUser(null, "Younes", "username3", "123", userRoles));

        }
    }
}
