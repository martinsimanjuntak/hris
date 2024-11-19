package com.main.hris.controller;

import com.main.hris.dto.request.AuthenticationRequestDto;
import com.main.hris.dto.response.ResponseStatusOnlyDto;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import com.main.hris.exception.ProcessFlowConfigurationException;
import com.main.hris.exception.ProcessFlowRuntimeException;
import com.main.hris.service.AuthenticationService;
import com.main.hris.service.TokenBlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController extends AProcessFlowController {
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    TokenBlacklistService tokenBlacklistService;



    @PostMapping("/login")
    public ResponseEntity<ResponseStatusOnlyDto> login(@RequestBody AuthenticationRequestDto requestDto)
            throws ProcessFlowRuntimeException, ProcessFlowConfigurationException {
        HttpHeaders headers = new HttpHeaders();
        String token = authenticationService.login(requestDto);
        if (token != null){
            headers.set("Authorization", token);
            return ResponseEntity.ok().headers(headers)
                    .body(new ResponseStatusOnlyDto(ResponseDtoStatusEnum.SUCCESS));

        }
        return createResponse(new ResponseStatusOnlyDto(ResponseDtoStatusEnum.ERROR));

    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseStatusOnlyDto> logout(@RequestHeader(value = "Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        return createResponse(tokenBlacklistService.addTokenToBlacklist(token, 5));

    }
}
