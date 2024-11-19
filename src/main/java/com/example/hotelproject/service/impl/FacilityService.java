package com.example.hotelproject.service.impl;


import com.example.hotelproject.controller.dto.response.FacilityDto;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.repository.FacilityRepository;
import com.example.hotelproject.repository.TypeFacilityRepository;
import com.example.hotelproject.repository.TypeRentRepository;
import com.example.hotelproject.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityService implements IFacilityService {

        @Autowired
        private FacilityRepository facilityRepository;
        @Autowired
        private TypeRentRepository typeRentRepository;
        @Autowired
        private TypeFacilityRepository typeFacilityRepository;

        @Override
        public List<Facility> findAll() {
                return facilityRepository.getAll();
        }

        @Override
        public FacilityDto findById(Long id) {
                FacilityDto facilityDto = new FacilityDto();
                Facility facility = facilityRepository.findById(id).orElse(null);
                facilityDto.setId(facility.getId());
                facilityDto.setName(facility.getName());
                facilityDto.setArea(facility.getArea());
                facilityDto.setCost(facility.getCost());
                facilityDto.setMaxPeople(facility.getMaxPeople());
                facilityDto.setStandardRoom(facility.getStandardRoom());
                facilityDto.setDescription(facility.getDescription());
                facilityDto.setPoolArea(facility.getPoolArea());
                facilityDto.setFloor(facility.getNumberOfFloors());
                facilityDto.setFacilityType(facility.getTypeFacility().getName());
                facilityDto.setRentType(facility.getTypeRent().getName());
                return facilityDto;
        }

        @Override
        public Facility save(FacilityDto facilityDto) {
                Facility facility = new Facility();
                facility.setName(facilityDto.getName());
                facility.setArea(facilityDto.getArea());
                facility.setCost(facilityDto.getCost());
                facility.setMaxPeople(facilityDto.getMaxPeople());
                facility.setStandardRoom(facilityDto.getStandardRoom());
                facility.setDescription(facilityDto.getDescription());
                facility.setPoolArea(facilityDto.getPoolArea());
                facility.setNumberOfFloors(facilityDto.getFloor());
                facility.setTypeFacility(typeFacilityRepository.findByName(facilityDto.getFacilityType()));
                facility.setTypeRent(typeRentRepository.findByName(facilityDto.getRentType()));
                facility.setDeleted(false);
                return facilityRepository.save(facility);
        }

        @Override
        public void delete(Long id) {
                facilityRepository.softDeleteFacilityById(id);
        }

        @Override
        public List<Facility> searchFacilities(String search) {
                return facilityRepository.findByNameContaining(search);
        }

        @Override
        public Facility update(FacilityDto facilityDto, Long id) {
                Facility facility = facilityRepository.findById(id).orElse(null);
                facility.setName(facilityDto.getName());
                facility.setArea(facilityDto.getArea());
                facility.setCost(facilityDto.getCost());
                facility.setMaxPeople(facilityDto.getMaxPeople());
                facility.setStandardRoom(facilityDto.getStandardRoom());
                facility.setDescription(facilityDto.getDescription());
                facility.setPoolArea(facilityDto.getPoolArea());
                facility.setNumberOfFloors(facilityDto.getFloor());
                facility.setTypeFacility(typeFacilityRepository.findByName(facilityDto.getFacilityType()));
                facility.setTypeRent(typeRentRepository.findByName(facilityDto.getRentType()));
                facility.setDeleted(false);
                return facilityRepository.save(facility);
        }
}
