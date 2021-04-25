package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Validated
@Data
public class TodoList {
    @JsonProperty("TodoId")
    private Integer todoId;
    @NotNull(message = "标题不能为空")
    @JsonProperty("Title")
    private String title;
    @JsonProperty("StartTime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonProperty("Done")
    private Boolean done;
    @JsonProperty("Username")
    @NotNull(message = "用户名不能为空")
    private String username;
}
