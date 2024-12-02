package com.main.hris.util;

import com.main.hris.context.ApplicationContextProvider;
import com.main.hris.dto.other.TokenUserDetails;
import com.main.hris.dto.request.UserTokenRequestDto;
import com.main.hris.entity.PathMappingEntity;
import com.main.hris.entity.UserTokenEntity;
import com.main.hris.exception.GeneralException;
import com.main.hris.repository.IPathMappingRepository;
import com.main.hris.repository.IUserTokenRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class LmpUtil {

    public static List<List<Map<String, String>>> listFieExcel(MultipartFile file){
        List<List<Map<String, String>>> students = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum();

            for (int i = 1; i < rowCount; i++) { // Skip header row
                List<Map<String, String>> mapList = new ArrayList<>();
                Row row = sheet.getRow(i);
                for (int j=0; j<row.getLastCellNum();j++) {
                    Map<String, String> map = new HashMap<>();
                    map.put(sheet.getRow(0).getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
                    mapList.add(map);
                }
                students.add(mapList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void validateUserAccess(String path){
        IPathMappingRepository pathMappingRepository = ApplicationContextProvider.getBean(IPathMappingRepository.class);
        TokenUserDetails tokenUserDetails = SecurityUtils.getUserDetails();
        Optional<PathMappingEntity> pathMappingEntityOptional = pathMappingRepository.findPathMappingEntityByUrlPath(path);
        if(!pathMappingEntityOptional.isPresent()){
            throw new GeneralException(GeneralException.URL_NOT_LEGAL);
        }
        else if(!pathMappingEntityOptional.get().getRole().getName().equals(
                tokenUserDetails.getRoleResponseDto().getName())){
            throw new GeneralException(GeneralException.IS_NOT_BELONG_TO_USER);
        }
    }

    public static void saveToken(UserTokenRequestDto requestDto){
        IUserTokenRepository tokenRepository = ApplicationContextProvider.getBean(IUserTokenRepository.class);
        UserTokenEntity entity = new UserTokenEntity();
        entity.setToken(requestDto.getToken());
        entity.setName(requestDto.getName());
        tokenRepository.save(entity);
    }

    public static void saveTokenToRadis(UserTokenRequestDto requestDto){
        IUserTokenRepository tokenRepository = ApplicationContextProvider.getBean(IUserTokenRepository.class);

    }

}
