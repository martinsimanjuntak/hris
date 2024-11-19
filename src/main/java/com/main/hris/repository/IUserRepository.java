package com.main.hris.repository;

import com.main.hris.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {
    Optional<UserEntity> findUserByUsername(String username);
    List<UserEntity> findUserByUsernameContaining(String username);

    @Query(value = "SELECT * FROM LMP_USER WHERE IS_DELETE = :isDelete", nativeQuery = true)
    List<UserEntity> findAllByIsDelete(int isDelete);

    Optional<UserEntity> findUserById(String id);

}
