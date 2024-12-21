package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.ContractDto;
import com.example.hotelproject.entities.Contract;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.service.impl.ContractService;
import com.example.hotelproject.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;


    @GetMapping()
    public ResponseEntity<?> showAllContracts(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "4") int size
    ) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Contract> contracts = contractService.getAll(pageable);

            if (contracts.isEmpty()) {
                return new ResponseEntity<>("No contracts found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching contracts", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/customer")
    public ResponseEntity<?> showAllContractsByCustomer() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            Customer customer = customerService.findCustomerByUser_Username(username);
            return new ResponseEntity<>(contractService.findByCustomer(customer.getId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Contracts", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getContract(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(contractService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Contracts", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createContract(@RequestBody ContractDto contractDto) {
        try {

            return new ResponseEntity<>(contractService.save(contractDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating Contract", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateContract(@RequestBody ContractDto contractDto    , @PathVariable Long id) {
        try {

            return new ResponseEntity<>(contractService.update(contractDto,id ), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while update Contract", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFacility(@PathVariable Long id) {
        try {
            contractService.delete(id);
            return new ResponseEntity<>("Facility deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting facility", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
