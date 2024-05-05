package com.main.hris.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class FileResponseDto {
    private String id;
    private String name;
    private String grade;
    private String gender;
    private String phone;
    private String address;
    private String username;


    public FileResponseDto(
            String id, String name, String grade, String gender, String phone, String address, String username) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.username = username;
    }
}
