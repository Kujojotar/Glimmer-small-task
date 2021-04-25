package com.example.demo.controller;

import com.example.demo.bean.ResponseObject;
import com.example.demo.bean.User;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.util.JsonTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class UserLoginController {
    @Autowired
    UserServiceImpl service;

    @GetMapping("/users/login")
    @ResponseBody
    public Object he(User user){
        ResponseObject response=new ResponseObject();
        char t=service.examineUser(user);
        System.out.println(t);
        if(t=='n'){
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("用户不存在");
            response.setData(null);
            return JsonTransfer.ObjectToJason(response);
        }
        if(t=='f'){
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("密码错误");
            response.setData(null);
            return JsonTransfer.ObjectToJason(response);
        }
        response.setCode(200);
        response.setSuccess(true);
        response.setMsg("success");
        response.setData("成功");
        return JsonTransfer.ObjectToJason(response);
    }
}
