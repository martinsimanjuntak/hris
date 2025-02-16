package com.main.hris.entity.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "version")
    private Integer version;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_date")
    private LocalDateTime updateDate;
}
