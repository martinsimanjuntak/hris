package com.main.hris.entity;

import com.main.hris.entity.base.AMaintenanceEntity;
import com.main.hris.entity.listener.EmployeeEntityListener;
import com.main.hris.entity.listener.EmployeeStatusEntityListener;
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
@EntityListeners({EmployeeStatusEntityListener.class})
@Table(name = "TRX_EMPLOYEE_STATUS")
public class EmployeeStatusEntity extends AMaintenanceEntity {
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private List<EmployeeEntity> employee;
    @Column(name = "NAME")
    private String name;
}
