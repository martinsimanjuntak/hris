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
import com.main.hris.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IEmployeeRepository employeeRepository;

    @Transactional
    public ResponseStatusOnlyDto registerUser(UserRequestDto requestDto){

        Optional<UserEntity> userEntityOptional= userRepository.findUserByUsername(requestDto.getUsername());
        if (userEntityOptional.isPresent()){
            throw new UserException(UserException.USERNAME_ALREADY_EXIST);
        }
        UserEntity userEntity;
        EmployeeEntity employee =  new EmployeeEntity();
        userEntity = UserMapper.INSTANCE.toUserEntity(requestDto);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setIsDelete(0);
        userEntity.setVersion(0);
        userRepository.save(userEntity);
        employee.setUser(userEntity);
        employeeRepository.save(employee);
        return new ResponseStatusOnlyDto(ResponseDtoStatusEnum.SUCCESS);

    }

    public ResponseDto<List<UserResponseDto>> findAllUserNameByIsDelete(int isDelete){
        List<UserEntity> userEntityList = userRepository.findAllByIsDelete(isDelete);
        if (userEntityList.isEmpty()){
            throw new UserException(UserException.RECORD_NOT_FOUND);
        }
        return new ResponseDto<>(ResponseDtoStatusEnum.SUCCESS,
                UserMapper.INSTANCE.toUserResponseDtoList(userEntityList));
    }

    public ResponseStatusOnlyDto softDeleteUserById(String id){
     Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
     if (!optionalUserEntity.isPresent()){
         throw new UserException(UserException.RECORD_NOT_FOUND);
     }
     UserEntity userEntity = optionalUserEntity.get();
     userEntity.setIsDelete(1);
     userRepository.save(userEntity);

     return new ResponseStatusOnlyDto(ResponseDtoStatusEnum.SUCCESS);
    }

    public ResponseStatusOnlyDto hardDeleteUserById(String id){
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (!optionalUserEntity.isPresent()){
            throw new UserException(UserException.RECORD_NOT_FOUND);
        }
        userRepository.delete(optionalUserEntity.get());

        return new ResponseStatusOnlyDto(ResponseDtoStatusEnum.SUCCESS);
    }

    public ResponseStatusOnlyDto updateUsernameById(UserRequestDto requestDto){
        Optional<UserEntity> optionalUserEntity =  userRepository.findUserById(requestDto.getId());
        if (!optionalUserEntity.isPresent()){
            throw new UserException(UserException.RECORD_NOT_FOUND);
        }
        UserEntity userEntity = optionalUserEntity.get();
        userEntity.setUsername(requestDto.getUsername());
        userRepository.save(userEntity);

        return new ResponseStatusOnlyDto(ResponseDtoStatusEnum.SUCCESS);
    }


}
