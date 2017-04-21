package com.proiect.tw.exception;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Priority;

/**
 * Created by JACK on 4/21/2017.
 */
@ControllerAdvice
@Priority(Ordered.HIGHEST_PRECEDENCE)
public class WebExceptionHandler {

    private static final Logger LOG = Logger.getLogger(WebExceptionHandler.class);

    private ResponseEntity<ErrorMessage> createResponse(String code, String message) {
        return new ResponseEntity<>(new ErrorMessage(code, message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handleBusinessException(BusinessException businessException) {
        LOG.error(businessException.getMessage(), businessException);
        return createResponse(businessException.getCode(), businessException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException runtimeException) {
        LOG.error(runtimeException.getMessage(), runtimeException);
        return createResponse(null, runtimeException.getMessage());
    }
}
