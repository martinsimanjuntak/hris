package com.main.hris.controller;

import com.main.hris.dto.response.AResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ABaseController extends ResponseEntityExceptionHandler {

        protected <T extends AResponseDto> ResponseEntity<T>    createResponse(T response) {
            switch (response.getStatus()) {
                case ERROR:
                    return createResponse(response, HttpStatus.BAD_REQUEST);
                default:
                    return createResponse(response, HttpStatus.OK);
            }
        }


    /**
     * Create {@link ResponseEntity} with input response dto and http status code
     * @param <T> Generic response type
     * @param response response dto
     * @param httpStatus http status code
     * @return {@link ResponseEntity}
     */
    protected <T> ResponseEntity<T> createResponse(T response, HttpStatus httpStatus) {
        return new ResponseEntity<>(response, httpStatus);
    }
}
