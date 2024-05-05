package com.main.hris.dto.response;

import com.main.hris.enumeration.ResponseDtoStatusEnum;

public class ResponseStatusOnlyDto extends AResponseDto {
    public ResponseStatusOnlyDto(ResponseDtoStatusEnum responseDtoStatusEnum) {
        super(responseDtoStatusEnum);
    }

    public ResponseStatusOnlyDto() {
    }
}
