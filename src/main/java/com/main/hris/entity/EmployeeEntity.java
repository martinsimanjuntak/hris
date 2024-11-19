package com.main.hris.entity;

import com.main.hris.entity.base.AMaintenanceEntity;
import com.main.hris.entity.listener.EmployeeEntityListener;
import com.main.hris.entity.listener.UserEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@EntityListeners({EmployeeEntityListener.class})
@Table(name = "lmp_employee")
public class EmployeeEntity extends AMaintenanceEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private UserEntity user;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday_date")
    private LocalDateTime birthDate;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "department")
    private String department;
    @Column(name = "entry_date")
    private LocalDateTime entryDate;
}
