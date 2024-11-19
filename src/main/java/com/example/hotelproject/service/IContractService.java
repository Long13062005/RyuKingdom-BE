package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.ContractDto;
import com.example.hotelproject.entities.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> getAll();

    List<Contract> findByCustomer(Long id);

    ContractDto getById(Long id);

    Contract save(ContractDto contractDto);

    void delete(Long id);

    Contract update(ContractDto contractDto, Long id);
}
