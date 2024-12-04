package com.shelter.ShelterManagement.control;

import com.shelter.ShelterManagement.service.LambdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lambda")
public class LambdaController {

    @Autowired
    private LambdaService lambdaService;

    @PostMapping("/invoke")
    public String invokeLambda(@RequestBody String payload) {
        // Invoca la funzione Lambda con il payload JSON ricevuto
        return lambdaService.invokeLambda(payload);
    }
}
