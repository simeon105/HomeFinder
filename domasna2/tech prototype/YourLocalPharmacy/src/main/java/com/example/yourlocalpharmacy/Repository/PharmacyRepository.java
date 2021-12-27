package com.example.yourlocalpharmacy.Repository;

import com.example.yourlocalpharmacy.Model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {
}
