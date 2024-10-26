package com.example.hotelproject.service;

public interface IRoleService {
    void deleteRole(Long id);
    void updateRole(Long id, String name);
    void addRole(String name);
    void getAllRoles();
    void getRoleById(Long id);
    void getRoleByName(String name);
}
