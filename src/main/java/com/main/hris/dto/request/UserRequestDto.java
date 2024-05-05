package com.main.hris.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class UserRequestDto {
    private String name;
    private String username;
    private String password;
    private RoleRequestDto role;
}
