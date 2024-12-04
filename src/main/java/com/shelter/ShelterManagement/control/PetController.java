package com.shelter.ShelterManagement.control;

import com.shelter.ShelterManagement.model.Pet;
import com.shelter.ShelterManagement.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> findAllPets() {
        List<Pet> pets = petService.getAllPets();

        return ResponseEntity.ok(pets);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pet>> findPetByName(@RequestParam String name) {
        List<Pet> pets = petService.findByName(name);
        return ResponseEntity.ok(pets);
    }

    @RequestMapping("/searchBySpecies")
    public ResponseEntity<List<Pet>> findPetsBySpecies(@RequestParam String species) {
        List<Pet> pets = petService.findBySpecies(species);
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        Pet pet1 = petService.addPet(pet);
        return new ResponseEntity<>(pet1,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        Pet updatedPet = petService.updatePet(id, pet);
        return new ResponseEntity<Pet>(updatedPet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
