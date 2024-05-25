package com.main.hris.controller;

import com.main.hris.dto.request.UserRequestDto;
import com.main.hris.dto.response.ResponseDto;
import com.main.hris.dto.response.ResponseStatusOnlyDto;
import com.main.hris.dto.response.UserResponseDto;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import com.main.hris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController extends AProcessFlowController{
    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<ResponseStatusOnlyDto> registerUser(@RequestBody UserRequestDto requestDto){
        return createResponse(userService.registerUser(requestDto));
    }

    @GetMapping("getList")
    public ResponseEntity<ResponseDto<List<UserResponseDto>>> getList(@RequestParam boolean isDelete){
        return createResponse(userService.findAllUserNameByIsDelete(isDelete));
    }

    @DeleteMapping("delete")
    public ResponseEntity<ResponseStatusOnlyDto> deleteUser(@RequestParam String userId){
          return createResponse(userService.hardDeleteUserById(userId));
    }

    @PutMapping("updateUsername")
    public ResponseEntity<ResponseStatusOnlyDto> updateUsername(@RequestBody UserRequestDto requestDto){
        return createResponse(userService.updateUsernameById(requestDto));
    }

}
