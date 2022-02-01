package com.example.pharmacyservice.config;

import com.example.pharmacyservice.model.Pharmacy;
import com.example.pharmacyservice.repository.PharmacyRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class JobScheduler {
    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public JobScheduler(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Scheduled(cron = "*/2 * * * *")
    public void cronJobSch() throws JSONException {
        final List<Pharmacy> pharmacyList = this.pharmacyRepository.findAll();
        for (Pharmacy pharmacy : pharmacyList) {
            this.pharmacyRepository.delete(pharmacy);
        }

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
}
