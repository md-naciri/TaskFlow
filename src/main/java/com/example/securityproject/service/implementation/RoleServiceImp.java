package com.example.securityproject.service.implementation;

import com.example.securityproject.entity.Role;
import com.example.securityproject.repository.RoleRepo;
import com.example.securityproject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {
    private final RoleRepo roleRepo;
    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
    @Override
    public Role getRoleById(Long id) {
        return roleRepo.findById(id).orElse(null);
    }
    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }
    @Override
    public Role getRoleByName(String name) {
        return roleRepo.findByName(name).orElse(null);
    }
}
