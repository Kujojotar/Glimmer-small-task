package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
public class Info {
    @JsonProperty("InfoId")
    private Integer infoId;
    @JsonProperty("Title")
    @NotNull(message = "标题不能为空")
    @Length(max =20,message = "标题长度超出范围啦")
    private String title;
    @JsonProperty("Content")
    @NotNull(message = "内容不能为空")
    @Length(max = 60,message = "内容长度超出范围啦")
    private String content;
    @JsonProperty("StartTime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonProperty("Username")
    @NotNull(message = "用户名不能为空")
    private String username;
}
