package com.example.yourlocalpharmacy.Controllers;

import com.example.yourlocalpharmacy.Model.Pharmacy;
import com.example.yourlocalpharmacy.Repository.PharmacyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class PharmacyController implements ApplicationRunner {

    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyController(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    private void getPharmacies() throws JSONException {
        final String uri = "https://nominatim.openstreetmap.org/search.php?amenity=pharmacy&city=Skopje&format=jsonv2&limit=50";

        RestTemplate restTemplate = new RestTemplate();
        JSONArray jsonArray = new JSONArray(restTemplate.getForObject(uri, String.class));

        for(int i=0;i<jsonArray.length();i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            // Name
            String Name = "";
            if (jsonObject.has("display_name")) {
                Name = jsonObject.getString("display_name").split(",")[0];
            }

            // Lat
            String Lat = "";
            if (jsonObject.has("lat")) {
                Lat = jsonObject.getString("lat");
            }

            // Lon
            String Lon = "";
            if (jsonObject.has("lon")) {
                Lon = jsonObject.getString("lon");
            }

            // City
            String City = "Skopje";

            // Postal
            Integer Postal = 1000;

            // Country
            String Country = "Macedonia";

            // Category
            String Category = "amenity";
            if (jsonObject.has("category")) {
                Category = jsonObject.getString("category");
            }

            // Icon
            String Icon = "";
            if (jsonObject.has("icon")) {
                Icon = jsonObject.getString("icon");
            }

            // Rank
            Integer Rank = 0;
            if (jsonObject.has("place_rank")) {
                Rank = jsonObject.getInt("place_rank");
            }

            // Importance
            Double Importance = 0.0;
            if (jsonObject.has("importance")) {
                Importance = Math.round(jsonObject.getDouble("importance")*100.0)/100.0;
            }

            // Osm id
            Integer Osm = 0;
            if (jsonObject.has("osm_id")) {
                Osm = jsonObject.getInt("osm_id");
            }

            pharmacyRepository.save(new Pharmacy(Name, Lat, Lon, City, Postal, Country, Category, Icon, Rank, Importance, Osm));
        }
    }

    public void run(ApplicationArguments args) throws JSONException {
        getPharmacies();
        System.out.println("Simeon moze se");
    }


    @RequestMapping("/json")
    public List<Pharmacy> json () {
        return pharmacyRepository.findAll();
    }


    @RequestMapping("/index")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("messages", pharmacyRepository.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
