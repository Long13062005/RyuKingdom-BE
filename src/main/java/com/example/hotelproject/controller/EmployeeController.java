package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.EmployeeDto;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping()
    public ResponseEntity<?> showAllEmployees(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "4") int size,
            @RequestParam(required = false, defaultValue = "") String name

    ) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Employee> employees = employeeService.findEmployeesByName(name, pageable);

            if (employees.isEmpty()) {
                return new ResponseEntity<>("No Customer found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Customers", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> showAllEmployees() {
        try {
            return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto) {
        try {

            return new ResponseEntity<>(employeeService.save(employeeDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating Employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long id) {
        try {

            return new ResponseEntity<>(employeeService.update(employeeDto,id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while update Employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting Employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchEmployee(@PathVariable String name) {
        try {
            return new ResponseEntity<>(employeeService.searchEmployee(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
