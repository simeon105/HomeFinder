package com.example.frontendservice.service;

import com.example.frontendservice.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    Pharmacy findById(Integer id);

    List<Pharmacy> listAll();
}
