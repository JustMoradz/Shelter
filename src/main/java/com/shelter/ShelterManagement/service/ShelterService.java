package com.shelter.ShelterManagement.service;

import com.shelter.ShelterManagement.model.Shelter;
import com.shelter.ShelterManagement.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepository shelterRepository;

    @Autowired
    private LambdaService lambdaService; // Aggiungi il servizio Lambda

    public List<Shelter> findByCity(String city) {
        return shelterRepository.findByCity(city);
    }

    public List<Shelter> findAllShelters() {
        return shelterRepository.findAll();
    }


    public Shelter addShelter(Shelter shelter) {
        String payload = "{ \"subject\": \"Nuovo Rifugio Aggiunto\", \"body\": \"Un nuovo rifugio è stato aggiunto: " + shelter.getName() + "\" }";
        String response = lambdaService.invokeLambda(payload); // Chiamata alla funzione Lambda
        return shelterRepository.save(shelter);

    }

    public Shelter updateShelter(Long id, Shelter shelter) {
        Optional<Shelter> exisitingShelter = shelterRepository.findById(id);
        if(exisitingShelter.isPresent()) {
            Shelter updatedShelter = exisitingShelter.get();
            updatedShelter.setAddress(shelter.getAddress());
            updatedShelter.setCity(shelter.getCity());
            updatedShelter.setName(shelter.getName());
            return shelterRepository.save(updatedShelter);
        }
        throw new RuntimeException("Pet not found! :(");

    }
}
