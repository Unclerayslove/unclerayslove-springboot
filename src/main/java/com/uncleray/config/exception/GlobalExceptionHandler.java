package com.uncleray.config.exception;

import com.uncleray.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @program: uncle-ray
 * @description: 全局异常处理
 * @author: lei pei
 * @create: 2020-10-14 22:53
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Result> exceptionHandler(Exception exception, HttpServletResponse response) {
        int code = 400;
        String message = "";
        if (exception instanceof BindException) {
            // 当对用@Valid注释的参数进行验证失败时，将引发异常。在controller层
            BindException bindException = (BindException) exception;
            message = bindException.getAllErrors().stream().map(be -> be == null ? "" : be.getDefaultMessage())
                    .collect(Collectors.joining(","));
        } else if (exception instanceof ConstraintViolationException) {
            // 报告违反约束的结果 Reports the result of constraint violations.
            ConstraintViolationException cve = (ConstraintViolationException) exception;
            message = cve.getConstraintViolations().stream().map(cv -> cv == null ? "" : cv.getMessage())
                    .collect(Collectors.joining(","));
        } else if (exception instanceof ApiException) {
            // 业务层抛出异常处理
            ApiException se = (ApiException) exception;
            code = se.getCode();
            message = exception.getMessage();
        } else {
            // 其他异常
            exception.printStackTrace();
            message = exception.getMessage();
        }
        return new ResponseEntity<>(new Result(code, message), HttpStatus.valueOf(response.getStatus()));
    }

}
