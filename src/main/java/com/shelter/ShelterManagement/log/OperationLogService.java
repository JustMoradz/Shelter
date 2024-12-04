package com.shelter.ShelterManagement.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogService {

    @Autowired
    private OperationLogRepository operationLogRepository;

    public void saveOperationLog(String operationType, String entityType, String entityId, String details, String userId) {
        OperationLog log = new OperationLog();
        log.setOperationType(operationType);
        log.setEntityType(entityType);
        log.setEntityId(entityId);
        log.setDetails(details);
        log.setUserId(userId);

        operationLogRepository.save(log);
    }
}
