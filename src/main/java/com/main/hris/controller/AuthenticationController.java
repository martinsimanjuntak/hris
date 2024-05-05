package com.main.hris.controller;

import com.main.hris.dto.request.AuthenticationRequestDto;
import com.main.hris.dto.response.AuthenticationResponseDto;
import com.main.hris.dto.response.FileResponseDto;
import com.main.hris.dto.response.ResponseDto;
import com.main.hris.dto.response.ResponseStatusOnlyDto;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import com.main.hris.exception.ProcessFlowConfigurationException;
import com.main.hris.exception.ProcessFlowRuntimeException;
import com.main.hris.service.AuthenticationService;
import com.main.hris.util.JwtUtil;
import com.main.hris.util.LmpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthenticationController extends AProcessFlowController {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping("/login")
    public ResponseEntity<ResponseDto<AuthenticationResponseDto>> login(@RequestBody AuthenticationRequestDto requestDto)
            throws ProcessFlowRuntimeException, ProcessFlowConfigurationException {
        if (authenticationService.Login(requestDto) == 1){

            return  createResponse(new ResponseDto(ResponseDtoStatusEnum.SUCCESS,
                    new AuthenticationResponseDto(jwtUtil.generateToken(requestDto.getUsername()))));
        }
        return createResponse(new ResponseDto(ResponseDtoStatusEnum.ERROR, null));

    }
//    public String login(@RequestBody AuthenticationRequestDto requestDto){
//        if (authenticationService.Login(requestDto) == 1){
//                    jwtUtil.generateToken(requestDto.getUsername());
//        }
//        return "salah";
//    }

    @PostMapping("/file")
    public ResponseEntity<ResponseDto<FileResponseDto>> file(@RequestParam("file") MultipartFile file){
        List<FileResponseDto> fileResponseDto = authenticationService.file(file);
        return createResponse(new ResponseDto(ResponseDtoStatusEnum.SUCCESS,
                fileResponseDto));

    }
}
