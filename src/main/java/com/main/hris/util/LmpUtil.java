package com.main.hris.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
