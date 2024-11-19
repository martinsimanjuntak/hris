package com.main.hris.repository;

import com.main.hris.entity.EmployeeEntity;
import com.main.hris.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, String>, JpaSpecificationExecutor<UserEntity> {
    Optional<EmployeeEntity> findEmployeeById(String id);

}
