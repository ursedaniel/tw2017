package com.proiect.tw.exception;

/**
 * Created by JACK on 4/21/2017.
 */
public class ErrorMessage {

    private String code;
    private String message;

    public ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
