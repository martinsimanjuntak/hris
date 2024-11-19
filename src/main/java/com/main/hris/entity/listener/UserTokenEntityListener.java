package com.main.hris.entity.listener;

import com.main.hris.entity.UserEntity;
import com.main.hris.entity.UserTokenEntity;
import com.main.hris.util.SecurityUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserTokenEntityListener {
    @PrePersist
    void prePersist(UserTokenEntity entity){
        if (entity.getId() == null){
            entity.setId(UUID.randomUUID().toString());
        }
        if (entity.getCreatedDate() == null) {
            entity.setCreatedDate(LocalDateTime.now());
        }
    }
}
