package com.main.hris.dto.request;

import com.main.hris.dto.request.base.BaseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class RoleRequestDto extends BaseRequestDto {
    private String name;
}
