package com.main.hris.service;

import com.main.hris.dto.other.TokenUserDetails;
import com.main.hris.dto.response.RoleResponseDto;
import com.main.hris.entity.UserEntity;
import com.main.hris.mapper.RoleMapper;
import com.main.hris.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Optional;

@Service
public class UserDetailsServiceImplement implements UserDetailsService {


    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = userRepository.findUserByUsername(username);
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            // Assuming getAuthorities() returns a collection of GrantedAuthority
            return new TokenUserDetails(
                    userEntity.getUsername(),
                    userEntity.getName(),
                    RoleMapper.INSTANCE.roleToRoleResponseDto(userEntity.getRole())
            );
        }
        throw new UsernameNotFoundException("User not found");
    }
}
