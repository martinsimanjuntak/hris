package com.main.hris.controller;

import com.main.hris.dto.request.UserRequestDto;
import com.main.hris.dto.response.ResponseStatusOnlyDto;
import com.main.hris.entity.UserEntity;
import com.main.hris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends AProcessFlowController{
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStatusOnlyDto> registerUser(@RequestBody UserRequestDto requestDto){
        return createResponse(userService.registerUser(requestDto));
    }


}
