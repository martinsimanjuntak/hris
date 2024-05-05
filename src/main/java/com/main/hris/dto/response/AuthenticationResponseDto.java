package com.main.hris.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class AuthenticationResponseDto {
    private String token;

    public AuthenticationResponseDto(String token) {
        this.token = token;
    }
}
