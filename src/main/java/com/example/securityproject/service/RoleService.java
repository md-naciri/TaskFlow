package com.example.securityproject.service;

import com.example.securityproject.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role saveRole(Role role);
    Role getRoleByName(String name);
}
