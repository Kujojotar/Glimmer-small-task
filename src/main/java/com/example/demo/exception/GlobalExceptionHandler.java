package com.example.demo.exception;

import com.example.demo.bean.ResponseObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(org.springframework.validation.BindException.class)
    @ResponseBody
    @CrossOrigin
    public Object handlerBindingException(Exception ex){
        org.springframework.validation.BindException bex=(org.springframework.validation.BindException) ex;
        String field=bex.getFieldError().getField();
        String cause=bex.getFieldError().getDefaultMessage();
        ResponseObject response=new ResponseObject();
        System.out.println(field+":"+cause);
        response.setCode(400);
        response.setSuccess(false);
        response.setMsg(cause);
        response.setData(null);
        return response;
    }






}
