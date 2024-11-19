package com.main.hris.repository;

import com.main.hris.entity.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IUserTokenRepository extends JpaRepository<UserTokenEntity, String>,
        JpaSpecificationExecutor<UserTokenEntity> {
    Optional<UserTokenEntity> findUserTokenEntityByToken(String token);

}
