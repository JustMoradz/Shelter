package com.shelter.ShelterManagement.control;

import com.shelter.ShelterManagement.model.Pet;
import com.shelter.ShelterManagement.model.Shelter;
import com.shelter.ShelterManagement.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @GetMapping
    public ResponseEntity<List<Shelter>> allShelters() {
        List<Shelter> shelters = shelterService.findAllShelters();
        return ResponseEntity.ok(shelters);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Shelter>> findByName(@RequestParam String city) {
        List<Shelter> listOfShelters = shelterService.findByCity(city);
        return ResponseEntity.ok(listOfShelters);
    }


    @PostMapping
    public ResponseEntity<Shelter> addShelter(@RequestBody Shelter shelter) {
        Shelter shelter1 = shelterService.addShelter(shelter);
        return new ResponseEntity<>(shelter1, HttpStatus.CREATED);
    }

    @PutMapping("/{}")
    public ResponseEntity<Shelter> updateShelter(@PathVariable Long id, @RequestBody Shelter shelter) {
        Shelter updatedShelter = shelterService.updateShelter(id, shelter);
        return new ResponseEntity<>(shelter, HttpStatus.OK);
    }

}
