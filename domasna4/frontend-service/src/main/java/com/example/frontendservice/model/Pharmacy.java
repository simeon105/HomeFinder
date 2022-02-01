package com.example.frontendservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Pharmacies")
@Getter
@Setter
public class Pharmacy {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Lat")
    private String Lat;

    @Column(name = "Lon")
    private String Lon;

    @Column(name = "City")
    private String City;

    @Column(name = "Postal")
    private Integer Postal;

    @Column(name = "Country")
    private String Country;

    @Column(name = "Category")
    private String Category;

    @Column(name = "Icon", columnDefinition = "MEDIUMTEXT")
    private String Icon;

    @Column(name = "Rank")
    private Integer Rank;

    @Column(name = "Importance", columnDefinition = "DECIMAL")
    private Double Importance;

    @Column(name = "Osm")
    private Integer Osm;

    public Pharmacy() {}

    public Pharmacy(String Name, String Lat, String Lon, String City,
                    Integer Postal, String Country, String Category,
                    String Icon, Integer Rank, Double Importance, Integer Osm) {
        this.Name = Name;
        this.Lat = Lat;
        this.Lon = Lon;
        this.City = City;
        this.Postal = Postal;
        this.Country = Country;
        this.Category = Category;
        this.Icon = Icon;
        this.Rank = Rank;
        this.Importance = Importance;
        this.Osm = Osm;
    }
}
