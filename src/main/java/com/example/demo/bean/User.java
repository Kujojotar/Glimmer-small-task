package com.example.demo.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Validated
@Data
public class User {
    @NotNull(message = "注册用户名不可以为空")
    @Length(min=6,max = 26,message = "用户名")
    @Pattern(regexp = "^[0-9A-Za-z]+$",message = "用户名只能由数字和英文大小写字母组成")
    private String username;
    @NotNull(message = "注册密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$",message = "请输入正确格式的密码")
    private String password;
}
