package com.example.yourlocalpharmacy.Model;

import lombok.Data;
import org.hibernate.mapping.Any;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Map;

@Data
public class Pharmacy {
    @Id
    int Id;
    String Name;
    double Lat;
    double Lon;
    String Settlement;
    String Municipality;
    String City;
    int postalCode;
    String Country;
    String Email;
    String Phone;

    public Pharmacy(Map<String, String> data) {
        this.Name = data.get("name");
        this.Lat = Double.parseDouble(data.get("lat"));
        this.Lon = Double.parseDouble(data.get("lon"));
        this.Settlement = data.get("Settlement");
        this.Municipality = data.get("Municipality");
        this.City = data.get("City");
        this.postalCode = Integer.parseInt(data.get("postalCode"));
        this.Country = data.get("Country");
    }
}
