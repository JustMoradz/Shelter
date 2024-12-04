package com.shelter.ShelterManagement.log;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "operation_logs")
public class OperationLog {

    @Id
    private String id;
    private String operationType;
    private String entityType; //dog or shelter etc etc... :)
    private String entityId;
    private String details;
    private LocalDateTime timestap;
    private String userId;

    //getters & setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestap() {
        return timestap;
    }

    public void setTimestap(LocalDateTime timestap) {
        this.timestap = timestap;
    }
}
