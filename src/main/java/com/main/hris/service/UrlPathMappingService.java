package com.main.hris.service;

import com.main.hris.dto.request.UserRequestDto;
import com.main.hris.dto.response.ResponseDto;
import com.main.hris.dto.response.ResponseStatusOnlyDto;
import com.main.hris.dto.response.UserResponseDto;
import com.main.hris.entity.EmployeeEntity;
import com.main.hris.entity.UserEntity;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import com.main.hris.exception.UserException;
import com.main.hris.mapper.UserMapper;
import com.main.hris.repository.IEmployeeRepository;
import com.main.hris.repository.IPathMappingRepository;
import com.main.hris.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UrlPathMappingService {
    @Autowired
    IPathMappingRepository pathMappingRepository;





}
