package com.example.hotelproject.service;


import com.example.hotelproject.controller.dto.response.FacilityDto;
import com.example.hotelproject.entities.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IFacilityService {

        Page<Facility> findFacilityByName(String name, Pageable pageable);

        List<Facility> findAll();

        FacilityDto findById(Long id);

        Facility save(FacilityDto facilityDto);

        void delete(Long id);

        List<Facility> searchFacilities(String search);

        Facility update(FacilityDto facilityDto, Long id);



}
