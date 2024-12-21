package com.example.hotelproject.service.impl;

import com.example.hotelproject.controller.dto.response.ContractDto;
import com.example.hotelproject.entities.*;
import com.example.hotelproject.repository.*;
import com.example.hotelproject.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Page<Contract> getAll(Pageable pageable) {
        return contractRepository.getAll(pageable);
    }

    @Override
    public List<Contract> findByCustomer(Long id) {
        return contractRepository.findByCustomer(id);
    }

    @Override
    public ContractDto getById(Long id) {
        ContractDto contractDto = new ContractDto();
        Contract contract = contractRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(contract, contractDto);
        contractDto.setCustomerName(contract.getCustomer().getName());
        contractDto.setEmployeeName(contract.getEmployee().getName());
        contractDto.setFacilityName(contract.getFacility().getName());
        contractDto.setPayment(contract.getPayment().getTitle());
        contractDto.setStatus(switch (contract.getStatus()) {
            case 1 -> "pending";
            case 0 -> "done";
            default -> "canceled";
        });
        return contractDto;
    }

    @Override
    public Contract save(ContractDto contractDto) {

        Contract contract = new Contract();
        Payment payment = paymentRepository.findByTitle(contractDto.getPayment());
        Customer customer = customerRepository.findByName(contractDto.getCustomerName());
        Employee employee = employeeRepository.findByUser_Username(contractDto.getEmployeeName());
        Facility facility = facilityRepository.findByName(contractDto.getFacilityName());
        BeanUtils.copyProperties(contractDto, contract);
        contract.setStatus(switch (contractDto.getStatus()) {
            case "pending" -> 1;
            case "done" -> 0;
            default -> 2;
        });
        contract.setPayment(payment);
        contract.setFacility(facility);
        contract.setEmployee(employee);
        contract.setCustomer(customer);
        return contractRepository.save(contract);
    }

    @Override
    public void delete(Long id) {
        contractRepository.softDeleteContractById(id);
    }

    @Override
    public Contract update(ContractDto contractDto, Long id) {
        Contract contractNew = contractRepository.findById(id).orElse(null);
        Payment payment = paymentRepository.findByTitle(contractDto.getPayment());
        Customer customer = customerRepository.findByName(contractDto.getCustomerName());
        Employee employee = employeeRepository.findByUser_Username(contractDto.getEmployeeName());
        Facility facility = facilityRepository.findByName(contractDto.getFacilityName());

        contractNew.setHistoryCheck(contractDto.getHistoryCheck());
        contractNew.setDateEnd(contractDto.getDateEnd());
        contractNew.setDateStart(contractDto.getDateStart());
        contractNew.setDeposit(contractDto.getDeposit());
        contractNew.setStatus(switch (contractDto.getStatus()) {
            case "pending" -> 1;
            case "done" -> 0;
            default -> 2;
        });
        contractNew.setPayment(payment);
        contractNew.setFacility(facility);
        contractNew.setEmployee(employee);
        contractNew.setCustomer(customer);
        return contractRepository.save(contractNew);
    }
}
