package com.main.hris.entity.listener;

import com.main.hris.entity.EmployeeEntity;
import com.main.hris.entity.UserEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class EmployeeEntityListener {
    @PrePersist
    void prePersist(EmployeeEntity entity){
        if (entity.getId() == null){
            entity.setId(UUID.randomUUID().toString());
        }
    }
}
