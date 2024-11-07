package com.example.hotelproject.security.auth.service;

import com.example.hotelproject.config.JwtUtils;
import com.example.hotelproject.controller.dto.response.MessengerRes;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Role;
import com.example.hotelproject.entities.TypeCustomer;
import com.example.hotelproject.repository.CustomerRepository;
import com.example.hotelproject.repository.RoleRepository;
import com.example.hotelproject.repository.TypeCustomerRepository;
import com.example.hotelproject.repository.UserRepository;
import com.example.hotelproject.security.auth.request.AuthReq;
import com.example.hotelproject.security.auth.request.RegisterReq;
import com.example.hotelproject.security.user_auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypeCustomerRepository typeCustomerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtUtils jwtUtils;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public MessengerRes register(RegisterReq registrationRequest) {
        MessengerRes messengerRes = new MessengerRes();
        try {
            User user = new User();
            Customer customer = new Customer();
            TypeCustomer typeCustomer = typeCustomerRepository.findByName("BRONZE");
            Role role = roleRepository.findByName("ROLE_CUSTOMER");
            //Save user
            user.setUsername(registrationRequest.getUsername());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setRole(role);
            User usersResult = userRepository.save(user);
            //Save profile
            customer.setUser(user);
            customer.setAddress(registrationRequest.getAddress());
            customer.setDob(registrationRequest.getDob());
            customer.setName(registrationRequest.getName());
            customer.setIdCard(registrationRequest.getIdCard());
            customer.setGender(registrationRequest.getGender());
            customer.setPhoneNumber(registrationRequest.getPhoneNumber());
            customer.setEmail(registrationRequest.getEmail());
            customer.setTypeCustomer(typeCustomer);
            Customer resultCustomer = customerRepository.save(customer);
            //Checking
            if (!user.getUsername().isEmpty() && resultCustomer.getId() > 0) {
                messengerRes.setCustomer((resultCustomer));
                messengerRes.setUser((usersResult));
                messengerRes.setMessage("Register successfully");
                messengerRes.setStatusCode(200);
            }
        } catch (Exception e) {
            messengerRes.setStatusCode(500);
            messengerRes.setError(e.getMessage());
        }
        return messengerRes;
    }

    @Override
    public MessengerRes login(AuthReq loginRequest) {
        MessengerRes response = new MessengerRes();
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword()));

            var user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
            var jwt = jwtUtils.generateToken(user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRoles(roleRepository.findByName(user.getRole().getName()));
            response.setExpirationTime("30M");
            response.setMessage("Successfully Logged In");


        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @Override
    public MessengerRes refreshToken(AuthReq refreshTokenReqiest) {
        MessengerRes response = new MessengerRes();
        try {
            String ourUsername = jwtUtils.extractUsername(refreshTokenReqiest.getRefreshToken());
            User users = userRepository.findByUsername(ourUsername).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenReqiest.getRefreshToken(), users)) {
                var jwt = jwtUtils.generateToken(users);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenReqiest.getRefreshToken());
                response.setExpirationTime("24Hr");
                response.setMessage("Successfully Refreshed Token");
            }
            response.setStatusCode(200);
            return response;

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    @Override
    public MessengerRes logout(AuthReq logoutRequest) {
        MessengerRes response = new MessengerRes();
        try {
            response.setStatusCode(200);
            response.setMessage("Successfully Logged Out");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error occurred while logging out: " + e.getMessage());
        }
        return response;
    }
}
