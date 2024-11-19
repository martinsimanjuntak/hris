package com.main.hris.exception;

public class GeneralException extends ABaseException {
    public static final String URL_NOT_LEGAL = "url illegal";
    public static final String IS_NOT_BELONG_TO_USER = "invalid user";
    public static final String PASSWORD_INCORRECT = "password in correct";
    public static final String RECORD_NOT_FOUND = "record not found";

    public GeneralException(String message) {
        super(message);
    }

}
