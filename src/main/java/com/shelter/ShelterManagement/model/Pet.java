package com.shelter.ShelterManagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@SuppressWarnings({"LombokGetterMayBeUsed", "LombokSetterMayBeUsed"})
@Entity
public class Pet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 2, max = 50, message = "Name must have at least 2 characters")
    private String name;

    @NotEmpty(message = "Species can't be empty")
    private String species;

    @Positive(message = "Age must be positive")
    private int age;

    private boolean isAdopted;
    private boolean isVaccinated;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    @JsonIgnore
    private Shelter shelter;

    // cstr no args

    public Pet() {
    }

    // cstr All args


    public Pet(Shelter shelter, boolean isVaccinated, boolean isAdopted, int age, String species, String name, Long id) {
        this.shelter = shelter;
        this.isVaccinated = isVaccinated;
        this.isAdopted = isAdopted;
        this.age = age;
        this.species = species;
        this.name = name;
        this.id = id;
    }

    //getters & setters


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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }
}
