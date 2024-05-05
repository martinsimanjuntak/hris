package com.main.hris.dto.response;

import com.main.hris.enumeration.ResponseDtoStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ResponseDto<DTO> extends AResponseDto {
    private DTO content;

    public ResponseDto(ResponseDtoStatusEnum status, DTO content) {
        super(status);
        this.content = content;
    }
}
