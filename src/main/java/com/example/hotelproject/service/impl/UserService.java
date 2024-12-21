package com.example.hotelproject.service.impl;

import com.example.hotelproject.controller.dto.response.MessengerRes;
import com.example.hotelproject.controller.dto.response.UserReq;
import com.example.hotelproject.entities.*;
import com.example.hotelproject.repository.*;
import com.example.hotelproject.security.auth.request.ChangePasswordRequest;
import com.example.hotelproject.security.auth.request.RegisterReq;
import com.example.hotelproject.security.user_auth.model.User;
import com.example.hotelproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TypeCustomerRepository typeCustomerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public MessengerRes updateUserInfo(String username, UserReq updatedUser) {
        {
            MessengerRes reqRes = new MessengerRes();
            try {
                User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not found"));
                Role role = roleRepository.findById(user.getRole().getId()).orElseThrow(() -> new RuntimeException("Role Not found"));
                if (updatedUser.getRole().equals("Customer")) {

                    Customer customer = customerRepository.findByUser_Username(user.getUsername());
                    TypeCustomer typeCustomer = typeCustomerRepository.findById(customer.getTypeCustomer().getId()).orElseThrow(() -> new RuntimeException("TypeCustomer Not found"));
                    if (customer != null) {
                        customer.setEmail(updatedUser.getEmail());
                        customer.setIdCard(updatedUser.getIdCard());
                        customer.setTypeCustomer(typeCustomer);
                        customer.setGender(updatedUser.getGender());
                        customer.setName(updatedUser.getFullName());
                        customer.setAddress(updatedUser.getAddress());
                        customer.setDob(updatedUser.getDob());
                        customer.setPhoneNumber(updatedUser.getPhoneNumber());
                        Customer savedCustomer = customerRepository.save(customer);
                        reqRes.setCustomer(savedCustomer);
                        reqRes.setStatusCode(200);
                        reqRes.setMessage("Customer updated successfully");
                    } else {
                        reqRes.setStatusCode(404);
                        reqRes.setMessage("User not found for update");
                    }
                } else {
                    Employee employee = employeeRepository.findByUser_Username(user.getUsername());
                    Degree degree = degreeRepository.findById(employee.getDegree().getId()).orElseThrow(() -> new RuntimeException("Degree Not found"));
                    Position position = positionRepository.findById(employee.getPosition().getId()).orElseThrow(() -> new RuntimeException("Position Not found"));
                    Division division = divisionRepository.findById(employee.getDivision().getId()).orElseThrow(() -> new RuntimeException("Division Not found"));
                    if (employee != null) {
                        employee.setEmail(updatedUser.getEmail());
                        employee.setIdCard(updatedUser.getIdCard());
                        employee.setDegree(degree);
                        employee.setPosition(position);
                        employee.setDivision(division);
                        employee.setGender(updatedUser.getGender());
                        employee.setName(updatedUser.getFullName());
                        employee.setAddress(updatedUser.getAddress());
                        employee.setDob(updatedUser.getDob());
                        employee.setPhoneNumber(updatedUser.getPhoneNumber());
                        Employee savedEmployee = employeeRepository.save(employee);
                        reqRes.setEmployee(savedEmployee);
                        reqRes.setStatusCode(200);
                        reqRes.setMessage("User updated successfully");
                    } else {
                        reqRes.setStatusCode(404);
                        reqRes.setMessage("User not found for update");
                    }
                }
            } catch (Exception e) {
                reqRes.setStatusCode(500);
                reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
            }
            return reqRes;
        }
    }

    @Override
    public MessengerRes getMyInfo(String username) {
        MessengerRes reqRes = new MessengerRes();
        try {
            User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not found"));

            if(user == null) {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found");
                return reqRes;
            }
            Role role = roleRepository.findById(user.getRole().getId()).orElseThrow(() -> new RuntimeException("Role Not found"));
            UserReq userDto = new UserReq();
            if(role.getName().equals("ROLE_CUSTOMER")) {
                Customer customer = customerRepository.findByUser_Username(user.getUsername());
                TypeCustomer typeCustomer = typeCustomerRepository.findById(customer.getTypeCustomer().getId()).orElseThrow(() -> new RuntimeException("TypeCustomer Not found"));
                {
                    userDto.setUsername(user.getUsername());
                    userDto.setEmail(customer.getEmail());
                    userDto.setIdCard(customer.getIdCard());
                    userDto.setTypeCustomer(typeCustomer.getName());
                    userDto.setGender(customer.getGender());
                    userDto.setFullName(customer.getName());
                    userDto.setAddress(customer.getAddress());
                    userDto.setDob(customer.getDob());
                    userDto.setRole(
                            switch (role.getName()) {
                                case "ROLE_ADMIN" -> "Admin";
                                case "ROLE_RECEPTIONIST" -> "Receptionist";
                                case "ROLE_MANAGER" -> "Manager";
                                default -> "Customer";
                            }
                    );
                    userDto.setImgUrl(customer.getImgUrl());
                    userDto.setPhoneNumber(customer.getPhoneNumber());
                    reqRes.setUserReq(userDto);
                    reqRes.setStatusCode(200);
                    reqRes.setMessage("successful");
                }
                return reqRes;
            } else {
                Employee employee = employeeRepository.findByUser_Username(user.getUsername());
                Degree degree = degreeRepository.findById(employee.getDegree().getId()).orElseThrow(() -> new RuntimeException("Degree Not found"));
                Position position = positionRepository.findById(employee.getPosition().getId()).orElseThrow(() -> new RuntimeException("Position Not found"));
                Division division = divisionRepository.findById(employee.getDivision().getId()).orElseThrow(() -> new RuntimeException("Division Not found"));
                {
                    userDto.setUsername(user.getUsername());
                    userDto.setEmail(employee.getEmail());
                    userDto.setIdCard(employee.getIdCard());
                    userDto.setEducation(degree.getName());
                    userDto.setPosition(position.getName());
                    userDto.setDivision(division.getName());
                    userDto.setRole(
                            switch (role.getName()) {
                                case "ROLE_ADMIN" -> "Admin";
                                case "ROLE_RECEPTIONIST" -> "Receptionist";
                                case "ROLE_MANAGER" -> "Manager";
                                default -> "Customer";
                            }
                    );
                    userDto.setGender(employee.getGender());
                    userDto.setFullName(employee.getName());
                    userDto.setAddress(employee.getAddress());
                    userDto.setDob(employee.getDob());
                    userDto.setPhoneNumber(employee.getPhoneNumber());
                    userDto.setImgUrl(employee.getImgUrl());

                    reqRes.setUserReq(userDto);
                    reqRes.setStatusCode(200);
                    reqRes.setMessage("successful");
                }
                return reqRes;
            }

        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return reqRes;    }

    @Override
    public MessengerRes updatePassword(String username, ChangePasswordRequest updatePasswords) {
        MessengerRes reqRes = new MessengerRes();
        try {
            User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not found"));
            // Check if the old password matches
            if (!passwordEncoder.matches(updatePasswords.getCurrentPassword(), user.getPassword())) {
                reqRes.setStatusCode(400);
                reqRes.setMessage("Old password is incorrect");
                return reqRes;
            }

            if (passwordEncoder.matches(updatePasswords.getNewPassword(), user.getPassword())) {
                reqRes.setStatusCode(400);
                reqRes.setMessage("New password is the same as the old password");
                return reqRes;
            }
            if (!updatePasswords.getNewPassword().equals(updatePasswords.getConfirmationPassword())) {
                reqRes.setStatusCode(400);
                reqRes.setMessage("New password is not the same as the confirmation password");
                return reqRes;
            }

            if ((updatePasswords.getNewPassword() == null || updatePasswords.getNewPassword().length() < 6) ||
                    (updatePasswords.getCurrentPassword() == null || updatePasswords.getCurrentPassword().length() < 6)) {
                reqRes.setStatusCode(400);
                reqRes.setMessage("Password must be at least 6 characters long");
                return reqRes;
            }
            // Encode the new password and update it
            user.setPassword(passwordEncoder.encode(updatePasswords.getNewPassword()));
            userRepository.save(user);

            reqRes.setStatusCode(200);
            reqRes.setMessage("Password updated successfully");
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while updating password: " + e.getMessage());
        }
        return reqRes;
    }

    @Override
    public MessengerRes changeAvatar(String username, String imgUrl) {
        {
            {
                MessengerRes reqRes = new MessengerRes();
                try {
                    User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not found"));
                    Role role = roleRepository.findById(user.getRole().getId()).orElseThrow(() -> new RuntimeException("Role Not found"));
                    if (role.getName().equals("ROLE_CUSTOMER")) {

                        Customer customer = customerRepository.findByUser_Username(user.getUsername());
                        if (customer != null) {
                            customer.setImgUrl(imgUrl);
                            Customer savedCustomer = customerRepository.save(customer);
                            reqRes.setCustomer(savedCustomer);
                            reqRes.setStatusCode(200);
                            reqRes.setMessage("Customer updated successfully");
                        } else {
                            reqRes.setStatusCode(404);
                            reqRes.setMessage("User not found for update");
                        }
                    } else {
                        Employee employee = employeeRepository.findByUser_Username(user.getUsername());
                        if (employee != null) {
                            employee.setImgUrl(imgUrl);
                            Employee savedEmployee = employeeRepository.save(employee);
                            reqRes.setEmployee(savedEmployee);
                            reqRes.setStatusCode(200);
                            reqRes.setMessage("User updated successfully");
                        } else {
                            reqRes.setStatusCode(404);
                            reqRes.setMessage("User not found for update");
                        }
                    }
                } catch (Exception e) {
                    reqRes.setStatusCode(500);
                    reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
                }
                return reqRes;
            }
        }    }

    @Override
    public MessengerRes getAvatar(String username) {
        {
            MessengerRes reqRes = new MessengerRes();
            try {
                User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not found"));

                if(user == null) {
                    reqRes.setStatusCode(404);
                    reqRes.setMessage("User not found");
                    return reqRes;
                }
                Role role = roleRepository.findById(user.getRole().getId()).orElseThrow(() -> new RuntimeException("Role Not found"));
                UserReq userDto = new UserReq();
                if(role.getName().equals("ROLE_CUSTOMER")) {
                    Customer customer = customerRepository.findByUser_Username(user.getUsername());
                    {
                        userDto.setImgUrl(customer.getImgUrl());
                        reqRes.setUserReq(userDto);
                        reqRes.setStatusCode(200);
                        reqRes.setMessage("successful");
                    }
                    return reqRes;
                } else {
                    Employee employee = employeeRepository.findByUser_Username(user.getUsername());
                    {
                        userDto.setImgUrl(employee.getImgUrl());

                        reqRes.setUserReq(userDto);
                        reqRes.setStatusCode(200);
                        reqRes.setMessage("successful");
                    }
                    return reqRes;
                }

            } catch (Exception e) {
                reqRes.setStatusCode(500);
                reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
            }
            return reqRes;    }
    }
}
