package com.main.hris.entity;

import com.main.hris.entity.base.AMaintenanceEntity;
import com.main.hris.entity.listener.RoleEntityListener;
import com.main.hris.entity.listener.UserEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@EntityListeners({RoleEntityListener.class})
@Table(name = "LMP_ROLE")
public class RoleEntity extends AMaintenanceEntity {
    @Column(name = "NAME")
    private String name;
}
