package com.main.hris.service;

import com.main.hris.config.MapperConfig;
import com.main.hris.dto.request.UserRequestDto;
import com.main.hris.dto.response.ResponseStatusOnlyDto;
import com.main.hris.entity.UserEntity;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import com.main.hris.exception.UserException;
import com.main.hris.repository.IUserRepository;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseStatusOnlyDto registerUser(UserRequestDto requestDto){
        MapperFactory mapperFactory = MapperConfig.getMapperFactory();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        Optional<UserEntity> userEntityOptional= userRepository.findUserByUsername(requestDto.getUsername());
        if (userEntityOptional.isPresent()){
            throw new UserException(UserException.USERNAME_ALREADY_EXIST);
        }
        UserEntity userEntity;
        userEntity = mapperFacade.map(requestDto, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);

        return new ResponseStatusOnlyDto();

    }


}
