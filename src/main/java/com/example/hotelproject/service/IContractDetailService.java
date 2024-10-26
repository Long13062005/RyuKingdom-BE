package com.example.hotelproject.service;

public interface IContractDetailService {
    void deleteContractDetail(Long id);
    void updateContractDetail(Long id, String name);
    void addContractDetail(String name);
    void getAllContractDetails();
    void getContractDetailById(Long id);
    void getContractDetailByName(String name);
}
