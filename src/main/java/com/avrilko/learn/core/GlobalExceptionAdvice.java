package com.avrilko.learn.core;

import com.avrilko.learn.core.configuration.ExceptionCodeConfiguration;
import com.avrilko.learn.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.valueextraction.ExtractedValue;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest request, Exception exception) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();
        System.out.println(exception);
        return new UnifyResponse(9999, "服务器内部错误", method + " " + requestUrl);
    }

    @ExceptionHandler(HttpException.class)
    @ResponseBody
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request, HttpException exception) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();

        UnifyResponse message = new UnifyResponse(exception.getCode(), codeConfiguration.getMessage(exception.getCode()), method + " " + requestUrl);
        HttpStatus httpStatus = HttpStatus.resolve(exception.getHttpStatusCode());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(message, httpHeaders, httpStatus);
        return r;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanValidation(HttpServletRequest request, MethodArgumentNotValidException exception) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();

        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        String message = this.formatAllErrorMessage(errors);
        return new UnifyResponse(10001, message, method + " " + requestUrl);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintViolationException(HttpServletRequest request, ConstraintViolationException exception) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();
        return new UnifyResponse(10001, exception.getMessage(), method + " " + requestUrl);
    }

    private String formatAllErrorMessage(List<ObjectError> errors) {
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(error ->
                errorMsg.append(error.getDefaultMessage()).append(";")
        );
        return errorMsg.toString();
    }
}
