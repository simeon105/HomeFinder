package com.example.yourlocalpharmacy.Model;

import javax.persistence.*;

@Entity
@Table(name="Pharmacies")
public class Pharmacy {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name="Name")
    private String Name;

    @Column(name="Lat")
    private String Lat;

    @Column(name="Lon")
    private String Lon;

    @Column(name="City")
    private String City;

    @Column(name="Postal")
    private Integer Postal;

    @Column(name="Country")
    private String Country;

    @Column(name="Category")
    private String Category;

    @Column(name="Icon", columnDefinition = "MEDIUMTEXT")
    private String Icon;

    @Column(name="Rank")
    private Integer Rank;

    @Column(name="Importance", columnDefinition = "DECIMAL")
    private Double Importance;

    @Column(name="Osm")
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

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLat() {
        return this.Lat;
    }

    public void setLat(String Lat) {
        this.Lat = Lat;
    }

    public String getLon() {
        return this.Lon;
    }

    public void setLon(String Lon) {
        this.Lon = Lon;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public Integer getPostal() {
        return this.Postal;
    }

    public void setPostal(Integer Postal) {
        this.Postal = Postal;
    }

    public String getCountry() {
        return this.Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getIcon() {
        return this.Icon;
    }

    public void setIcon(String Icon) {
        this.Icon = Icon;
    }

    public Integer getRank() {
        return this.Rank;
    }

    public void setRank(Integer Rank) {
        this.Rank = Rank;
    }

    public Double getImportance() {
        return this.Importance;
    }

    public void setImportance(Double Importance) {
        this.Importance = Importance;
    }

    public Integer getOsm() {
        return this.Osm;
    }

    public void setOsm(Integer Osm) {
        this.Osm = Osm;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "Id=" + Id + ", " +
                "Lat=" + Lat + ", " +
                "Lon=" + Lon + ", " +
                "City='" + City + "', " +
                "Postal=" + Postal + ", " +
                "Country='" + Country + "', " +
                "Category='" + Category + "', " +
                "Icon='" + Icon + "', " +
                "Rank=" + Rank + ", " +
                "Importance=" + Importance + ", " +
                "Osm=" + Osm + "}";
    }
}
