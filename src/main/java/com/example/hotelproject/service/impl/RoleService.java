package com.example.hotelproject.service.impl;

import com.example.hotelproject.entities.Role;
import com.example.hotelproject.repository.RoleRepository;
import com.example.hotelproject.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void deleteRole(Long id) {

    }

    @Override
    public void updateRole(Long id, String name) {

    }

    @Override
    public void addRole(String name) {

    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


    @Override
    public void getRoleById(Long id) {

    }

    @Override
    public void getRoleByName(String name) {

    }
}
