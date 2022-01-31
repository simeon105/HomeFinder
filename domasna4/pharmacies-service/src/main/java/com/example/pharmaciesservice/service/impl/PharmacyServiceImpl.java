package com.example.pharmaciesservice.service.impl;

import com.example.pharmaciesservice.model.Pharmacy;
import com.example.pharmaciesservice.model.exceptions.InvalidCategoryIdException;
import com.example.pharmaciesservice.repository.PharmacyRepository;
import com.example.pharmaciesservice.service.PharmacyService;
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
        return this.pharmacyRepository.findById(id).orElseThrow(InvalidCategoryIdException::new);
    }

    @Override
    public List<Pharmacy> listAll() {
        return this.pharmacyRepository.findAll();
    }
}
