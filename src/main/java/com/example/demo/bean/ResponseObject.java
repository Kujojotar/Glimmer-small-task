package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(value= PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class ResponseObject {

    @JsonProperty("Code")
    private Integer code;
    @JsonProperty("Msg")
    private String msg;
    @JsonProperty("Success")
    private Boolean success;
    @JsonProperty("Data")
    private Object data;
}
