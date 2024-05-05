package com.main.hris.controller;

import com.main.hris.dto.response.ResponseErrorDto;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import com.main.hris.exception.ProcessFlowRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AProcessFlowController extends ABaseController {
    @ExceptionHandler(ProcessFlowRuntimeException.class)
    public ResponseEntity<ResponseErrorDto> handleBusinessException(ProcessFlowRuntimeException e) {
        ResponseErrorDto errorDto = new ResponseErrorDto();
        errorDto.setStatus(ResponseDtoStatusEnum.ERROR);


        return createResponse(errorDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorDto> handleException(Exception e) {
        ResponseErrorDto errorDto = new ResponseErrorDto();
        errorDto.setStatus(ResponseDtoStatusEnum.ERROR);
        return createResponse(errorDto);
    }

}
