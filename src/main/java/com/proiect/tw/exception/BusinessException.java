package com.proiect.tw.exception;

/**
 * Created by JACK on 4/21/2017.
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;

    public BusinessException(String message) {
        this((String) null, message);
    }

    public BusinessException(String code, String message) {
        this(code, message, null);
    }

    public BusinessException(String message, Throwable cause) {
        this(null, message, cause);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
