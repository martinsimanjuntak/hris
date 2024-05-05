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
public abstract class AResponseDto {

    public static final String BUSINESS_FIELD = "business";
    public static final String MESSAGE_FIELD = "message";

    public AResponseDto(ResponseDtoStatusEnum status) {
        this.status = status;
    }

    private ResponseDtoStatusEnum status;
    private String message;
    private boolean business;
    private boolean error;
}
