package com.main.hris.service;

import com.main.hris.dto.request.AuthenticationRequestDto;
import com.main.hris.dto.request.UserTokenRequestDto;
import com.main.hris.dto.response.FileResponseDto;
import com.main.hris.entity.UserEntity;
import com.main.hris.exception.UserException;
import com.main.hris.repository.IUserRepository;
import com.main.hris.repository.IUserTokenRepository;
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
    IUserRepository userRepository;
    @Autowired
    IUserTokenRepository userTokenRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


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
            LmpUtil.saveToken(userTokenRequestDto);
            return token;

        }
        return null;

    }

    public List<FileResponseDto> file(MultipartFile file){
        List<FileResponseDto> fileResponseDtolist = new ArrayList<>();
        List<List<Map<String,String>>> listMapList =LmpUtil.listFieExcel(file);
        for (int i = 0; i < listMapList.size(); i++) {
                FileResponseDto fileResponseDto = new FileResponseDto();
                fileResponseDto.setId(listMapList.get(i).get(0).get("id"));
                fileResponseDto.setName(listMapList.get(i).get(1).get("name"));
                fileResponseDto.setGrade(listMapList.get(i).get(2).get("grade"));
                fileResponseDto.setGender(listMapList.get(i).get(3).get("gender"));
                fileResponseDto.setPhone(listMapList.get(i).get(4).get("phone"));
                fileResponseDto.setAddress(listMapList.get(i).get(5).get("address"));
                fileResponseDto.setUsername(listMapList.get(i).get(6).get("username"));
                fileResponseDtolist.add(fileResponseDto);

        }
        return fileResponseDtolist;

    }


}
