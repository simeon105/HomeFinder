package com.example.pharmaciesservice.service;

import com.example.pharmaciesservice.model.Pharmacy;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PharmacyService {
    Pharmacy findById(Integer id);

    List<Pharmacy> listAll();
}
