package com.api.parkingcontrol.data.presenter.controllers.car;

import com.api.parkingcontrol.core.domain.exception.DomainException;
import com.api.parkingcontrol.core.domain.exception.NotFoundException;
import com.api.parkingcontrol.data.presenter.entity.ApiResponse;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CarControllerAdvice extends ResponseEntityExceptionHandler {
    private Logger logger;

    public CarControllerAdvice(Logger logger) {
        this.logger = logger;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> customNotFoundException(NotFoundException ex) {
        logger.error("NotFoundException: {}", ex.toString());

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiResponse apiResponse = ApiResponse.builder()
                .withTimestamp(ZonedDateTime.now(ZoneOffset.UTC))
                .withStatus(httpStatus.value())
                .withReason(httpStatus.getReasonPhrase())
                .withMessage(ex.getMessage())
                .build();
        return new ResponseEntity<ApiResponse>(apiResponse, httpStatus);
    }

    @ExceptionHandler(value = {DomainException.class})
    public ResponseEntity<ApiResponse> customDomainException(DomainException ex) {
        logger.error("DomainException: {}", ex.toString());

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiResponse apiResponse = ApiResponse.builder()
                .withTimestamp(ZonedDateTime.now(ZoneOffset.UTC))
                .withStatus(httpStatus.value())
                .withReason(httpStatus.getReasonPhrase())
                .withMessage(ex.getMessage())
                .build();
        return new ResponseEntity<ApiResponse>(apiResponse, httpStatus);
    }
}
