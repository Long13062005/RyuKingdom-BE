package com.example.hotelproject.config;

import com.example.hotelproject.entities.*;
import com.example.hotelproject.repository.*;
import com.example.hotelproject.security.user_auth.model.User;
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

    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private TypeFacilityRepository typeFacilityRepository;

    @Autowired
    private TypeRentRepository typeRentRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private AttachFacilityRepository attachFacilityRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN", false));
        }

        if (roleRepository.findByName("ROLE_MANAGER") == null) {
            roleRepository.save(new Role("ROLE_MANAGER", false));
        }
        if (roleRepository.findByName("ROLE_RECEPTIONIST") == null) {
            roleRepository.save(new Role("ROLE_RECEPTIONIST", false));
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
        if (divisionRepository.findByName("FRESHER") == null) {
            divisionRepository.save(new Division("FRESHER", false));
        }
        if (divisionRepository.findByName("JUNIOR") == null) {
            divisionRepository.save(new Division("JUNIOR", false));
        }
        if (divisionRepository.findByName("SENIOR") == null) {
            divisionRepository.save(new Division("SENIOR", false));
        }
        if (positionRepository.findByName("DANANG") == null) {
            positionRepository.save(new Position("DANANG", false));
        }
        if (positionRepository.findByName("HCM") == null) {
            positionRepository.save(new Position("HCM", false));
        }
        if (positionRepository.findByName("HANOI") == null) {
            positionRepository.save(new Position("HANOI", false));
        }
        if (degreeRepository.findByName("BACHELOR") == null) {
            degreeRepository.save(new Degree("BACHELOR", false));
        }
        if (degreeRepository.findByName("MASTER") == null) {
            degreeRepository.save(new Degree("MASTER", false));
        }
        if (userRepository.findByUsername("admin123").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin123");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(roleRepository.findByName("ROLE_ADMIN"));
            userRepository.save(admin);
            Employee adminEmployee = new Employee();
            adminEmployee.setUser(admin);
            adminEmployee.setAddress("Hanoi");
            adminEmployee.setDob("1999-01-01");
            adminEmployee.setEmail("admin@gmail.com");
            adminEmployee.setDegree(degreeRepository.findByName("MASTER"));
            adminEmployee.setDivision(divisionRepository.findByName("SENIOR"));
            adminEmployee.setGender(1);
            adminEmployee.setIdCard("123456789");
            adminEmployee.setName("admin");
            adminEmployee.setPhoneNumber("123456789");
            adminEmployee.setPosition(positionRepository.findByName("HANOI"));
            adminEmployee.setSalary(10000000.0);
            employeeRepository.save(adminEmployee);
        }

        if (userRepository.findByUsername("receptionist123").isEmpty()) {
            User staff = new User();
            staff.setUsername("receptionist123");
            staff.setPassword(passwordEncoder.encode("receptionist123"));
            staff.setRole(roleRepository.findByName("ROLE_RECEPTIONIST"));
            userRepository.save(staff);
            Employee staffEmployee = new Employee();
            staffEmployee.setUser(staff);
            staffEmployee.setAddress("Hanoi");
            staffEmployee.setDob("1990-01-01");
            staffEmployee.setEmail("staff@gmail.com");
            staffEmployee.setDegree(degreeRepository.findByName("BACHELOR"));
            staffEmployee.setDivision(divisionRepository.findByName("JUNIOR"));
            staffEmployee.setGender(1);
            staffEmployee.setIdCard("987654321");
            staffEmployee.setName("staff");
            staffEmployee.setPhoneNumber("987654321");
            staffEmployee.setPosition(positionRepository.findByName("HANOI"));
            staffEmployee.setSalary(8000000.0);
            employeeRepository.save(staffEmployee);
        }

        if (userRepository.findByUsername("manager123").isEmpty()) {
            User manager = new User();
            manager.setUsername("manager123");
            manager.setPassword(passwordEncoder.encode("manager123"));
            manager.setRole(roleRepository.findByName("ROLE_MANAGER"));
            userRepository.save(manager);
            Employee managerEmployee = new Employee();
            managerEmployee.setUser(manager);
            managerEmployee.setAddress("Hanoi");
            managerEmployee.setDob("1985-01-01");
            managerEmployee.setEmail("manager@gmail.com");
            managerEmployee.setDegree(degreeRepository.findByName("MASTER"));
            managerEmployee.setDivision(divisionRepository.findByName("SENIOR"));
            managerEmployee.setGender(1);
            managerEmployee.setIdCard("112233445");
            managerEmployee.setName("manager");
            managerEmployee.setPhoneNumber("112233445");
            managerEmployee.setPosition(positionRepository.findByName("HANOI"));
            managerEmployee.setSalary(15000000.0);
            employeeRepository.save(managerEmployee);
        }
        if (userRepository.findByUsername("customer123").isEmpty()) {
            User customer = new User();
            customer.setUsername("customer123");
            customer.setPassword(passwordEncoder.encode("customer123"));
            customer.setRole(roleRepository.findByName("ROLE_CUSTOMER"));
            userRepository.save(customer);
            Customer customer1 = new Customer();
            customer1.setUser(customer);
            customer1.setAddress("Hanoi");
            customer1.setDob("1985-01-01");
            customer1.setEmail("customer@gmail.com");
            customer1.setGender(1);
            customer1.setIdCard("112233445");
            customer1.setName("customer");
            customer1.setPhoneNumber("112233445");
            customer1.setTypeCustomer(typeCustomerRepository.findByName("BRONZE"));
            customer1.setDeleted(false);
            customerRepository.save(customer1);
        }
        if (typeFacilityRepository.findByName("ROOM") == null) {
            typeFacilityRepository.save(new TypeFacility("ROOM", "ROOM", false));
        }
        if (typeFacilityRepository.findByName("SUITE") == null) {
            typeFacilityRepository.save(new TypeFacility("SUITE", "SUITE", false));
        }
        if (typeFacilityRepository.findByName("VIILA") == null) {
            typeFacilityRepository.save(new TypeFacility("VIILA", "VIILA", false));
        }
        if (typeRentRepository.findByName("HOUR") == null) {
            typeRentRepository.save(new TypeRent("HOUR", "HOUR"));
        }
        if (typeRentRepository.findByName("DAY") == null) {
            typeRentRepository.save(new TypeRent("DAY", "DAY"));
        }
        if (typeRentRepository.findByName("MONTH") == null) {
            typeRentRepository.save(new TypeRent("MONTH", "MONTH"));
        }
        if (facilityRepository.findByName("ROOM 1") == null) {
            Facility facility = new Facility();
            facility.setName("ROOM 1");
            facility.setCost(400);
            facility.setArea(20);
            facility.setMaxPeople(2);
            facility.setStandardRoom("STANDARD");
            facility.setDescription("Standard room");
            facility.setPoolArea(0);
            facility.setNumberOfFloors(1);
            facility.setTypeFacility(typeFacilityRepository.findByName("ROOM"));
            facility.setTypeRent(typeRentRepository.findByName("HOUR"));
            facility.setDeleted(false);
            facilityRepository.save(facility);
        }
        if (facilityRepository.findByName("ROOM 2") == null) {
            Facility facility = new Facility();
            facility.setName("ROOM 2");
            facility.setCost(500);
            facility.setArea(20);
            facility.setMaxPeople(4);
            facility.setStandardRoom("Deluxe");
            facility.setDescription("Deluxe Room");
            facility.setPoolArea(0);
            facility.setNumberOfFloors(1);
            facility.setTypeFacility(typeFacilityRepository.findByName("ROOM"));
            facility.setTypeRent(typeRentRepository.findByName("HOUR"));
            facility.setDeleted(false);
            facilityRepository.save(facility);
        }
        if (facilityRepository.findByName("ROOM 3") == null) {
            Facility facility = new Facility();
            facility.setName("ROOM 3");
            facility.setCost(600);
            facility.setArea(40);
            facility.setMaxPeople(4);
            facility.setStandardRoom("Executive");
            facility.setDescription("Executive Room");
            facility.setPoolArea(0);
            facility.setNumberOfFloors(1);
            facility.setTypeFacility(typeFacilityRepository.findByName("ROOM"));
            facility.setTypeRent(typeRentRepository.findByName("DAY"));
            facility.setDeleted(false);
            facilityRepository.save(facility);
        }
        if (facilityRepository.findByName("SUITE 1") == null) {
            Facility facility = new Facility();
            facility.setName("SUITE 1");
            facility.setCost(1200);
            facility.setArea(100);
            facility.setMaxPeople(8);
            facility.setStandardRoom("Small Suite");
            facility.setDescription("Small Suite");
            facility.setPoolArea(0);
            facility.setNumberOfFloors(1);
            facility.setTypeFacility(typeFacilityRepository.findByName("SUITE"));
            facility.setTypeRent(typeRentRepository.findByName("DAY"));
            facility.setDeleted(false);
            facilityRepository.save(facility);
        }
        if (facilityRepository.findByName("SUITE 2") == null) {
            Facility facility = new Facility();
            facility.setName("SUITE 2");
            facility.setCost(1500);
            facility.setArea(100);
            facility.setMaxPeople(8);
            facility.setStandardRoom("Presidential Suite");
            facility.setDescription("Presidential Suite");
            facility.setPoolArea(20);
            facility.setNumberOfFloors(2);
            facility.setTypeFacility(typeFacilityRepository.findByName("SUITE"));
            facility.setTypeRent(typeRentRepository.findByName("DAY"));
            facility.setDeleted(false);
            facilityRepository.save(facility);
        }
        if (facilityRepository.findByName("Villa 1") == null) {
            Facility facility = new Facility();
            facility.setName("Villa 1");
            facility.setCost(2000);
            facility.setArea(300);
            facility.setMaxPeople(8);
            facility.setStandardRoom("Villa");
            facility.setDescription("Villa");
            facility.setPoolArea(20);
            facility.setNumberOfFloors(2);
            facility.setTypeFacility(typeFacilityRepository.findByName("VIILA"));
            facility.setTypeRent(typeRentRepository.findByName("DAY"));
            facility.setDeleted(false);
            facilityRepository.save(facility);
        }
        if (attachFacilityRepository.findByName("ROOM 1") == null) {
            AttachFacility attachFacility = new AttachFacility();
            attachFacility.setName("ROOM 1");
            attachFacility.setCost(400);
            attachFacility.setDescription("Standard room");
            attachFacility.setImage("https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/standard-room.jpg?alt=media&token=63c4edb3-7a35-410c-b296-c733172e0af2");
            attachFacility.setUnit(3);
            attachFacility.setDeleted(false);
            attachFacilityRepository.save(attachFacility);
        }
        if (attachFacilityRepository.findByName("ROOM 2") == null) {
            AttachFacility attachFacility = new AttachFacility();
            attachFacility.setName("ROOM 2");
            attachFacility.setCost(500);
            attachFacility.setDescription("Deluxe Room");
            attachFacility.setUnit(3);
            attachFacility.setImage("https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/dex-room.jpg?alt=media&token=a169c143-a513-48d4-99cc-40d165114d88");
            attachFacility.setDeleted(false);
            attachFacilityRepository.save(attachFacility);
        }
        if (attachFacilityRepository.findByName("ROOM 3") == null) {
            AttachFacility attachFacility = new AttachFacility();
            attachFacility.setName("ROOM 3");
            attachFacility.setCost(600);
            attachFacility.setUnit(3);
            attachFacility.setImage("https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/ex-room.jpg?alt=media&token=e832ebf7-d112-4de3-a5b4-a2a54535be6c");
            attachFacility.setDescription("Executive Room");
            attachFacility.setDeleted(false);
            attachFacilityRepository.save(attachFacility);
        }
        if (attachFacilityRepository.findByName("SUITE 1") == null) {
            AttachFacility attachFacility = new AttachFacility();
            attachFacility.setName("SUITE 1");
            attachFacility.setCost(1200);
            attachFacility.setDescription("Small Suite");
            attachFacility.setUnit(3);
            attachFacility.setImage("https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/suite.jpg?alt=media&token=a08fdd7d-2060-46cb-b4aa-79ca387c2a8f");
            attachFacility.setDeleted(false);
            attachFacilityRepository.save(attachFacility);
        }
        if (attachFacilityRepository.findByName("SUITE 2") == null) {
            AttachFacility attachFacility = new AttachFacility();
            attachFacility.setName("SUITE 2");
            attachFacility.setCost(1500);
            attachFacility.setUnit(3);
            attachFacility.setImage("https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/suite-big.jpg?alt=media&token=a9055a45-a8dc-49fb-95c2-f539ca37c56c");
            attachFacility.setDescription("Presidential Suite");
            attachFacility.setDeleted(false);
            attachFacilityRepository.save(attachFacility);
        }
        if (attachFacilityRepository.findByName("Villa 1") == null) {
            AttachFacility attachFacility = new AttachFacility();
            attachFacility.setName("Villa 1");
            attachFacility.setCost(2000);
            attachFacility.setDescription("Villa");
            attachFacility.setUnit(3);
            attachFacility.setImage("https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/villa.jpg?alt=media&token=884beb65-c03b-40f0-ae02-c29e7b354361");
            attachFacility.setDeleted(false);
            attachFacilityRepository.save(attachFacility);
        }


    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}