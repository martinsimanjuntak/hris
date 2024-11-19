package com.main.hris.entity;

import com.main.hris.entity.base.AMaintenanceEntity;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@EntityListeners({UserEntityListener.class})
@Table(name = "\"lmp_user\"")
public class UserEntity extends AMaintenanceEntity {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    private RoleEntity role;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
