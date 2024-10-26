package com.example.hotelproject.service;

public interface IContractService {
    void deleteContract(Long id);
    void updateContract(Long id, String name);
    void addContract(String name);
    void getAllContracts();
    void getContractById(Long id);
    void getContractByName(String name);
}
