package com.shelter.ShelterManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@SuppressWarnings({"LombokGetterMayBeUsed", "LombokSetterMayBeUsed"})
@Entity
public class AdoptionRequest {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String adopterName;
    private String adopterContract;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDate requestDate;

    private boolean isApproved;

    //no args
    public AdoptionRequest() {
    }

    //all args


    public AdoptionRequest(Long id, String adopterName, String adopterContract, Pet pet, User user, LocalDate requestDate, boolean isApproved) {
        this.id = id;
        this.adopterName = adopterName;
        this.adopterContract = adopterContract;
        this.pet = pet;
        this.user = user;
        this.requestDate = requestDate;
        this.isApproved = isApproved;
    }

    //getters & setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getAdopterContract() {
        return adopterContract;
    }

    public void setAdopterContract(String adopterContract) {
        this.adopterContract = adopterContract;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
