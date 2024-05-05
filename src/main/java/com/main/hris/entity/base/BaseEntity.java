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
    @Column(name = "ID")
    private String id;
    @Column(name = "VERSION")
    private String version;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updateDate;
}
