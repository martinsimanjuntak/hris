package com.main.hris.controller;

import com.main.hris.dto.response.AResponseDto;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

public class ABaseController extends ResponseEntityExceptionHandler {

        protected <T extends AResponseDto> ResponseEntity<T> createResponse(T response) {
            if (Objects.requireNonNull(response.getStatus()) == ResponseDtoStatusEnum.ERROR) {
                response.setMessage(response.getMessage());
                return createResponse(response, HttpStatus.BAD_REQUEST);
            }
            return createResponse(response, HttpStatus.OK);
        }

    protected <T> ResponseEntity<T> createResponse(T response, HttpStatus httpStatus) {
        return new ResponseEntity<>(response, httpStatus);
    }
    protected <T> ResponseEntity<T> createResponse(T response, HttpStatus httpStatus, HttpHeaders httpHeaders) {
        return new ResponseEntity<>(response, httpStatus);
    }

}
