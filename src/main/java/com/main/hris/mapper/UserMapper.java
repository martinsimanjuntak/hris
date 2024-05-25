package com.main.hris.mapper;

import com.main.hris.dto.request.UserRequestDto;
import com.main.hris.dto.response.RoleResponseDto;
import com.main.hris.dto.response.UserResponseDto;
import com.main.hris.entity.RoleEntity;
import com.main.hris.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = RoleMapper.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserEntity toUserEntity(UserRequestDto userRequestDto);

    UserResponseDto toUserResponseDto(UserEntity userEntity);
    List<UserResponseDto> toUserResponseDtoList(List<UserEntity> userEntities);
}
