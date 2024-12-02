package com.main.hris.service;

import com.main.hris.dto.request.AuthenticationRequestDto;
import com.main.hris.dto.request.UserTokenRequestDto;
import com.main.hris.dto.response.FileResponseDto;
import com.main.hris.entity.UserEntity;
import com.main.hris.exception.UserException;
import com.main.hris.repository.IUserRepository;
import com.main.hris.repository.IUserTokenRepository;
import com.main.hris.service.token.TokenService;
import com.main.hris.util.JwtUtil;
import com.main.hris.util.LmpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserTokenRepository userTokenRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private TokenService tokenService;


    public String login(AuthenticationRequestDto requestDto){
        Optional<UserEntity> userEntityOptional= userRepository.findUserByUsername(requestDto.getUsername());
        if (!userEntityOptional.isPresent()){
            throw new UserException(UserException.RECORD_NOT_FOUND);
        }
        if (userEntityOptional.get().getUsername().equals(requestDto.getUsername())
                && bCryptPasswordEncoder.matches(requestDto.getPassword(), userEntityOptional.get().getPassword())
        ){
            String token = JwtUtil.generateToken(requestDto);
            UserTokenRequestDto userTokenRequestDto = new UserTokenRequestDto();
            userTokenRequestDto.setToken(token);
            userTokenRequestDto.setName(userEntityOptional.get().getUsername());
            tokenService.saveToken(userEntityOptional.get().getUsername(), token);
            return token;

        }
        return null;

    }


}
