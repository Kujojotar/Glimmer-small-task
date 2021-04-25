package com.example.demo.controller;

import com.example.demo.bean.ResponseObject;
import com.example.demo.bean.User;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.util.JsonTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserRegisterController {
    @Autowired
    UserServiceImpl service;

    @GetMapping("/users/register")
    @ResponseBody
    @CrossOrigin
    public Object registerUser(@Validated User user){
        ResponseObject response=new ResponseObject();
        if(service.addUser(user)){
            response.setCode(200);
            response.setSuccess(true);
            response.setMsg("success");
            response.setData("注册成功");
        }else{
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("注册失败了，可能是该用户已存在");
            response.setData(null);
        }
        return JsonTransfer.ObjectToJason(response);
    }
}
