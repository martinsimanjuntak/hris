package com.main.hris.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class UserResponseDto{
    @JsonProperty("role")
    private RoleResponseDto role;
    @JsonProperty("username")
    private String username;
    @JsonProperty("name")
    private String name;

}
