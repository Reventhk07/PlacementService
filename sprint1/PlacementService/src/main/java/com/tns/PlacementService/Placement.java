package com.tns.PlacementService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Placement {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="placementid")
    private Integer placementId;

    @Column(name="companyname")
    private String companyName;

    @Column(name="position")
    private String position;

    @Column(name="location")
    private String location;

    @Column(name="name")
    private String name;

    public Placement() {
        super();
    }

    public Placement(Integer placementId, String companyName, String position, String location, String additionalInformation, String name) {
        super();
        this.placementId = placementId;
        this.companyName = companyName;
        this.position = position;
        this.location = location;
        this.name =  name;
    }

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Placement[Placement ID: " + placementId + ", Company Name: " + companyName + ", Position: " + position
                + ", Location: " + location + ", name: " + name + "]";
    }
}
