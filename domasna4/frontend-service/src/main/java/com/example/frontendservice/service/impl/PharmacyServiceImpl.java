package com.example.frontendservice.service.impl;

import com.example.frontendservice.model.Pharmacy;
import com.example.frontendservice.model.exceptions.InvalidPharmacyIdException;
import com.example.frontendservice.repository.PharmacyRepository;
import com.example.frontendservice.service.PharmacyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public Pharmacy findById(Integer id) {
        return this.pharmacyRepository.findById(id).orElseThrow(InvalidPharmacyIdException::new);
    }

    @Override
    public List<Pharmacy> listAll() {
        return this.pharmacyRepository.findAll();
    }
}
