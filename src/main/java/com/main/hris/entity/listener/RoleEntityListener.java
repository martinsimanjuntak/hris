package com.main.hris.entity.listener;

import com.main.hris.entity.RoleEntity;
import com.main.hris.entity.UserEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class RoleEntityListener {
    @PrePersist
    void prePersist(RoleEntity entity){
        if (entity.getId() == null){
            entity.setId(UUID.randomUUID().toString());
        }
    }
}
