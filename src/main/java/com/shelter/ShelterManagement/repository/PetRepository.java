package com.shelter.ShelterManagement.repository;

import com.shelter.ShelterManagement.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByNameIgnoreCase(String name);
    List<Pet> findBySpeciesIgnoreCase(String species);
}
