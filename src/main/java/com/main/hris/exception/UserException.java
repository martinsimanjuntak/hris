package com.main.hris.exception;

public class UserException extends RuntimeException {
    public static final String USERNAME_ALREADY_EXIST = "username already exist";
    public static final String USERNAME_NOT_FOUND = "username not found";
    public static final String PASSWORD_NOT_FOUND = "password not found";
    public static final String RECORD_NOT_FOUND = "record not found";

    public UserException(String message) {
        super(message);
    }

}
