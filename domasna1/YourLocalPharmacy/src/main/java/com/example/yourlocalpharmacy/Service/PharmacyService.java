package com.example.yourlocalpharmacy.Service;

import com.example.yourlocalpharmacy.Model.Pharmacy;
import com.example.yourlocalpharmacy.Repository.PharmacyRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class PharmacyService implements ApplicationListener<ApplicationReadyEvent> {
    private final PharmacyRepository pharmacyRepository;

    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        InputStream inputStream = null;

        try {
            // input
            URLConnection urlConnection = new URL("https://nominatim.openstreetmap.org/search.php?amenity=pharmacy&city=Skopje&format=jsonv2&limit=50").openConnection();
            urlConnection.setRequestProperty("Accept-Charset", "UTF-8");
            urlConnection.setRequestProperty("application/x-www-form-urlencoded; charset=UTF-8", "Content-Type");

            inputStream = urlConnection.getInputStream();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // save
        // for
        // pharmacyRepository.save(new Pharmacy())
    }
}
