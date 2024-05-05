package com.main.hris.entity.listener;

import com.main.hris.entity.UserEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class UserEntityListener {
    @PrePersist
    void prePersist(UserEntity entity){
        if (entity.getId() == null){
            entity.setId(UUID.randomUUID().toString());
        }
    }
}
