package com.main.hris.entity.listener;

import com.main.hris.entity.EmployeeEntity;
import com.main.hris.entity.EmployeeStatusEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class EmployeeStatusEntityListener {
    @PrePersist
    void prePersist(EmployeeStatusEntity entity){
        if (entity.getId() == null){
            entity.setId(UUID.randomUUID().toString());
        }
    }
}
