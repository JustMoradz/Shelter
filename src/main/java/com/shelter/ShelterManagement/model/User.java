package com.shelter.ShelterManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username can't be empty")
    private String username;
    private String password;

    @NotEmpty(message = "Species can't be empty")
    private String email;
    private String role; // User or Admin

    @OneToMany(mappedBy = "user")
    private List<AdoptionRequest> listOfAdoptions;

    //cstr No arg

    public User() {
    }

    //cstr All arg


    public User(Long id, List<AdoptionRequest> listOfAdoptions, String role, String password, String username, String email) {
        this.id = id;
        this.listOfAdoptions = listOfAdoptions;
        this.role = role;
        this.password = password;
        this.username = username;
        this.email = email;
    }


    //getters & setters


    public List<AdoptionRequest> getListOfAdoptions() {
        return listOfAdoptions;
    }

    public void setListOfAdoptions(List<AdoptionRequest> listOfAdoptions) {
        this.listOfAdoptions = listOfAdoptions;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
