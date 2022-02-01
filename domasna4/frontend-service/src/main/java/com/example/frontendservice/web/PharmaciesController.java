package com.example.frontendservice.web;

import com.example.frontendservice.model.Pharmacy;
import com.example.frontendservice.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PharmaciesController {

    private final PharmacyService pharmacyService;

    public PharmaciesController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping("/json")
    public List<Pharmacy> json() {
        return this.pharmacyService.listAll();
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("pharmacies", pharmacyService.listAll());
        return "home.html";
    }
}
