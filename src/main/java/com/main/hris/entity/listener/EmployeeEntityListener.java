package com.main.hris.entity.listener;

import com.main.hris.entity.EmployeeEntity;
import com.main.hris.entity.RoleEntity;
import com.main.hris.entity.UserEntity;
import com.main.hris.util.SecurityUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class EmployeeEntityListener {
    @PrePersist
    void prePersist(EmployeeEntity entity){
        if (entity.getId() == null){
            entity.setId(UUID.randomUUID().toString());
        }
        if (entity.getCreatedBy() == null) {
            entity.setCreatedBy(SecurityUtils.getUsername());
        }
        if (entity.getCreatedDate() == null) {
            entity.setCreatedDate(LocalDateTime.now());
        }
    }
    @PreUpdate
    void onPreUpdate(EmployeeEntity entity) {
        if (entity.getUpdatedBy() == null) {
            entity.setUpdatedBy(SecurityUtils.getUsername());
        }
        if (entity.getUpdateDate() == null) {
            entity.setUpdateDate(LocalDateTime.now());
        }
    }
}
