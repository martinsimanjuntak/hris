package com.main.hris.entity.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@MappedSuperclass
public class AMaintenanceEntity extends BaseEntity {
    @Column(name = "IS_DELETE")
    private boolean isDelete;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DETAILS")
    private String details;
}
