package com.main.hris.dto.request.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class BaseRequestDto {
    private String id;
}
