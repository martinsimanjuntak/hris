package com.main.hris.mapper;

import com.main.hris.dto.request.UserRequestDto;
import com.main.hris.dto.response.RoleResponseDto;
import com.main.hris.dto.response.UserResponseDto;
import com.main.hris.entity.RoleEntity;
import com.main.hris.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    RoleResponseDto roleToRoleResponseDto(RoleEntity role);
}
