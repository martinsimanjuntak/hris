package com.main.hris.service;

import com.main.hris.dto.request.UserRequestDto;
import com.main.hris.dto.response.ResponseDto;
import com.main.hris.dto.response.ResponseStatusOnlyDto;
import com.main.hris.dto.response.UserResponseDto;
import com.main.hris.entity.UserEntity;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import com.main.hris.exception.UserException;
import com.main.hris.mapper.UserMapper;
import com.main.hris.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseStatusOnlyDto registerUser(UserRequestDto requestDto){

        Optional<UserEntity> userEntityOptional= userRepository.findUserByUsername(requestDto.getUsername());
        if (userEntityOptional.isPresent()){
            throw new UserException(UserException.USERNAME_ALREADY_EXIST);
        }
        UserEntity userEntity;
        userEntity = UserMapper.INSTANCE.toUserEntity(requestDto);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setDelete(false);
        userRepository.save(userEntity);
        return new ResponseStatusOnlyDto(ResponseDtoStatusEnum.SUCCESS);

    }

    public ResponseDto<List<UserResponseDto>> findAllUserNameByIsDelete(boolean isDelete){
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
     userEntity.setDelete(true);
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
