package com.shelter.ShelterManagement.service;

import com.shelter.ShelterManagement.log.OperationLogService;
import com.shelter.ShelterManagement.model.Pet;
import com.shelter.ShelterManagement.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OperationLogService operationLogService;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> findByName(String name) {
        return petRepository.findByNameIgnoreCase(name);
    }

    public List<Pet> findBySpecies(String species) {
        return petRepository.findBySpeciesIgnoreCase(species);
    }

    public Pet addPet(Pet pet) {
        Pet savedPet = petRepository.save(pet);

        operationLogService.saveOperationLog(
                "ADD",
                "Pet",
                savedPet.getId().toString(),
                "Added new pet: " + savedPet.getName(),
                "user123");
        return savedPet;
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    public Pet updatePet(Long id, Pet pet) {
        Optional<Pet> existingPet = petRepository.findById(id);
        if(existingPet.isPresent()) {
            Pet updatedPet = existingPet.get();
            updatedPet.setName(pet.getName());
            updatedPet.setSpecies(pet.getSpecies());
            updatedPet.setAge(pet.getAge());
            updatedPet.setAdopted(pet.isAdopted());
            updatedPet.setVaccinated(pet.isVaccinated());
            updatedPet.setShelter(pet.getShelter());
            Pet savedPet = petRepository.save(updatedPet);

            operationLogService.saveOperationLog(
                    "UPDATE",
                    "Pet",
                    savedPet.getId().toString(),
                    "Updated pet: " + savedPet.getName(),
                    "user123"
            );
            return savedPet;
        } else {
            throw new RuntimeException("Pet not found! :(");
        }
    }
}