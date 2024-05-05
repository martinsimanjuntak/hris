package com.main.hris.entity;

import com.main.hris.entity.base.AMaintenanceEntity;
import com.main.hris.entity.listener.EmployeeEntityListener;
import com.main.hris.entity.listener.UserEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@EntityListeners({EmployeeEntityListener.class})
@Table(name = "MSTR_EMPLOYEE")
public class EmployeeEntity extends AMaintenanceEntity {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private List<UserEntity> user;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "BIRTH_DATE")
    private LocalDateTime birthDate;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "ENTRY_DATE")
    private LocalDateTime entryDate;
}
