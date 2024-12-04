package com.shelter.ShelterManagement.service;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;
import software.amazon.awssdk.core.SdkBytes;
import org.springframework.stereotype.Service;

@Service
public class LambdaService {

    private final LambdaClient lambdaClient;

    public LambdaService() {
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(
                "INSERT YOUR ACCESS KEY", // Usa variabili d'ambiente in produzione
                "INSER YOUR CODE BRO :)"
        );
        this.lambdaClient = LambdaClient.builder()
                .region(Region.EU_NORTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
    }

    public String invokeLambda(String payload) {
        // Converte il payload in SdkBytes
        SdkBytes sdkPayload = SdkBytes.fromUtf8String(payload);

        InvokeRequest request = InvokeRequest.builder()
                .functionName("FunzioneShelter") // Nome della funzione Lambda
                .payload(sdkPayload) // Usa SdkBytes come payload
                .build();

        InvokeResponse response = lambdaClient.invoke(request);

        return response.payload().asUtf8String(); // Restituisce il risultato come stringa
    }
}
