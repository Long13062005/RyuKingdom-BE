package com.example.hotelproject.service;

import com.example.hotelproject.entities.Role;

import java.util.List;

public interface IRoleService {
    void deleteRole(Long id);
    void updateRole(Long id, String name);
    void addRole(String name);
    List<Role> getAllRoles();
    void getRoleById(Long id);
    void getRoleByName(String name);
}
