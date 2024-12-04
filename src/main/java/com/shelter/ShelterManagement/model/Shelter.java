package com.shelter.ShelterManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
public class Shelter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotEmpty(message = "City can't be empty")
    private String city;

    @NotEmpty(message = "Address can't be empty")
    private String address;

    @OneToMany(mappedBy = "shelter")
    private List<Pet> petList;

    //cstr no ars
    public Shelter() {
    }

    //cstr All ars
    public Shelter(Long id, String name, String city, String address, List<Pet> petList) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.petList = petList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
}
