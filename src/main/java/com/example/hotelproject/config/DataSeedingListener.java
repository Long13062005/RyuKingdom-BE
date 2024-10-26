package com.example.hotelproject.config;

import com.example.hotelproject.entities.Role;
import com.example.hotelproject.entities.TypeCustomer;
import com.example.hotelproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TypeCustomerRepository typeCustomerRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN", false));
        }

        if (roleRepository.findByName("ROLE_STAFF") == null) {
            roleRepository.save(new Role("ROLE_STAFF", false));
        }

        if (roleRepository.findByName("ROLE_CUSTOMER") == null) {
            roleRepository.save(new Role("ROLE_CUSTOMER", false));
        }
        if (typeCustomerRepository.findByName("BRONZE") == null) {
            typeCustomerRepository.save(new TypeCustomer("BRONZE", false));
        }
        if (typeCustomerRepository.findByName("SILVER") == null) {
            typeCustomerRepository.save(new TypeCustomer("SILVER", false));
        }
        if (typeCustomerRepository.findByName("VIP") == null) {
            typeCustomerRepository.save(new TypeCustomer("VIP", false));
        }
       /* if(userRepository.findByUsername("admin").isEmpty()){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(roleRepository.findByName("ADMIN"));
            userRepository.save(admin);
        }
        if(staffRepository.findByUser_Username("admin") == null){
            User admin = userRepository.findByUsername("admin").get();
            Staff staff = new Staff();
            staff.setFullName("admin");
            staff.setAddress("admin");
            staff.setDob("1111/11/11");
            staff.setPhoneNumber("0123456789");
            staff.setUser(admin);
            staffRepository.save(staff);
        }
        if(userRepository.findByUsername("staff").isEmpty()){
            User admin = new User();
            admin.setUsername("staff");
            admin.setPassword(passwordEncoder.encode("staff123"));
            admin.setRole(roleRepository.findByName("STAFF"));
            userRepository.save(admin);
        }
        if(staffRepository.findByUser_Username("staff") == null){
            User admin = userRepository.findByUsername("staff").get();
            Staff staff = new Staff();
            staff.setFullName("staff");
            staff.setAddress("staff");
            staff.setDob("1111/11/11");
            staff.setPhoneNumber("0123456789");
            staff.setUser(admin);
            staffRepository.save(staff);
        }*/
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}