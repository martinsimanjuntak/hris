package com.main.hris.entity;

import com.main.hris.entity.base.AMaintenanceEntity;
import com.main.hris.entity.listener.EmployeeEntityListener;
import com.main.hris.entity.listener.PathMappingListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@EntityListeners({PathMappingListener.class})
@Table(name = "lmp_path_mapping")
public class PathMappingEntity extends AMaintenanceEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    private RoleEntity role;
    @Column(name = "URL_PATH")
    private String urlPath;
    @Column(name = "ALLOW_EDIT")
    private Integer allowedEdit;
    @Column(name = "ALLOW_VIEW")
    private Integer allowedView;
}
